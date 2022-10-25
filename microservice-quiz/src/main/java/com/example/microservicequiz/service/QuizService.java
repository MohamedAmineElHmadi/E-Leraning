package com.example.microservicequiz.service;

import com.example.microservicequiz.entity.Quiz;

import java.util.List;

public interface QuizService {
    Quiz addQuiz (Quiz e);
    Quiz update(Quiz quiz, Long id);
    void delete(long id);
    List<Quiz> findAll();
    Quiz findbyid (Long id);
}
