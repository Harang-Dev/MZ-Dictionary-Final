package com.dobby.mzdict.vo;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentVO {
    private int id;
    private String commentText;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private int wordId;
    private int userId;
}
