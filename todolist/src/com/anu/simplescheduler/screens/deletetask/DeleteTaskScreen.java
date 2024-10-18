package com.anu.simplescheduler.screens.deletetask;

import com.anu.simplescheduler.BaseScreen;
import java.util.Scanner;

public class DeleteTaskScreen extends BaseScreen {
    private final DeleteTaskViewModel viewModel = new DeleteTaskViewModel();

    @Override
    public void show() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the ID of the task you want to delete: ");
        int id = scanner.nextInt();

        boolean success = viewModel.deleteTask(id);
        if (success) {
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Task with ID " + id + " not found.");
        }
    }
}
