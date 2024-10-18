package com.anu.simplescheduler.dto;

public class Task {
    private int id;
    private String description;
    private int priority; 
    private boolean isCompleted;

    // No-arg
    public Task() {
        this.description = "";
        this.priority = 3; // Default - Low priority
        this.isCompleted = false; // Default - not completed
    }
    // Parameterized 
    public Task(String description, int priority) {
        this.description = description;
        this.priority = priority;
        this.isCompleted = false; // Default - not completed
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
