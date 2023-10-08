package com.Quiz.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question {
    int id;
    String topic;
    int difficulty;
    String content;
    List<Response> responses;

    public Question() {}

    public Question(String topic, int difficulty, String content, List<Response> responses) {
        this.topic = topic;
        this.difficulty = difficulty;
        this.content = content;
        this.responses = responses;
    }

    public int getId() {
        return id;
    }

    public String getTopic() {
        return topic;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public String getContent() {
        return content;
    }

    public List<Response> getResponses() {
        return responses;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setResponses(List<Response> responses) {
        this.responses = responses;
    }

    public void setResponses(String[] responses) {
        List<Response> responsesList = new ArrayList<>();
        for (String response : responses) {
            String[] responseSplit = response.split(" = ");
            Response responseResult = new Response(responseSplit[0].replace("[", ""), Boolean.parseBoolean(responseSplit[1]));
            responsesList.add(responseResult);
        }
        this.responses = responsesList;
    }

    @Override
    public String toString(){
        return id + " " + topic + " " + difficulty + " " + content + " " + responses.toString();
    }
}
