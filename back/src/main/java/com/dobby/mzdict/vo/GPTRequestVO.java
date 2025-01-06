package com.dobby.mzdict.vo;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.logging.log4j.message.Message;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class GPTRequestVO {
    private String model;
    private List<MessageVO> messages;
    private double temperature;
    private int maxTokens;
    private int topP;
    private int frequencyPenalty;
    private int presencePenalty;

    public GPTRequestVO(String model,
                        String prompt,
                        double temperature,
                        int maxTokens,
                        int topP,
                        int frequencyPenalty,
                        int presencePenalty) {
        this.model = model;
        this.messages = new ArrayList<>();
        this.messages.add(new MessageVO("user", prompt));
        this.temperature = temperature;
        this.maxTokens = maxTokens;
        this.topP = topP;
        this.frequencyPenalty = frequencyPenalty;
        this.presencePenalty = presencePenalty;
    }
}
