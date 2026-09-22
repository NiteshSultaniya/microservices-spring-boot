package com.springmicroservices.question_service.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QuestionEntity
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long questionId;
    private  String question;
    @Nullable
    private  Long quizId;

}
