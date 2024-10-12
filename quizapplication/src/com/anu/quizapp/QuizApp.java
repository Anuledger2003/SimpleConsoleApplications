package com.anu.quizapp;

import com.anu.quizapp.screens.addquiz.AddQuizScreen;
import com.anu.quizapp.screens.takequiz.TakeQuizScreen;
import com.anu.quizapp.screens.results.ResultsScreen;

import java.util.Scanner;

public class QuizApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Quiz Application");
            System.out.println("1. Add Quiz Questions");
            System.out.println("2. Take Quiz");
            System.out.println("3. View Results");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    new AddQuizScreen().start();
                    break;
                case 2:
                    new TakeQuizScreen().start();
                    break;
                case 3:
                    new ResultsScreen().start();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
