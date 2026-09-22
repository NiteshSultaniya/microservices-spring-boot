package com.springmicroservices.quiz_service.service;

import com.springmicroservices.quiz_service.entity.QuizEntity;
import com.springmicroservices.quiz_service.repo.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    private QuizRepository quizRepository;
    private QuestionClient questionClient;

    public QuizService(QuestionClient questionClient,QuizRepository quizRepository){
        this.questionClient=questionClient;
        this.quizRepository=quizRepository;
    }

    public QuizEntity createQuiz(QuizEntity quiz) {
        return quizRepository.save(quiz);
    }

    public List<QuizEntity> allQuiz() {
        return quizRepository.findAll();
    }

    public QuizEntity getQuizById(Long id) {
        QuizEntity quizEntityy=quizRepository.findById(id).orElseThrow();
//        Q questionentitytt=questionClient.getQuestionBYQuizId(quizEntityy.getId());
//        System.out.println(questionentitytt);
        quizEntityy.setQuestions(questionClient.getQuestionBYQuizId(quizEntityy.getId()));
        return quizEntityy;
    }

    public QuizEntity updateQuiz(Long id, QuizEntity quiz) {
        Optional<QuizEntity> oldQuiz = quizRepository.findById(id);
        if (oldQuiz.isPresent()) {
            QuizEntity existingQuiz = oldQuiz.get();
            existingQuiz.setTitle(quiz.getTitle());
            return quizRepository.save(existingQuiz);
        }
        return null;
    }

    public boolean deleteQuiz(Long id) {
        Optional<QuizEntity> quiz = quizRepository.findById(id);
        if (quiz.isPresent()) {
            quizRepository.deleteById(id);
            return true;
        }
        return false;
    }
}