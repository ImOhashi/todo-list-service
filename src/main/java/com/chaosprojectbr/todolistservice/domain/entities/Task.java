package com.chaosprojectbr.todolistservice.domain.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Task {

    @Id
    private ObjectId _id;

    private String title;
    private String subtitle;
    private String description;
    private User user;

    private static class User {
        private String user;
        private String email;
        private String description;
    }
}
