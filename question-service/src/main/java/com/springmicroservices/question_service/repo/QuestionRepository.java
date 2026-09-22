package com.springmicroservices.question_service.repo;

import com.springmicroservices.question_service.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionEntity, Long> {

//    List<QuestionEntity> findByQuestionId(Long questionId);

    List<QuestionEntity> findByQuizId(Long quizid);
}