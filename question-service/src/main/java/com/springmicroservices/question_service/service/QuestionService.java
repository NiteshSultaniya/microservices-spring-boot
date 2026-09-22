package com.springmicroservices.question_service.service;

import com.springmicroservices.question_service.entity.QuestionEntity;
import com.springmicroservices.question_service.repo.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public QuestionEntity createQuestion(QuestionEntity question) {
        return questionRepository.save(question);
    }

    public List<QuestionEntity> allQuestion() {
        return questionRepository.findAll();
    }

    public Optional<QuestionEntity> getQuestionById(Long questionId) {
        return questionRepository.findById(questionId);
    }


    public QuestionEntity updateQuestion(Long questionId, QuestionEntity question) {
        Optional<QuestionEntity> oldQuestion =
                questionRepository.findById(questionId);
        if (oldQuestion.isPresent()) {
            QuestionEntity existingQuestion = oldQuestion.get();
            existingQuestion.setQuestion(question.getQuestion());
            existingQuestion.setQuizId(question.getQuizId());
            return questionRepository.save(existingQuestion);
        }
        return null;
    }

    public boolean deleteQuestion(Long questionId) {
        Optional<QuestionEntity> question =
                questionRepository.findById(questionId);
        if (question.isPresent()) {
            questionRepository.deleteById(questionId);
            return true;
        }
        return false;
    }

    public List<QuestionEntity> getQuestionByQuizId(Long quizid) {
        System.out.println(quizid);
        List<QuestionEntity> quizdata = questionRepository.findByQuizId(quizid);
        quizdata.stream().forEach(data->
            System.out.println(data)
        );
        return quizdata;
    }
}