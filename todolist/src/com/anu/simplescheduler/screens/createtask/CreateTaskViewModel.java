package com.anu.simplescheduler.screens.createtask;

import com.anu.simplescheduler.datalayer.TaskRepository;
import com.anu.simplescheduler.dto.Task;

public class CreateTaskViewModel {
    private final TaskRepository repository = TaskRepository.getInstance();

    public void createTask(String description, int priority) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Task description cannot be empty");
        }

        Task task = new Task();
        task.setDescription(description);
        task.setPriority(priority);
        task.setCompleted(false);
        repository.addTask(task);
    }
}
