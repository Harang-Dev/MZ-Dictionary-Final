package com.dobby.mzdict.dto;

import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReactionDTO {
    private int targetId;
    private boolean reaction;
}
