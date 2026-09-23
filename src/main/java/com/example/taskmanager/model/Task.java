package com.example.taskmanager.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity

public class Task {
    @Id
    @GeneratedValue
    private int id;
    @NotBlank(message = "Title is required")
    private String title;
    @NotBlank(message = "Description is required")
    private String description;
    private boolean completed;

    public Task() {
    }

    public Task( String title, String description, boolean completed){

        this.title=title;
        this.description=description;
        this.completed=completed;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public  String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public boolean isCompleted(){
        return completed;
    }
    public void setCompleted(boolean completed){
        this.completed=completed;
    }
}
