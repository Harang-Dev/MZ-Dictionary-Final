package com.dobby.mzdict.service;

import com.dobby.mzdict.mapper.DiscussionMapper;
import com.dobby.mzdict.mapper.QuizMapper;
import com.dobby.mzdict.vo.DiscussionVO;
import com.dobby.mzdict.vo.GPTRequestVO;
import com.dobby.mzdict.vo.GPTResponseVO;
import com.dobby.mzdict.vo.QuizVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
public class GPTService {

    private final DiscussionMapper discussionMapper;
    @Value("${gpt.model}")
    private String model;

    @Value("${gpt.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate;
    private final QuizMapper quizMapper;
//    private final DicussionMapper discussionMapper;

    private ObjectMapper objectMapper = new ObjectMapper();

    public GPTService(RestTemplate restTemplate, QuizMapper quizMapper, DiscussionMapper discussionMapper) {
        this.restTemplate = restTemplate;
        this.quizMapper = quizMapper;
        this.discussionMapper = discussionMapper;
    }

    @Transactional
    @Scheduled(cron = "0 0 0 * * *")
    public Boolean generateQuiz() {
        String prompt = "현재 시간을 기준으로 1~30대가 자주 사용하는 신조어를 활용한 OX 퀴즈 하나 만들어줘 " +
                "예제는 다음과 같아" +
                "예제: '군싹'은 '군침이 싹 돈다'의 줄임말이다." +
                "결과는 JSON 형식으로 반환해줘." +
                "또한 AI와 사회에 대한 주제는 제외해서 생성해줘." +
                "{" +
                "quiz_question: <퀴즈 문제>" +
                "quiz_answer: Boolean" +
                "}";
        LocalDateTime now = LocalDateTime.now();

        GPTRequestVO request = new GPTRequestVO(model, prompt, 0.8, 100, 1, 0, 0);
        GPTResponseVO responseVO = restTemplate.postForObject(
                apiUrl
                , request
                , GPTResponseVO.class
        );

        try {
            QuizVO quizVO = objectMapper.readValue(responseVO.getChoices().get(0).getMessage().getContent(), QuizVO.class);
            quizVO.setCreateTime(now);
            quizVO.setUseStatus(false);
            return quizMapper.addQuiz(quizVO);
        } catch (Exception e) {
            return null;
        }
    }

    @Transactional
    @Scheduled(cron = "0 0 0 * * *")
    public Boolean generateDiscussion() {
        LocalDateTime now = LocalDateTime.now();
        String prompt = "현재 시간을 기준으로 사용자가 흥미를 느낄만한 주제로 토론을 생성해줘." +
                "여기서 사용자는 1~20대 후반의 MZ세대를 기준으로 잡아줘." +
                "토론 주제는 간단하고 직관적이게 생성해줘." +
                "토론 주제는 하시나요? 와 같은 물음표가 아닌 ~~이다. 와 같이 마무리되는 문장으로 생성해줘." +
                "사용자는 '예' 또는 '아니오'로 대답할 수 있는 옵션을 선택해야 합니다." +
                "결과는 JSON 형식으로 반환해주세요." +
                "또한 AI와 사회에 대한 주제는 제외해서 생성해줘." +
                "{" +
                "topic: <토론 주제>" +
                "option1: <예 버튼 텍스트>" +
                "option2: <아니도 버튼 텍스트>" +
                "}";
        GPTRequestVO request = new GPTRequestVO(model, prompt, 0.8, 100, 1, 0, 0);
        GPTResponseVO responseVO = restTemplate.postForObject(apiUrl,request,GPTResponseVO.class);

        try {
            DiscussionVO discussionVO = objectMapper.readValue(responseVO.getChoices().get(0).getMessage().getContent(), DiscussionVO.class);
            discussionVO.setCreateTime(now);
            discussionVO.setUseStatus(false);
            return discussionMapper.addDiscussion(discussionVO);
        } catch (Exception e) {
            System.out.println("에러가 발생했다네요?");
            System.out.println(e.getMessage());
            return null;
        }
    }
}
