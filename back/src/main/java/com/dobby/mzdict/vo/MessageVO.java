package com.dobby.mzdict.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MessageVO {
    private String role;
    private String content;
}
