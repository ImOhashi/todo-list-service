package com.chaosprojectbr.todolistservice.domain.services.impl;

import com.chaosprojectbr.todolistservice.application.web.payloads.request.TaskRequest;
import com.chaosprojectbr.todolistservice.domain.entities.Task;
import com.chaosprojectbr.todolistservice.domain.entities.enums.STATUS;
import com.chaosprojectbr.todolistservice.domain.exceptions.TaskAlreadyExistsException;
import com.chaosprojectbr.todolistservice.domain.repositories.TaskRepository;
import com.chaosprojectbr.todolistservice.domain.services.TaskService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repository;

    private final KafkaTemplate<String, Serializable> kafkaTemplate;

    @Value("${spring.kafka.producer.topics.todo-list-topic.name}")
    private String todoListTopicName;

    public TaskServiceImpl(TaskRepository repository, KafkaTemplate<String, Serializable> kafkaTemplate) {
        this.repository = repository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public Task create(TaskRequest taskRequest) throws TaskAlreadyExistsException {
        if (repository.findTaskByTitleAndSubtitle(taskRequest.getTitle(), taskRequest.getSubtitle()).isPresent()) {
            throw new TaskAlreadyExistsException("Task with title=" + taskRequest.getTitle() +
                    " and subtitle=" + taskRequest.getSubtitle() + " already exists");
        }

        var task = new Task.Builder()
                .setTitle(taskRequest.getTitle())
                .setSubtitle(taskRequest.getSubtitle())
                .setDescription(taskRequest.getDescription())
                .setStatus(STATUS.TODO)
                .build();

        repository.save(task);
        kafkaTemplate.send(todoListTopicName, task);

        return task;
    }
}
