package com.example.microservicequiz.controller;

import com.example.microservicequiz.entity.Quiz;
import com.example.microservicequiz.service.QuizService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/Quiz/")
@AllArgsConstructor
public class QuizController {
    private  final QuizService quizService;
    @GetMapping("list")
    public List<Quiz> findAll() {
        return quizService.findAll();
    }
    @PostMapping( "save")
    public Quiz saveOption(@RequestBody Quiz e ){
        return    quizService.addQuiz(e);
    }
    @GetMapping("findById/{id}")
    public Quiz findById(@PathVariable("id") Long id) {
        return quizService.findbyid(id);
    }
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) throws Exception {
        quizService.delete(id);
    }
    @PutMapping("update/{id}")
    public Quiz update(@RequestBody Quiz e, @PathVariable("id") Long id) {
        Quiz updatedQuiz = quizService.update(e, id);
        return updatedQuiz;
    }
}
