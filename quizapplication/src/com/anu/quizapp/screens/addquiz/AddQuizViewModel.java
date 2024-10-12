package com.anu.quizapp.screens.addquiz;

import com.anu.quizapp.datalayer.QuizRepository;
import com.anu.quizapp.dto.Question;

public class AddQuizViewModel {

    private QuizRepository repository = QuizRepository.getInstance();

    public void addQuizQuestion(String question, String[] options, int correctAnswer) {
        Question newQuestion = new Question(question, options, correctAnswer);
        repository.addQuestion(newQuestion);
    }
}
