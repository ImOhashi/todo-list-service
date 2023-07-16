package com.chaosprojectbr.todolistservice.application.web.payloads.request;

public class TaskRequest {

    public TaskRequest(String title, String subtitle, String description) {
        this.title = title;
        this.subtitle = subtitle;
        this.description = description;
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
