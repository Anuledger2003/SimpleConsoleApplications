package com.anu.simplescheduler.screens.listtasks;

import com.anu.simplescheduler.dto.Task;
import com.anu.simplescheduler.BaseScreen;


public class ListTasksScreen extends BaseScreen {
    private final ListTasksViewModel viewModel = new ListTasksViewModel();

    @Override
    public void show() {
        for (Task task : viewModel.getAllTasks()) {
            System.out.println("Task ID: " + task.getId());
            System.out.println("Description: " + task.getDescription());
            System.out.println("Priority: " + task.getPriority());
            System.out.println("Completed: " + task.isCompleted());
            System.out.println("---------------");
        }
    }
}
