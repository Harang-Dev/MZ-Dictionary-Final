package com.dobby.mzdict.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiscussionVO {
    private int id;
    @JsonProperty("topic")
    private String topic;

    @JsonProperty("option1")
    private String option1;

    @JsonProperty("option2")
    private String option2;

    private Boolean useStatus;
    private LocalDateTime createTime;
}
