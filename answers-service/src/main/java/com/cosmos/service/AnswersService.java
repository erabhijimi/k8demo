package com.cosmos.service;

import com.cosmos.error.AnswerNotFoundException;
import com.cosmos.model.Answer;
import com.cosmos.pojo.Answers;
import com.cosmos.repository.AnswersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AnswersService {
    @Autowired
    private AnswersRepository answersRepository;

    public Answer saveAnswer(Answer answer) {
        log.info("saveAnswer is called");
        return answersRepository.save(answer);
    }

    public Answers getAllAnswers(Long questionId) {
        log.info("getAllAnswers is called for Question: "+questionId);
        List<Answer> answers = answersRepository.findAllByQuestionId(questionId);
        return new Answers(answers);
    }

    public Answer getAnswerById(Long answerId) {
        log.info("getAnswerById is called for AnswerId: "+answerId);
        Optional<Answer> answer = answersRepository.findById(answerId);
        if(!answer.isPresent())
            throw new AnswerNotFoundException("Answer not Available..");
        return answer.get();
    }

    public String updateAnswerById(Long answerId, Answer answer) {
        Optional<Answer> answerOld = answersRepository.findById(answerId);
        if(!answerOld.isPresent())
            return "Answer not present..";
        answer.setAnswerId(answerId);
        answersRepository.save(answer);
        log.info("Answer updated successfully... "+answer.toString());
        return "Answer updated successfully...";
    }

    public String deleteAnswerById(Long answerId) {
        Optional<Answer> answerOld = answersRepository.findById(answerId);
        if(!answerOld.isPresent())
            return "Answer not present..";
        answersRepository.deleteById(answerId);
        log.info("Answer deleted successfully... "+answerId);
        return "Answer deleted successfully...";
    }
}
