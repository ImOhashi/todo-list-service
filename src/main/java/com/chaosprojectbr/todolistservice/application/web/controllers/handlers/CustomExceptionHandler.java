package com.chaosprojectbr.todolistservice.application.web.controllers.handlers;

import com.chaosprojectbr.todolistservice.application.web.controllers.handlers.exceptions.ApiErrorMessage;
import com.chaosprojectbr.todolistservice.domain.exceptions.TaskAlreadyExistsException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorMessage> handleGenericException(TaskAlreadyExistsException exception, WebRequest request) {
        var apiErrorMessage = new ApiErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        return new ResponseEntity<>(apiErrorMessage, new HttpHeaders(), apiErrorMessage.getStatus());
    }

    @ExceptionHandler(TaskAlreadyExistsException.class)
    public ResponseEntity<ApiErrorMessage> handleTaskAlreadyExistsException(TaskAlreadyExistsException exception, WebRequest request) {
        var apiErrorMessage = new ApiErrorMessage(HttpStatus.CONFLICT, exception.getMessage());
        return new ResponseEntity<>(apiErrorMessage, new HttpHeaders(), apiErrorMessage.getStatus());
    }
}
