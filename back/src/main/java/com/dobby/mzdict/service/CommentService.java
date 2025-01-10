package com.dobby.mzdict.service;

import com.dobby.mzdict.dto.CommentAddDTO;
import com.dobby.mzdict.dto.CommentUpdateDTO;
import com.dobby.mzdict.mapper.CommentMapper;
import com.dobby.mzdict.vo.CommentVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentService {
    private final CommentMapper mapper;

    public CommentService(CommentMapper mapper) {
        this.mapper = mapper;
    }

    public CommentVO getCommentById(int id){
        return mapper.getCommentById(id);
    }

    @Transactional
    public CommentAddDTO addComment(CommentAddDTO commentAddDTO, int userId) {
        CommentVO commentVO = CommentVO.builder()
                .commentText(commentAddDTO.getCommentText())
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .wordId(commentAddDTO.getWordId())
                .userId(userId)
                .build();

        mapper.addComment(commentVO);
        return commentAddDTO;
    }

    @Transactional
    public CommentUpdateDTO updateComment(CommentUpdateDTO commentUpdateDTO) {
        CommentVO prevCommentVO = mapper.getCommentById(commentUpdateDTO.getId());
        CommentVO updateCommentVO = CommentVO.builder()
                .id(commentUpdateDTO.getId())
                .commentText(commentUpdateDTO.getCommentText())
                .wordId(prevCommentVO.getWordId())
                .userId(prevCommentVO.getUserId())
                .updateTime(LocalDateTime.now())
                .build();

        mapper.updateComment(updateCommentVO);
        return commentUpdateDTO;
    }

    public List<CommentVO> getCommentByWordId(int wordId){
        return mapper.getCommentByWordId(wordId);
    }

    public int deleteComment(int id) {
        mapper.deleteComment(id);
        return id;
    }

    public List<CommentVO> getComments() {
        return mapper.getComments();
    }
}
