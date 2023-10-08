package com.Quiz.dao;

import com.Quiz.model.Question;
import com.Quiz.util.DatabaseConnection;
import com.Quiz.model.Response;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionDaoImplementation implements QuizDao<Question> {

    static Connection con = DatabaseConnection.getConnection();

    @Override
    public int create(Question question) throws SQLException {
        String query = "INSERT INTO questions(topic, difficulty, content, responses) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1, question.getTopic());
        preparedStatement.setInt(2, question.getDifficulty());
        preparedStatement.setString(3, question.getContent());
        preparedStatement.setString(4, question.getResponses().toString());
        return preparedStatement.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = "DELETE FROM questions WHERE ID = ?";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    @Override
    public Question get(int id) throws SQLException {
        String query = "SELECT * FROM questions WHERE id = ?";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setInt(1, id);
        Question question = new Question();
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean check = false;

        while (resultSet.next()) {
            check = true;
            question.setId(resultSet.getInt("id"));
            question.setTopic(resultSet.getString("topic"));
            question.setDifficulty(resultSet.getInt("difficulty"));
            question.setContent(resultSet.getString("content"));
            String[] responses = resultSet.getString("responses").split(", ");
            question.setResponses(responses);
        }

        if (check) {
            return question;
        }
        else return null;
    }

    @Override
    public List<Question> getAll() throws SQLException {
        String query = "SELECT * FROM questions";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Question> questionList = new ArrayList<>();

        while (resultSet.next()) {
            Question question = new Question();
            question.setId(resultSet.getInt("id"));
            question.setTopic(resultSet.getString("topic"));
            question.setDifficulty(resultSet.getInt("difficulty"));
            question.setContent(resultSet.getString("content"));
            String[] responses = resultSet.getString("responses").split(", ");
            question.setResponses(responses);
            questionList.add(question);
        }
        return questionList;
    }

    @Override
    public void update(Question question) throws SQLException {
        String query = "UPDATE questions SET topic = ?, difficulty = ?, content = ?, responses = ? WHERE id = ?";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1, question.getTopic());
        preparedStatement.setInt(2, question.getDifficulty());
        preparedStatement.setString(3, question.getContent());
        preparedStatement.setString(4, question.getResponses().toString());
        preparedStatement.setInt(5, question.getId());
        preparedStatement.executeUpdate();
    }

    @Override
    public List<Question> getByTopic(String topic) throws SQLException {
        String query = "SELECT * FROM questions WHERE topic = ?";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1, topic);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Question> questionList = new ArrayList<>();

        while (resultSet.next()) {
            Question question = new Question();
            question.setId(resultSet.getInt("id"));
            question.setTopic(resultSet.getString("topic"));
            question.setDifficulty(resultSet.getInt("difficulty"));
            question.setContent(resultSet.getString("content"));
            String[] responses = resultSet.getString("responses").split(", ");
            question.setResponses(responses);
            questionList.add(question);
        }
        return questionList;
    }
}
