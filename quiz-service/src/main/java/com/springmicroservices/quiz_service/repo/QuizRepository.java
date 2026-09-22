package com.springmicroservices.quiz_service.repo;

import com.springmicroservices.quiz_service.entity.QuizEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<QuizEntity, Long> {

}