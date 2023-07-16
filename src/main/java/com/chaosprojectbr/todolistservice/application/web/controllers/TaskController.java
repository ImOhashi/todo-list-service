package com.chaosprojectbr.todolistservice.application.web.controllers;

import com.chaosprojectbr.todolistservice.application.web.payloads.request.TaskRequest;
import com.chaosprojectbr.todolistservice.application.web.payloads.response.TaskResponse;
import com.chaosprojectbr.todolistservice.domain.exceptions.TaskAlreadyExistsException;
import com.chaosprojectbr.todolistservice.domain.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping
    public ResponseEntity<TaskResponse> create(
            @RequestBody TaskRequest taskRequest,
            UriComponentsBuilder uriComponentsBuilder
    ) throws TaskAlreadyExistsException {
        var uri = uriComponentsBuilder.path("/task").buildAndExpand(taskRequest.getTitle()).toUri();
        var task = service.create(taskRequest);
        return ResponseEntity.created(uri).body(new TaskResponse(task));
    }
}
