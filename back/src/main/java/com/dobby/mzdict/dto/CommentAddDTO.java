package com.dobby.mzdict.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CommentAddDTO {
    private String commentText;
    private int wordId;
}
