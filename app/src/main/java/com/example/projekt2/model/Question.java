package com.example.projekt2.model;

import java.util.List;

public class Question {
    public String question;
    public List<String> answers;
    public int correctIndex;

    public Question(String question, List<String> answers, int correctIndex) {
        this.question = question;
        this.answers = answers;
        this.correctIndex = correctIndex;
    }
}
