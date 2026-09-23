package com.example.taskmanager.service;
import com.example.taskmanager.exception.TaskNotFoundException;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        taskService = new TaskService(taskRepository);
    }

    @Test
    void createTaskShouldSaveTest() {
        Task task = new Task("Learn Java", "Study unit testing", false);
        when(taskRepository.save(task)).thenReturn(task);
        Task result = taskService.createTask(task);
        assertEquals(task, result);
    }
    @Test
    void getAllTasksShouldReturnAllTasks() {

        List<Task> tasks = List.of(
                new Task("Task 1", "Description 1", false),
                new Task("Task 2", "Description 2", true)
        );
        when(taskRepository.findAll()).thenReturn(tasks);
        List<Task> result = taskService.getAllTasks();
        assertEquals(tasks, result);
    }
    @Test
    void getTaskByIdShouldReturnTask() {

        Task task = new Task("Learn Spring", "Study Spring Boot", false);
        when(taskRepository.findById(1)).thenReturn(java.util.Optional.of(task));
        Task result = taskService.getTaskById(1);
        assertEquals(task, result);
    }
    @Test
    void getTaskByIdShouldThrowExceptionWhenTaskDoesNotExist() {

        when(taskRepository.findById(99)).thenReturn(java.util.Optional.empty());
        assertThrows(TaskNotFoundException.class, () -> taskService.getTaskById(99));
    }
    @Test
    void updateTaskShouldUpdateExistingTask() {

        Task existingTask = new Task("Old title", "Old description", false);
        Task updatedTask = new Task("New title", "New description", true);
        when(taskRepository.findById(1)).thenReturn(java.util.Optional.of(existingTask));
        when(taskRepository.save(existingTask)).thenReturn(updatedTask);
        Task result = taskService.updateTask(1, updatedTask);
        assertEquals(updatedTask, result);
        assertEquals("New title", existingTask.getTitle());
        assertEquals("New description", existingTask.getDescription());
        assertEquals(true, existingTask.isCompleted());
    }
    @Test
    void updateTaskShouldThrowExceptionWhenTaskDoesNotExist() {

        when(taskRepository.findById(99)).thenReturn(java.util.Optional.empty());
        Task updatedTask = new Task("New title", "New description", true);
        assertThrows(TaskNotFoundException.class, () -> taskService.updateTask(99, updatedTask));
    }
    @Test
    void deleteTaskShouldDeleteExistingTask() {

        Task existingTask = new Task("Task to delete", "This task will be deleted", false);
        when(taskRepository.findById(1)).thenReturn(java.util.Optional.of(existingTask));
        taskService.deleteTask(1);
        verify(taskRepository).delete(existingTask);
    }
}