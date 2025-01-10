package com.dobby.mzdict.vo;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentReplyVO {
    private int id;
    private int commentId;
    private int userId;
    private String replyText;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
