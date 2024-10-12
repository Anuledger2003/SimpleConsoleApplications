package com.anu.quizapp.screens.results;

import com.anu.quizapp.BaseScreen;
import com.anu.quizapp.datalayer.QuizRepository;

public class ResultsScreen extends BaseScreen {

    private ResultsViewModel viewModel = new ResultsViewModel();

    @Override
    public void start() {
        System.out.println("Your total score is: " + viewModel.getScore());
    }
}
