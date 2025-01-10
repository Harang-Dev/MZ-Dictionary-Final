package com.dobby.mzdict.vo;

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

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime updateTime;

    private int userId;

    private boolean scrapped;
    private boolean liked;

}
