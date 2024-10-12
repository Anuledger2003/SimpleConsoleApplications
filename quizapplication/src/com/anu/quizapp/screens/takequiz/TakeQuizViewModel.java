package com.anu.quizapp.screens.takequiz;

import com.anu.quizapp.datalayer.QuizRepository;
import com.anu.quizapp.dto.Question;

import java.util.ArrayList;
import java.util.List;

public class TakeQuizViewModel {

    private QuizRepository repository = QuizRepository.getInstance();
    private List<Integer> userAnswers;  // Stores user answers for each question
    private int currentQuestionIndex;
    private boolean quizCompleted;
    private boolean quizSubmitted; // To track if the quiz has been submitted

    public void startQuiz() {
        // Initialize user answers
        userAnswers = new ArrayList<>();
        for (int i = 0; i < repository.getQuestions().size(); i++) {
            userAnswers.add(-1);  // -1 indicates unanswered
        }
        currentQuestionIndex = 0;
        quizCompleted = false;
        quizSubmitted = false; // Reset submitted state on quiz start
    }

    public boolean isQuizEmpty() {
        return repository.getQuestions().isEmpty();
    }

    public boolean isQuizCompleted() {
        return quizCompleted;
    }

    public boolean isQuizSubmitted() {
        return quizSubmitted; // Return the submitted state
    }

    public String getCurrentQuestionText() {
        return repository.getQuestions().get(currentQuestionIndex).getQuestion();
    }

    public String[] getCurrentQuestionOptions() {
        return repository.getQuestions().get(currentQuestionIndex).getOptions();
    }

    public int getNumberOfOptions() {
        return repository.getQuestions().get(currentQuestionIndex).getOptions().length;
    }

    public boolean isValidAnswer(int answer) {
        return answer >= 0 && answer < getNumberOfOptions();
    }

    public int getCurrentQuestionNumber() {
        return currentQuestionIndex + 1;
    }

    public void submitAnswer(int answer) {
        userAnswers.set(currentQuestionIndex, answer);
        currentQuestionIndex++;
        if (currentQuestionIndex >= repository.getQuestions().size()) {
            quizCompleted = true;
        }
    }

    public void goBackToQuestion(int questionIndex) {
        currentQuestionIndex = questionIndex;
        quizCompleted = false;  // Set to false as user is going back to re-answer
    }

    public boolean isValidQuestionNumber(int questionNumber) {
        return questionNumber > 0 && questionNumber <= repository.getQuestions().size();
    }

    public void submitQuiz() {
        int score = calculateScore();
        repository.setScore(score);
        quizSubmitted = true; // Mark the quiz as submitted
    }

    public int getScore() {
        return repository.getScore();
    }

    public int getTotalQuestions() {
        return repository.getQuestions().size();
    }

    private int calculateScore() {
        int score = 0;
        List<Question> questions = repository.getQuestions();
        for (int i = 0; i < questions.size(); i++) {
            if (questions.get(i).getCorrectAnswer() == userAnswers.get(i)) {
                score++;
            }
        }
        return score;
    }
}
