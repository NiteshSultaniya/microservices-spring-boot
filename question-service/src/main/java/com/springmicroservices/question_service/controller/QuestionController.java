package com.springmicroservices.question_service.controller;

import com.springmicroservices.question_service.entity.QuestionEntity;
import com.springmicroservices.question_service.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;


    @PostMapping("/create-question")
    public ResponseEntity<?> createQuestion(@RequestBody QuestionEntity question) {
        Map<String, Object> obj = new HashMap<>();
        try {
            QuestionEntity newQuestion = questionService.createQuestion(question);
            obj.put("message", "Question created successfully");
            obj.put("data", newQuestion);
            return ResponseEntity.ok(obj);
        } catch (Exception e) {
            obj.put("error", e.getMessage());
            return ResponseEntity.ok(obj);
        }
    }


    @GetMapping("/all-question")
    public ResponseEntity<?> allQuestion() {
        Map<String, Object> obj = new HashMap<>();
        try {
            List<QuestionEntity> questions = questionService.allQuestion();
            obj.put("message", "Questions fetched successfully");
            obj.put("data", questions);
            return ResponseEntity.ok(obj);
        } catch (Exception e) {
            obj.put("error", e.getMessage());
            return ResponseEntity.ok(obj);
        }
    }


    @GetMapping("/question/{questionId}")
    public ResponseEntity<?> getQuestionById(@PathVariable Long questionId) {
        Map<String, Object> obj = new HashMap<>();
        try {
            Optional<QuestionEntity> question = questionService.getQuestionById(questionId);
            if (question.isPresent()) {

                obj.put("message", "Question fetched successfully");
                obj.put("data", question.get());
            } else {
                obj.put("message", "Question not found");
            }
            return ResponseEntity.ok(obj);
        } catch (Exception e) {
            obj.put("error", e.getMessage());
            return ResponseEntity.ok(obj);
        }
    }



    @PutMapping("/update-question/{questionId}")
    public ResponseEntity<?> updateQuestion(@PathVariable Long questionId, @RequestBody QuestionEntity question) {
        Map<String, Object> obj = new HashMap<>();
        try {
            QuestionEntity updatedQuestion = questionService.updateQuestion(questionId, question);
            if (updatedQuestion != null) {
                obj.put("message", "Question updated successfully");
                obj.put("data", updatedQuestion);
            } else {
                obj.put("message", "Question not found");
            }
            return ResponseEntity.ok(obj);
        } catch (Exception e) {
            obj.put("error", e.getMessage());
            return ResponseEntity.ok(obj);
        }
    }


    @DeleteMapping("/delete-question/{questionId}")
    public ResponseEntity<?> deleteQuestion(@PathVariable Long questionId) {
        Map<String, Object> obj = new HashMap<>();
        try {
            boolean deleted = questionService.deleteQuestion(questionId);
            if (deleted) {
                obj.put("message", "Question deleted successfully");
            } else {
                obj.put("message", "Question not found");
            }
            return ResponseEntity.ok(obj);
        } catch (Exception e) {
            obj.put("error", e.getMessage());
            return ResponseEntity.ok(obj);
        }
    }

    @GetMapping("/quiz/{quizid}")
    public List<QuestionEntity> getQuestionBYQuizId(@PathVariable Long quizid) {
        try {
            List<QuestionEntity> question = questionService.getQuestionByQuizId(quizid);

            return question;
        } catch (Exception e) {
            return null;
        }
    }
}
