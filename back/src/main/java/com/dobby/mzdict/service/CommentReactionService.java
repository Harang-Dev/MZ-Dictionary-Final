package com.dobby.mzdict.service;

import com.dobby.mzdict.mapper.CommentReactionMapper;
import com.dobby.mzdict.vo.CommentReactionVO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentReactionService {
    private final CommentReactionMapper commentReactionMapper;

    public CommentReactionService(CommentReactionMapper commentReactionMapper) {
        this.commentReactionMapper = commentReactionMapper;
    }

    public List<CommentReactionVO> getReactions(){
        return commentReactionMapper.getReactions();
    }

    public List<CommentReactionVO> getReactionByCommentId(int commentId){
        return commentReactionMapper.getReactionByCommentId(commentId);
    }
    public CommentReactionVO getReactionById(int commentId, int userId){
        return commentReactionMapper.getReactionById(commentId,userId);
    }

    public boolean addReaction(CommentReactionVO commentReactionVO){
        LocalDateTime now = LocalDateTime.now();
        commentReactionVO.setReactionTime(now);

        return commentReactionMapper.addReaction(commentReactionVO);
    }
    public boolean updateReaction(CommentReactionVO commentReactionVO) {
        LocalDateTime now = LocalDateTime.now();
        commentReactionVO.setReactionTime(now);

        return commentReactionMapper.updateReaction(commentReactionVO);
    }

    public boolean deleteReaction(int commentId, int userId) {
        return commentReactionMapper.deleteReaction(commentId,userId);
    }

}
