package com.example.microservicequiz.repo;

import com.example.microservicequiz.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepo extends JpaRepository<Quiz,Long> {
}
