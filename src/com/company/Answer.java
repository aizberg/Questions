package com.company;

public class Answer {
    private String answer;
    private boolean right;
    private String info;

    public Answer() {
    }

    String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

     boolean isRight() {
        return right;
    }

    String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    Answer(String answer, boolean right, String info) {
        this.answer = answer;
        this.right = right;
        this.info = info;
    }
}
