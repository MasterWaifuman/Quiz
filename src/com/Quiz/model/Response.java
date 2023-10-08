package com.Quiz.model;

public class Response {

    int id;
    String text;
    boolean correct;

    public Response() {}

    public Response(String text, boolean correct) {
        this.text = text;
        this.correct = correct;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    @Override
    public String toString() {
        return text + " = " + correct;
    }
}
