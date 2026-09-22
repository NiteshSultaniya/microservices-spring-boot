package com.springmicroservices.quiz_service.controller;

import com.springmicroservices.quiz_service.entity.QuizEntity;
import com.springmicroservices.quiz_service.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/create-quiz")
    public ResponseEntity<?> createQuiz(@RequestBody QuizEntity quiz) {
        Map<String, Object> obj = new HashMap<>();
        try {
            QuizEntity newQuiz =quizService.createQuiz(quiz);
            obj.put("message", "Quiz created successfully");
            obj.put("data", newQuiz);
            return ResponseEntity.ok(obj);
        } catch (Exception e) {
            obj.put("error", e.getMessage());
            return ResponseEntity.ok(obj);
        }
    }

    @GetMapping("/all-quiz")
    public ResponseEntity<?> allQuiz() {
        Map<String, Object> obj = new HashMap<>();
        try {
            List<QuizEntity> quizzes =quizService.allQuiz();
            obj.put("message", "Quizzes fetched successfully");
            obj.put("data", quizzes);
            return ResponseEntity.ok(obj);
        } catch (Exception e) {
            obj.put("error", e.getMessage());
            return ResponseEntity.ok(obj);
        }
    }


    @GetMapping("/quiz/{id}")
    public ResponseEntity<?> getQuizById(
            @PathVariable Long id) {
        Map<String, Object> obj = new HashMap<>();
        try {
           QuizEntity quiz =quizService.getQuizById(id);
            if (quiz!=null) {
                obj.put("message", "Quiz fetched successfully");
                obj.put("data", quiz);
            } else {
                obj.put("message", "Quiz not found");
            }
            return ResponseEntity.ok(obj);
        } catch (Exception e) {
            obj.put("error", e.getMessage());
            return ResponseEntity.ok(obj);
        }
    }


    @PutMapping("/update-quiz/{id}")
    public ResponseEntity<?> updateQuiz(@PathVariable Long id,@RequestBody QuizEntity quiz) {
        Map<String, Object> obj = new HashMap<>();
        try {
            QuizEntity updatedQuiz =quizService.updateQuiz(id, quiz);
            if (updatedQuiz != null) {
                obj.put("message", "Quiz updated successfully");
                obj.put("data", updatedQuiz);

            } else {
                obj.put("message", "Quiz not found");
            }
            return ResponseEntity.ok(obj);
        } catch (Exception e) {
            obj.put("error", e.getMessage());
            return ResponseEntity.ok(obj);
        }
    }


    @DeleteMapping("/delete-quiz/{id}")
    public ResponseEntity<?> deleteQuiz(@PathVariable Long id) {
        Map<String, Object> obj = new HashMap<>();
        try {
            boolean deleted =quizService.deleteQuiz(id);
            if (deleted) {
                obj.put("message", "Quiz deleted successfully");
            } else {
                obj.put("message", "Quiz not found");
            }
            return ResponseEntity.ok(obj);
        } catch (Exception e) {
            obj.put("error", e.getMessage());
            return ResponseEntity.ok(obj);
        }
    }
}
