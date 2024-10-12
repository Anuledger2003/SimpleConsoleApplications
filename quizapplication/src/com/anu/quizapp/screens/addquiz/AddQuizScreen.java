package com.anu.quizapp.screens.addquiz;

import com.anu.quizapp.BaseScreen;
import com.anu.quizapp.datalayer.QuizRepository;

import java.util.Scanner;

public class AddQuizScreen extends BaseScreen {

    private AddQuizViewModel viewModel = new AddQuizViewModel();

    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the question: ");
        String question = scanner.nextLine();
        System.out.print("Enter option 1: ");
        String option1 = scanner.nextLine();
        System.out.print("Enter option 2: ");
        String option2 = scanner.nextLine();
        System.out.print("Enter option 3: ");
        String option3 = scanner.nextLine();
        System.out.print("Enter option 4: ");
        String option4 = scanner.nextLine();
        System.out.print("Enter correct option (1-4): ");
        int correctAnswer = scanner.nextInt();

        viewModel.addQuizQuestion(question, new String[]{option1, option2, option3, option4}, correctAnswer - 1);
        System.out.println("Question added successfully!");
    }
}
