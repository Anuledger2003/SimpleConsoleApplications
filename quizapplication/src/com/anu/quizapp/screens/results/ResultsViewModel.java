package com.anu.quizapp.screens.results;

import com.anu.quizapp.datalayer.QuizRepository;

public class ResultsViewModel {

    private QuizRepository repository = QuizRepository.getInstance();

    public int getScore() {
        return repository.getScore();
    }
}
