package com.chaosprojectbr.todolistservice.domain.exceptions;

public class TaskAlreadyExistsException extends Exception {
    public TaskAlreadyExistsException(String message) {
        super(message);
    }
}
