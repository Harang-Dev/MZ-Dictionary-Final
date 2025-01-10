package com.dobby.mzdict.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRegisterDTO {
    private String userId;
    private String userEmail;
    private String password;
    private String nickname;
}
