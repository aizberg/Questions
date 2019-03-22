package com.company;

public class Question {
    private int number;
    private String question;
    private Answer answers[];

    Question() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    String getQuestion() {
        return question;
    }

    void setQuestion(String question) {
        this.question = question;
    }

    Answer[] getAnswers() {
        return answers;
    }

    void setAnswers(Answer[] answers) {
        this.answers = answers;
    }
}
