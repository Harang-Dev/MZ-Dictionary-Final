package com.dobby.mzdict.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserQuizVO {
    private int userId;
    private int quizId;
    private boolean isQuiz;
}
