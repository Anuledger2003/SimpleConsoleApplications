package com.anu.simplescheduler.screens.listtasks;

import com.anu.simplescheduler.datalayer.TaskRepository;
import com.anu.simplescheduler.dto.Task;

import java.util.List;

public class ListTasksViewModel {
    private final TaskRepository repository = TaskRepository.getInstance();

    public List<Task> getAllTasks() {
        return repository.getAllTasks(); // List all tasks
    }
}
