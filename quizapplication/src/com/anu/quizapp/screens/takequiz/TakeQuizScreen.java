package com.anu.quizapp.screens.takequiz;

import com.anu.quizapp.BaseScreen;
import java.util.Scanner;

public class TakeQuizScreen extends BaseScreen {

    private TakeQuizViewModel viewModel = new TakeQuizViewModel();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void start() {
        if (viewModel.isQuizEmpty()) {
            System.out.println("No questions available! Please add questions before taking the quiz.");
            return;
        }

        // Initialize quiz
        viewModel.startQuiz();

        // Display questions and get user answers
        while (!viewModel.isQuizCompleted()) {
            displayCurrentQuestion();
            int userAnswer = getUserAnswer();
            viewModel.submitAnswer(userAnswer);
        }

        // Confirmation and handling submission
        handleQuizCompletion();
    }

    private void displayCurrentQuestion() {
        System.out.println("Question " + viewModel.getCurrentQuestionNumber() + ": " + viewModel.getCurrentQuestionText());
        String[] options = viewModel.getCurrentQuestionOptions();
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    private int getUserAnswer() {
        int answer;
        do {
            System.out.print("Your answer (choose 1 to " + viewModel.getNumberOfOptions() + "): ");
            answer = scanner.nextInt() - 1;
        } while (!viewModel.isValidAnswer(answer));

        return answer;
    }

    private void handleQuizCompletion() {
        // If the quiz has already been submitted
        if (viewModel.isQuizSubmitted()) {
            System.out.println("You completed the quiz! Your score is " + viewModel.getScore());
            System.out.println("Returning to the Quiz Application Menu...\n");
            return; // Exit to main menu
        }

        // If not submitted, show completion options
        boolean confirmed = false;
        while (!confirmed) {
            System.out.println("\nYou have completed all questions.");
            System.out.println("1. Submit the quiz");
            System.out.println("2. Go back to a specific question");
            System.out.print("Choose an option: "); // Removed the reset option
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewModel.submitQuiz();
                    System.out.println("You completed the quiz! Your score is " + viewModel.getScore());
                    confirmed = true;
                    System.out.println("Returning to the Quiz Application Menu...\n");
                    return; // Exit to main menu

                case 2:
                    int questionToGoBack = getQuestionToGoBack();
                    viewModel.goBackToQuestion(questionToGoBack);
                    reAnswerQuestion();
                    break;

                default:
                    System.out.println("Invalid option! Please choose again.");
            }
        }
    }

    private int getQuestionToGoBack() {
        int questionNumber;
        do {
            System.out.print("Which question would you like to go back to? (Choose between 1 and " + viewModel.getTotalQuestions() + "): ");
            questionNumber = scanner.nextInt();
        } while (!viewModel.isValidQuestionNumber(questionNumber));

        return questionNumber - 1;
    }

    private void reAnswerQuestion() {
        displayCurrentQuestion();
        int newAnswer = getUserAnswer();
        viewModel.submitAnswer(newAnswer);

        // After re-answering, go back to the completion menu again
        handleQuizCompletion();
    }
}
