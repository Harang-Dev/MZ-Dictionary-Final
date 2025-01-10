package com.dobby.mzdict.dto;

import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentUpdateDTO {
    private int id;
    private String commentText;
}
