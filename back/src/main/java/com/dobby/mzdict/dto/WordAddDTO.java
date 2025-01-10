package com.dobby.mzdict.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WordAddDTO {
    private String wordTitle;
    private String meaning;
    private String usingExample;
}
