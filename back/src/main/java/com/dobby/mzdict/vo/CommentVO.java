package com.dobby.mzdict.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
public class CommentVO {
    private int id;
    private String commentText;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private int wordId;
    private int userId;
}
