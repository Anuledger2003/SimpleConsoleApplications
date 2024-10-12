package com.anu.quizapp.datalayer;

import com.anu.quizapp.dto.Question;
import java.util.ArrayList;
import java.util.List;

public class QuizRepository {

    private static QuizRepository instance;
    private List<Question> questions = new ArrayList<>();
    private int score = 0;

    private QuizRepository() {}

    public static QuizRepository getInstance() {
        if (instance == null) {
            instance = new QuizRepository();
        }
        return instance;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
