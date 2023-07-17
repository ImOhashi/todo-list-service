package com.chaosprojectbr.todolistservice.application.web.payloads.response;

import com.chaosprojectbr.todolistservice.domain.entities.Task;
import com.chaosprojectbr.todolistservice.domain.entities.enums.STATUS;

public class TaskResponse {

    public TaskResponse(Task task) {
        this.title = task.getTitle();
        this.subtitle = task.getSubtitle();
        this.description = task.getDescription();
        this.status = task.getStatus();
    }

    private String title;
    private String subtitle;
    private String description;
    private STATUS status;

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getDescription() {
        return description;
    }

    public STATUS getStatus() {
        return status;
    }
}
