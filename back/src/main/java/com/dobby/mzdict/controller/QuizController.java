package com.dobby.mzdict.controller;

import com.dobby.mzdict.dto.UserQuizDTO;
import com.dobby.mzdict.model.CommonResult;
import com.dobby.mzdict.model.ListResult;
import com.dobby.mzdict.model.SingleResult;
import com.dobby.mzdict.service.QuizService;
import com.dobby.mzdict.service.UserService;
import com.dobby.mzdict.service.security.ResponseService;
import com.dobby.mzdict.vo.QuizVO;
import com.dobby.mzdict.vo.UserQuizVO;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/quiz")
public class QuizController implements QuizControllerDocs{
    private final QuizService quizService;
    private final ResponseService responseService;
    private final UserService userService;

    public QuizController(QuizService quizService, ResponseService responseService, UserService userService) {
        this.quizService = quizService;
        this.responseService = responseService;
        this.userService = userService;
    }

    @Override
    @PostMapping("/add")
    public SingleResult<Boolean> addQuiz(String token, QuizVO QuizInfo) {
        LocalDateTime now = LocalDateTime.now();
        QuizInfo.setCreateTime(now);
        QuizInfo.setUseStatus(false);

        return responseService.getSingleResult(quizService.addQuiz(QuizInfo));
    }

    @Override
    @PutMapping("/update")
    public SingleResult<Boolean> updateQuiz(String token, QuizVO QuizInfo) {
        return responseService.getSingleResult(quizService.updateQuiz(QuizInfo));
    }

    @Override
    @DeleteMapping("/delete")
    public SingleResult<Boolean> deleteQuiz(String token, int QuizId) {
        return responseService.getSingleResult(quizService.deleteQuiz(QuizId));
    }

    @Override
    @GetMapping("/get")
    public SingleResult<QuizVO> getQuizById(String token, int QuizId) {
        return responseService.getSingleResult(quizService.getQuizById(QuizId));
    }

    @Override
    @GetMapping("/get/list")
    public ListResult<QuizVO> getQuizs(String token) {
        return responseService.getListResult(quizService.getQuizs());
    }

    @Override
    @GetMapping("/get/today")
    public SingleResult<QuizVO> getTodayQuiz(String token) {
        return responseService.getSingleResult(quizService.getTodayQuiz());
    }

    @Override
    @PostMapping("/resolve")
    public CommonResult userResolveQuiz(String token, UserQuizDTO QuizDTO) {
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        int id = userService.getUserByUserId(userId).getId();

        QuizVO quizVO = quizService.getQuizById(QuizDTO.getQuizId());
        if (quizVO.isQuizAnswer() == QuizDTO.isUserAnswer()) {
            UserQuizVO vo = new UserQuizVO(id, QuizDTO.getQuizId(), true);
            return responseService.getSingleResult(quizService.resolveQuiz(vo));
        } else {
            return responseService.getFailResult(400, "오답입니다");
        }
    }

    @Override
    @GetMapping("/check")
    public CommonResult isQuiz(String token, int quizId) {
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        int id = userService.getUserByUserId(userId).getId();

        UserQuizVO vo = new UserQuizVO(id, quizId, false);
        boolean result = quizService.isQuiz(vo);

        if (result) {
            return responseService.getSingleResult(true);
        } else {
            return responseService.getFailResult(-1, "이미 풀이가 완료된 사용자입니다.");
        }
    }
}
