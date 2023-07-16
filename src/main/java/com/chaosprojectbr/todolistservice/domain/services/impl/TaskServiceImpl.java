package com.chaosprojectbr.todolistservice.domain.services.impl;

import com.chaosprojectbr.todolistservice.application.web.payloads.request.TaskRequest;
import com.chaosprojectbr.todolistservice.domain.entities.Task;
import com.chaosprojectbr.todolistservice.domain.exceptions.TaskAlreadyExistsException;
import com.chaosprojectbr.todolistservice.domain.repositories.TaskRepository;
import com.chaosprojectbr.todolistservice.domain.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository repository;

    @Override
    public Task create(TaskRequest taskRequest) throws TaskAlreadyExistsException {
        if (repository.findTaskByTitleAndSubtitle(taskRequest.getTitle(), taskRequest.getSubtitle()).isPresent()) {
            throw new TaskAlreadyExistsException("Task with title=" + taskRequest.getTitle() +
                    " and subtitle=" + taskRequest.getSubtitle() + " already exists");
        }

        var task = new Task.Builder()
                .setTitle(taskRequest.getTitle())
                .setSubtitle(taskRequest.getSubtitle())
                .setDescription(taskRequest.getDescription())
                .build();

        repository.save(task);

        return task;
    }
}
