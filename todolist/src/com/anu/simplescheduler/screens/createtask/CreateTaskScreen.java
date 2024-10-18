package com.anu.simplescheduler.screens.createtask;

import com.anu.simplescheduler.datalayer.TaskRepository;
import com.anu.simplescheduler.dto.Task;
import com.anu.simplescheduler.BaseScreen;


import java.util.Scanner;

public class CreateTaskScreen extends BaseScreen {
    private final CreateTaskViewModel viewModel = new CreateTaskViewModel();

    @Override
    public void show() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter task description: ");
        String description = scanner.nextLine();

        System.out.println("Enter task priority (1: High, 2: Medium, 3: Low): ");
        int priority = scanner.nextInt();

        viewModel.createTask(description, priority);

        System.out.println("Task created successfully.");
    }
}
