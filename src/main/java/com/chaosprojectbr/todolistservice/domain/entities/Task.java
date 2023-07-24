package com.chaosprojectbr.todolistservice.domain.entities;

import com.chaosprojectbr.todolistservice.domain.entities.enums.STATUS;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document("task_document")
public class Task implements Serializable {

    @PersistenceCreator
    public Task(ObjectId _id, String title, String subtitle, String description, STATUS status) {
        this._id = _id;
        this.title = title;
        this.subtitle = subtitle;
        this.description = description;
        this.status = status;
    }

    private Task(Builder builder) {
        this.title = builder.title;
        this.subtitle = builder.subtitle;
        this.description = builder.description;
        this.status = builder.status;
    }

    @Id
    private ObjectId _id;

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

    public static class Builder {

        private String title;
        private String subtitle;
        private String description;

        private STATUS status;

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

        public Builder setStatus(STATUS status) {
            this.status = status;
            return this;
        }
    }
}
