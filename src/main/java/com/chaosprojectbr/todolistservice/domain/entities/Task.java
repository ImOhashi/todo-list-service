package com.chaosprojectbr.todolistservice.domain.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("task_document")
public class Task {

    public Task(Builder builder) {
        this.title = builder.title;
        this.subtitle = builder.subtitle;
        this.description = builder.description;
    }

    @Id
    private ObjectId _id;

    private String title;
    private String subtitle;
    private String description;

    static class Builder {

        private String title;
        private String subtitle;
        private String description;

        public Task build() {
            return new Task(this);
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setSubtitle(String subtitle) {
            this.subtitle = subtitle;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }
    }
}
