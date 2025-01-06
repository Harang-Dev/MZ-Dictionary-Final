package com.dobby.mzdict.service;

import com.dobby.mzdict.mapper.QuizMapper;
import com.dobby.mzdict.vo.QuizVO;
import com.dobby.mzdict.vo.UserQuizVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuizService {
    private final QuizMapper mapper;

    public QuizService(QuizMapper mapper) {
        this.mapper = mapper;
    }

    @Transactional
    public boolean addQuiz(QuizVO quizVO) {
        return mapper.addQuiz(quizVO);
    }

    @Transactional
    public boolean updateQuiz(QuizVO quizVO) {
        return mapper.updateQuiz(quizVO);
    }

    public boolean deleteQuiz(int id) {
        return mapper.deleteQuiz(id);
    }

    public List<QuizVO> getQuizs() {
        return mapper.getQuizs();
    }

    public QuizVO getTodayQuiz() {
        return mapper.getTodayQuiz();
    }

    public QuizVO getQuizById(int id) {
        return mapper.getQuizById(id);
    }

    public boolean resolveQuiz(UserQuizVO userQuizVO) {
        return mapper.resolveQuiz(userQuizVO);
    }

    public boolean isQuiz(UserQuizVO userQuizVO) {
        UserQuizVO vo = mapper.isUserQuiz(userQuizVO);
        return vo == null;
    }
}
