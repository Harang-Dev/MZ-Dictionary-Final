package com.dobby.mzdict.vo;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentReactionVO {
    private int userId;

    private int targetId;
    private int reaction;

    private LocalDateTime reactionTime;
}
