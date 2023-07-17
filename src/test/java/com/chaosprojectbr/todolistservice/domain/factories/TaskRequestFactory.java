package com.chaosprojectbr.todolistservice.domain.factories;

import com.chaosprojectbr.todolistservice.application.web.payloads.request.TaskRequest;

public class TaskRequestFactory {
    public static TaskRequest sample() {
        return new TaskRequest(
                "dummy",
                "dummy",
                "dummy"
        );
    }
}
