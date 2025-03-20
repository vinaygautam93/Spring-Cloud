package com.vinay.quiz_service.controller;

import com.vinay.quiz_service.model.QuestionWrapper;
import com.vinay.quiz_service.model.QuizDto;
import com.vinay.quiz_service.model.Response;
import com.vinay.quiz_service.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Marks this class as a REST controller to handle HTTP requests
@RequestMapping("quiz") // Base URL for all endpoints in this controller
public class QuizController {

    @Autowired
    QuizService quizService; // Injecting QuizService to handle quiz-related logic

    @PostMapping("create") // Endpoint to create a new quiz
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto){
        return quizService.createQuiz(quizDto.getCategoryName(), quizDto.getNumQuestions(), quizDto.getTitle());
    }

    @GetMapping("get/{id}") // Endpoint to fetch quiz questions by quiz ID
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}") // Endpoint to submit answers and calculate the quiz score
    public ResponseEntity<Integer> getScore(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizService.calculateResult(id, responses);
    }
}
