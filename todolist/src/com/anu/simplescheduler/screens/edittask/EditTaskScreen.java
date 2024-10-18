package com.anu.simplescheduler.screens.edittask;

import java.util.Scanner;
import com.anu.simplescheduler.BaseScreen;


public class EditTaskScreen extends BaseScreen {
    private final EditTaskViewModel viewModel = new EditTaskViewModel();

    @Override
    public void show() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Task ID to edit: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume Newline

        System.out.print("Enter new task description (leave empty to keep current): ");
        String newDescription = scanner.nextLine();

        System.out.print("Enter new task priority (1: High, 2: Medium, 3: Low): ");
        int newPriority = scanner.nextInt();

        System.out.print("Is the task completed? (true/false): ");
        boolean isCompleted = scanner.nextBoolean();

        boolean success = viewModel.editTask(id, newDescription, newPriority, isCompleted);
        if (success) {
            System.out.println("Task updated successfully.");
        } else {
            System.out.println("Task with ID " + id + " not found.");
        }
    }
}
