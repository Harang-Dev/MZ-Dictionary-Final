package com.dobby.mzdict.mapper;

import com.dobby.mzdict.vo.QuizVO;
import com.dobby.mzdict.vo.UserQuizVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuizMapper {
    public boolean addQuiz(QuizVO quizVO);
    public boolean updateQuiz(QuizVO quizVO);
    public boolean deleteQuiz(int id);
    public List<QuizVO> getQuizs();
    public QuizVO getTodayQuiz();
    public QuizVO getQuizById(int id);
    public boolean resolveQuiz(UserQuizVO userQuizVO);
    public UserQuizVO isUserQuiz(UserQuizVO userQuizVO);
}
