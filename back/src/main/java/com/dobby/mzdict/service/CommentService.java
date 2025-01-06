package com.dobby.mzdict.service;

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
    public CommentVO addComment(CommentVO commentInfo) {
        LocalDateTime now = LocalDateTime.now();

        commentInfo.setCreateTime(now);
        commentInfo.setUpdateTime(now);

        mapper.addComment(commentInfo);
        return commentInfo;
    }

    @Transactional
    public CommentVO updateComment(CommentVO commentInfo) {
        LocalDateTime now = LocalDateTime.now();
        boolean result = mapper.updateComment(commentInfo);
        return commentInfo;
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
