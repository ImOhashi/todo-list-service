package com.chaosprojectbr.todolistservice.application.web.controllers;

import com.chaosprojectbr.todolistservice.application.web.payloads.request.TaskRequest;
import com.chaosprojectbr.todolistservice.domain.entities.Task;
import com.chaosprojectbr.todolistservice.domain.exceptions.TaskAlreadyExistsException;
import com.chaosprojectbr.todolistservice.domain.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Task> create(
            @RequestBody TaskRequest taskRequest,
            UriComponentsBuilder uriComponentsBuilder
    ) throws TaskAlreadyExistsException {
        var task = service.create(taskRequest);
        var uri = uriComponentsBuilder.path("/task").buildAndExpand(task).toUri();
        return ResponseEntity.created(uri).body(task);
    }
}
