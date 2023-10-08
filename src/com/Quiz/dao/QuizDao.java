package com.Quiz.dao;

import com.Quiz.model.Question;

import java.sql.SQLException;
import java.util.List;

public interface QuizDao<T> {

    int create(T t) throws SQLException;
    void delete(int id) throws SQLException;
    T get(int id) throws SQLException;
    List<T> getAll() throws SQLException;
    void update(T t) throws SQLException;
    List<T> getByTopic(String topic) throws SQLException;
}
