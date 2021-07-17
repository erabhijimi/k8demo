package com.cosmos.controller;

import com.cosmos.model.Answer;
import com.cosmos.pojo.Answers;
import com.cosmos.service.AnswersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answers")
public class AnswersController {
    @Autowired
    private AnswersService answersService;

    @PostMapping
    public Answer saveAnswer(@RequestBody Answer answer){
        return answersService.saveAnswer(answer);
    }
    @GetMapping("/question/{questionId}")
    public Answers getAllAnswers(@PathVariable Long questionId){
        return answersService.getAllAnswers(questionId);
    }
    @GetMapping("/{answerId}")
    public Answer getAnswerById(@PathVariable Long answerId){
        return answersService.getAnswerById(answerId);
    }
    @PutMapping("/{answerId}")
    public String updateAnswerById(@PathVariable Long answerId,@RequestBody Answer answer){
        return answersService.updateAnswerById(answerId,answer);
    }
    @DeleteMapping("/{answerId}")
    public String deleteAnswerById(@PathVariable Long answerId){
        return answersService.deleteAnswerById(answerId);
    }
}
