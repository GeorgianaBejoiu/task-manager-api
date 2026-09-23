package com.example.taskmanager.controller;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService=taskService;
    }

    @GetMapping("/hello")
    public String printMessage(){

        return "Hello from com.example.taskmanager.model.Task Manager!";
    }

    @GetMapping("/task/{id}")
    public Task getTaskById(@PathVariable int id){
        return taskService.getTaskById(id);
    }
    @GetMapping("/task")
    public List<Task> getAllTask(){return taskService.getAllTasks();}
    @PostMapping("/task")
    public Task createTask(@RequestBody @Valid Task task){return taskService.createTask(task);}
    @PutMapping("/task/{id}")
    public Task updateTask(@PathVariable int id, @RequestBody @Valid Task task){
        return taskService.updateTask(id, task);
    }
    @DeleteMapping("/task/{id}")
    public void deleteTask(@PathVariable int id){
        taskService.deleteTask(id);
    }
}
