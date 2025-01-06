package com.dobby.mzdict.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
public class CommentViewVO {
    private int commentId;
    private String commentText;
    private int commentUserId;
    private LocalDateTime commentTime;
    private int replyId;
    private String replyText;
    private int replyUserId;
    private LocalDateTime replyTime;
    private int commentReaction;
    private int replyReaction;
}
