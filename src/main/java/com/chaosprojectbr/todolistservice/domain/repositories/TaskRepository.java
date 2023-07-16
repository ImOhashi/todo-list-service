package com.chaosprojectbr.todolistservice.domain.repositories;

import com.chaosprojectbr.todolistservice.domain.entities.Task;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, ObjectId> {
}
