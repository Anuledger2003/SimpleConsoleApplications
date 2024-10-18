package com.anu.simplescheduler.screens.edittask;

import com.anu.simplescheduler.datalayer.TaskRepository;
import com.anu.simplescheduler.dto.Task;

public class EditTaskViewModel {
    private final TaskRepository repository = TaskRepository.getInstance();

    public boolean editTask(int id, String newDescription, int newPriority, boolean isCompleted) {
        Task existingTask = repository.getTaskById(id);
        if (existingTask == null) {
            return false; // Task not found
        }

        if (newDescription != null && !newDescription.trim().isEmpty()) {
            existingTask.setDescription(newDescription);
        }
        existingTask.setPriority(newPriority);
        existingTask.setCompleted(isCompleted); // Completion status
        repository.updateTask(existingTask);
        return true; // Task updated successfully
    }
}
