package com.dobby.mzdict.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizVO {
    private int id;

    @JsonProperty("quiz_question")
    private String quizQuestion;

    @JsonProperty("quiz_answer")
    private boolean quizAnswer;

    private boolean useStatus;

    private LocalDateTime createTime;
}
