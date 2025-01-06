package com.dobby.mzdict.service;

import com.dobby.mzdict.vo.GPTResponseVO;
import com.dobby.mzdict.vo.QuizVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class GPTServiceTest {
    @Autowired
    private GPTService gptService;

    @Test
    public void test() {
        System.out.println(gptService.generateQuiz());
        System.out.println(gptService.generateDiscussion());
    }
}
