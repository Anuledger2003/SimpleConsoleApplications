package com.anu.simplescheduler;

import com.anu.simplescheduler.screens.createtask.CreateTaskScreen;
import com.anu.simplescheduler.screens.edittask.EditTaskScreen;
import com.anu.simplescheduler.screens.deletetask.DeleteTaskScreen;
import com.anu.simplescheduler.screens.listtasks.ListTasksScreen;

import java.util.Scanner;

public class SimpleScheduler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CreateTaskScreen createScreen = new CreateTaskScreen();
        EditTaskScreen editScreen = new EditTaskScreen();
        DeleteTaskScreen deleteScreen = new DeleteTaskScreen();
        ListTasksScreen listScreen = new ListTasksScreen();

        boolean running = true;

        while (running) {
            System.out.println("Welcome to SimpleScheduler -->");
            System.out.println("Add your DAILY TASK to improve your PRODUCTIVIY::	");
            System.out.println("1. Create Task");
            System.out.println("2. Edit Task");
            System.out.println("3. Delete Task");
            System.out.println("4. List Tasks");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createScreen.show();
                    break;
                case 2:
                    editScreen.show();
                    break;
                case 3:
                    deleteScreen.show();
                    break;
                case 4:
                    listScreen.show();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
