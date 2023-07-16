package com.chaosprojectbr.todolistservice.domain.repositories;

import com.chaosprojectbr.todolistservice.domain.entities.Task;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends MongoRepository<Task, ObjectId> {

    Optional<Task> findTaskByTitleAndSubtitle(String title, String subtitle);
}
