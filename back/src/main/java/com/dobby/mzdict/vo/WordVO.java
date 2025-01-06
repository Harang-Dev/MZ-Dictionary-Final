package com.dobby.mzdict.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
public class WordVO {
    private int id;
    private String wordTitle;
    private String meaning;
    private String usingExample;
    private int acceptStatus;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime updateTime;

    private int userId;
}
