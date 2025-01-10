package com.dobby.mzdict.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WordUpdateDTO {
    private int id;
    private String wordTitle;
    private String meaning;
    private String usingExample;
}
