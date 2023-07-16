package com.chaosprojectbr.todolistservice.domain.services;

import com.chaosprojectbr.todolistservice.application.web.payloads.request.TaskRequest;
import com.chaosprojectbr.todolistservice.domain.entities.Task;
import com.chaosprojectbr.todolistservice.domain.exceptions.TaskAlreadyExistsException;

public interface TaskService {

    Task create(TaskRequest taskRequest) throws TaskAlreadyExistsException;
}
