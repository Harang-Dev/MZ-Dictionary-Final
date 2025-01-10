package com.dobby.mzdict.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WordDetailDTO {
    // 단어 데이터
    private int id;
    private String wordTitle;
    private String meaning;
    private String usingExample;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime wordCreatedAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime wordUpdatedAt;

    // 댓글 데이터
    private List<CommentDTO> comments = new ArrayList<>();

    // 좋아요 수
    private int likesCount;
    private boolean liked;

    // 스크랩 수
    private int scrapCount;
    private boolean scrapped;

    // 전체 댓글 수
    private int commentCount;

    @Getter
    @Setter
    public static class CommentDTO {
        private Long commentId;
        private String commentText;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime commentUpdatedAt;
        private String commentUserNickname;

        // 댓글에 달린 답글 데이터
        private List<ReplyDTO> replies = new ArrayList<>();

        // 댓글 리액션 수
        private int commentLikeCount;
        private int commentDislikeCount;
    }

    @Getter
    @Setter
    public static class ReplyDTO {
        private Long replyId;
        private String replyText;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime replyUpdatedAt;

        private String replyUserNickname;

        // 답글 리액션 수
        private int replyLikeCount;
        private int replyDislikeCount;
    }
}