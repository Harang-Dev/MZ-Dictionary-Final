package com.dobby.mzdict.service;

import com.dobby.mzdict.dto.ReactionDTO;
import com.dobby.mzdict.mapper.CommentReactionMapper;
import com.dobby.mzdict.vo.CommentReactionVO;
import org.springframework.stereotype.Service;

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

    public boolean addReaction(ReactionDTO reactionDTO, int userId){
        CommentReactionVO reactionVO = CommentReactionVO.builder()
                .userId(userId)
                .targetId(reactionDTO.getTargetId())
                .reaction(reactionDTO.isReaction())
                .reactionTime(LocalDateTime.now())
                .build();

        return commentReactionMapper.addReaction(reactionVO);
    }
    public boolean updateReaction(ReactionDTO reactionDTO, int userId) {
        CommentReactionVO commentReactionVO = commentReactionMapper.getReactionById(reactionDTO.getTargetId(),userId);

        commentReactionVO.setReaction(reactionDTO.isReaction());
        commentReactionVO.setReactionTime(LocalDateTime.now());

        return commentReactionMapper.updateReaction(commentReactionVO);
    }

    public boolean deleteReaction(int commentId, int userId) {
        return commentReactionMapper.deleteReaction(commentId,userId);
    }

}
