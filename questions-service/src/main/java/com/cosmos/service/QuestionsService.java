package com.cosmos.service;

import com.cosmos.error.QuestionNotFoundException;
import com.cosmos.model.Question;
import com.cosmos.pojo.Answers;
import com.cosmos.pojo.QNA;
import com.cosmos.pojo.Questions;
import com.cosmos.repository.QuestionsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class QuestionsService {
    //Hardcoded url
    //private String answerUrl="http://localhost:8183/answers";
    private String answerUrl="http://ANSWERS-SERVICE/answers";

    @Autowired
    private QuestionsRepository questionsRepository;
    @Autowired
    private RestTemplate restTemplate;

    public Questions getAllQuestions() {
        log.info("getAllQuestions called");
        List<Question> questionList = questionsRepository.findAll();
        Questions questions = new Questions();
        questions.setQuestions(questionList);
        return questions;
    }

    public Question saveQuestion(Question question) {
        return questionsRepository.save(question);
    }

    public Question getQuestionById(Long questionId) {
        log.info("getQuestionById called "+questionId);
        Optional<Question> optionalQuestion = questionsRepository.findById(questionId);
        if(!optionalQuestion.isPresent())
            throw new QuestionNotFoundException("Question Not Available");
        return optionalQuestion.get();
    }

    public String deleteQuestion(Long questionId) {
        log.info("deleteQuestion called "+questionId);
        Optional<Question> optionalQuestion = questionsRepository.findById(questionId);
        if(!optionalQuestion.isPresent()){
            return "Question is not available..";
        }
        log.info("New Delete request for Question"+questionId);
        questionsRepository.delete(optionalQuestion.get());
        return "Question Deleted Successfully...";

    }

    public String updateQuestion(Long questionId, Question question) {
        log.info("updateQuestion called "+questionId);
        Optional<Question> optionalQuestion = questionsRepository.findById(questionId);
        if(!optionalQuestion.isPresent()){
            return "Question is not available..";
        }
        log.info("New Update request for Question"+question.toString());
        question.setQuestionId(questionId);
        questionsRepository.save(question);
        return "Question Updated Successfully...";
    }

    public QNA getAllAnswersForQuestion(Long questionId) {
        log.info("getAllAnswersForQuestion called "+questionId);
        Optional<Question> optionalQuestion = questionsRepository.findById(questionId);
        if(!optionalQuestion.isPresent())
            return new QNA();
        Question question = optionalQuestion.get();
        Answers answers = restTemplate.getForObject(answerUrl+"/question/"+questionId, Answers.class);
        return new QNA(question,answers);
    }
}
