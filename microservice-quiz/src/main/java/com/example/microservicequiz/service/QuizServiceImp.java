package com.example.microservicequiz.service;

import com.example.microservicequiz.entity.Quiz;
import com.example.microservicequiz.repo.QuizRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service

public class QuizServiceImp implements QuizService{
    private QuizRepo quizRepo;
    @Override
    public Quiz addQuiz(Quiz e) {
        return quizRepo.save(e);
    }

    @Override
    public Quiz update(Quiz quiz, Long id) {
        if( quizRepo.findById(id ).isPresent()){
            return  quizRepo.save(quiz);
        }
        else {
            return null;
        }
    }

    @Override
    public void delete(long id) {
    quizRepo.deleteById(id);
    }

    @Override
    public List<Quiz> findAll() {
        return quizRepo.findAll();
    }

    @Override
    public Quiz findbyid(Long id) {
        return quizRepo.findById(id).get();
    }
}
