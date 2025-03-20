package com.vinay.quiz_service.feign;

import com.vinay.quiz_service.model.QuestionWrapper;
import com.vinay.quiz_service.model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTION-SERVICE") // Feign client to communicate with the QUESTION-SERVICE
public interface QuizInterface {

    // Calls the "generate" API in QUESTION-SERVICE to get random question IDs
    @GetMapping("question/generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz
    (@RequestParam String categoryName, @RequestParam Integer numQuestions );

    // Calls the "getQuestions" API in QUESTION-SERVICE to fetch questions based on their IDs
    @PostMapping("question/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds);

    // Calls the "getScore" API in QUESTION-SERVICE to calculate the quiz score based on responses
    @PostMapping("question/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);
}
