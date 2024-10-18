package com.anu.simplescheduler.screens.deletetask;

import com.anu.simplescheduler.datalayer.TaskRepository;

public class DeleteTaskViewModel {
    private final TaskRepository repository = TaskRepository.getInstance();

    public boolean deleteTask(int id) {
        return repository.deleteTask(id); // Deleted Task
    }
}
