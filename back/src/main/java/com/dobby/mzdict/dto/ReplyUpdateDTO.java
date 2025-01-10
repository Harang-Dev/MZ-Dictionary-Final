package com.dobby.mzdict.dto;

import lombok.*;

@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReplyUpdateDTO {
    private int id;
    private String replyText;
}
