package com.chaosprojectbr.todolistservice.domain.services;

import com.chaosprojectbr.todolistservice.domain.exceptions.TaskAlreadyExistsException;
import com.chaosprojectbr.todolistservice.domain.factories.TaskFactory;
import com.chaosprojectbr.todolistservice.domain.factories.TaskRequestFactory;
import com.chaosprojectbr.todolistservice.domain.repositories.TaskRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TaskServiceTest {

    @Autowired
    private TaskService taskService;

    @MockBean
    private TaskRepository taskRepository;

    @Test
    @DisplayName("should be create a new task with success")
    void testCreateANewTaskWithSuccess() throws TaskAlreadyExistsException {
        var taskRequestMock = TaskRequestFactory.sample();

        doReturn(Optional.empty()).when(taskRepository).findTaskByTitleAndSubtitle(any(), any());

        var newTask = taskService.create(taskRequestMock);

        assertEquals(taskRequestMock.getTitle(), newTask.getTitle());
        assertEquals(taskRequestMock.getSubtitle(), newTask.getSubtitle());
        assertEquals(taskRequestMock.getDescription(), newTask.getDescription());
    }

    @Test
    @DisplayName("should be call an exception because already exists register")
    void testAlreadyExistsTaskException() {
        var taskRequestMock = TaskRequestFactory.sample();
        var taskMock = TaskFactory.sample();

        doReturn(Optional.of(taskMock)).when(taskRepository).findTaskByTitleAndSubtitle(any(), any());

        assertThrows(TaskAlreadyExistsException.class, () -> taskService.create(taskRequestMock));
    }
}
