package com.dobby.mzdict.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WordVO {
    private int id;
    private String wordTitle;
    private String meaning;
    private String usingExample;
    private int acceptStatus;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    private int userId;

    private int scrapCount;
    private boolean scrapped;

    private int likeCount;
    private boolean liked;

}
