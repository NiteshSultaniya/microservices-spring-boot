package com.springmicroservices.quiz_service.entity;

import lombok.*;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDTO {
    private  Long questionId;
    private  String question;
    private  Long quizId;
}
