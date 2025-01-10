package com.dobby.mzdict.vo;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentReactionVO {
    private int userId;

    private int targetId;
    private boolean reaction;

    private LocalDateTime reactionTime;
}
