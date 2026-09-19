package com.example.taskmanager.controller;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.service.TaskService;
import org.springframework.web.bind.annotation.*;

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
    public int discoverID(@PathVariable int id){
        return id;
    }
    @GetMapping("/task")
    public int returnid(@RequestParam int id){
        return id;
    }
    @PostMapping("/task")
    public Task createTask(@RequestBody Task task){return taskService.createTask(task);}
}
