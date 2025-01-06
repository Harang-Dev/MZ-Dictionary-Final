package com.dobby.mzdict.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
@AllArgsConstructor
public class ScrapVO {
    private int userId;
    private int wordId;
    private LocalDateTime scrapTime;
}
