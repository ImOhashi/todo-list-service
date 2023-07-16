package com.chaosprojectbr.todolistservice.application.web.payloads.response;

import com.chaosprojectbr.todolistservice.domain.entities.Task;

public class TaskResponse {

    public TaskResponse(Task task) {
        this.title = task.getTitle();
        this.subtitle = task.getSubtitle();
        this.description = task.getDescription();
    }

    private String title;

    private String subtitle;

    private String description;

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getDescription() {
        return description;
    }
}
