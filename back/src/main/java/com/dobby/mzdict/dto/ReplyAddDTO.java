package com.dobby.mzdict.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ReplyAddDTO {
    private String replyText;
    private int commentId;
}
