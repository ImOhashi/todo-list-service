package com.chaosprojectbr.todolistservice.application.web.controllers.handlers.exceptions;

import org.springframework.http.HttpStatus;

import java.util.List;

public class ApiErrorMessage {

    private HttpStatus status;
    private String error;

    public ApiErrorMessage(HttpStatus status, String error) {
        super();
        this.status = status;
        this.error = error;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }
}
