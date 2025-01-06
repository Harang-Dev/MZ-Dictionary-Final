package com.dobby.mzdict.vo;

import lombok.Data;

@Data
public class UserDiscussionVO {
    private int userId;
    private int discussionId;
    private Boolean stat;
}
