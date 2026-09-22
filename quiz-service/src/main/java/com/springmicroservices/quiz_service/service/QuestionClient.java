package com.springmicroservices.quiz_service.service;
import com.springmicroservices.quiz_service.entity.QuestionDTO;
import lombok.Data;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(url = "http://localhost:8080",value = "question-service")
@FeignClient(name = "QUESTION-SERVICE")
public interface QuestionClient {

    @GetMapping("/api/question/quiz/{quizid}")
    List<QuestionDTO> getQuestionBYQuizId(@PathVariable("quizid") Long id);
}
