package com.Quiz.test;

import com.Quiz.dao.QuestionDaoImplementation;
import com.Quiz.model.Question;
import com.Quiz.model.Response;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class QuestionDaoImplementationTest {

    //DaoImplementation
    QuestionDaoImplementation daoImplementation = new QuestionDaoImplementation();
    int index = 1;

    @org.junit.jupiter.api.Test
    @Order(1)
    void create() throws SQLException {

        //generate question 1
        Question question = new Question();
        question.setTopic("Geography");
        question.setDifficulty(1);
        question.setContent("What is the capital of Australia?");
        List<Response> responseList = new ArrayList<>();
        responseList.add(new Response("Sydney", false));
        responseList.add(new Response("Canberra", true));
        responseList.add(new Response("Melbourne", false));
        question.setResponses(responseList);
        //generate question 2
        Question question2 = new Question();
        question2.setTopic("Astrophysics");
        question2.setDifficulty(3);
        question2.setContent("What type star is the Sun?");
        List<Response> responseList2 = new ArrayList<>();
        responseList2.add(new Response("A", false));
        responseList2.add(new Response("G", true));
        responseList2.add(new Response("Yellow Dwarf", true));
        question2.setResponses(responseList2);

        //create
        daoImplementation.create(question);
        daoImplementation.create(question2);
    }

    @org.junit.jupiter.api.Test
    @Order(2)
    void get() throws SQLException {
        Question question = daoImplementation.get(index);
        System.out.println(question.toString());
    }

    @org.junit.jupiter.api.Test
    @Order(3)
    void getAll() throws SQLException {
        List<Question> questionList = daoImplementation.getAll();
        for (Question question : questionList) {
            System.out.println(question);
        }
    }

    @org.junit.jupiter.api.Test
    @Order(4)
    void update() throws SQLException {
        Question question = daoImplementation.get(index);
        question.setDifficulty(2);
        daoImplementation.update(question);
        System.out.println(question);
    }

    @org.junit.jupiter.api.Test
    @Order(5)
    void getByTopic() throws SQLException {
        String topic = "Geography";
        List<Question> questions = daoImplementation.getByTopic(topic);
        System.out.println(questions.toString());
    }

    @org.junit.jupiter.api.Test
    @Order(6)
    void delete() throws SQLException {
        daoImplementation.delete(index);
    }
}