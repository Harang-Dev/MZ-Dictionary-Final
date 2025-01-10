package com.dobby.mzdict.service;

import com.dobby.mzdict.dto.ReactionDTO;
import com.dobby.mzdict.mapper.ReplyReactionMapper;
import com.dobby.mzdict.vo.CommentReactionVO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReplyReactionService {
    private final ReplyReactionMapper ReplyReactionMapper;

    public ReplyReactionService(ReplyReactionMapper ReplyReactionMapper) {
        this.ReplyReactionMapper = ReplyReactionMapper;
    }

    public List<CommentReactionVO> getReactions(){
        return ReplyReactionMapper.getReactions();
    }

    public List<CommentReactionVO> getReactionByReplyId(int replyId){
        return ReplyReactionMapper.getReactionByReplyId(replyId);
    }
    public CommentReactionVO getReactionById(int replyId, int userId){
        return ReplyReactionMapper.getReactionById(replyId,userId);
    }

    public boolean addReaction(ReactionDTO reactionDTO, int userId){
        CommentReactionVO commentReactionVO = CommentReactionVO.builder()
                .userId(userId)
                .targetId(reactionDTO.getTargetId())
                .reaction(reactionDTO.isReaction())
                .reactionTime(LocalDateTime.now())
                .build();

        return ReplyReactionMapper.addReaction(commentReactionVO);
    }
    public boolean updateReaction(ReactionDTO reactionDTO, int userId) {
        CommentReactionVO commentReactionVO = ReplyReactionMapper.getReactionById(reactionDTO.getTargetId(),userId);

        commentReactionVO.setReaction(reactionDTO.isReaction());
        commentReactionVO.setReactionTime(LocalDateTime.now());

        return ReplyReactionMapper.updateReaction(commentReactionVO);
    }

    public boolean deleteReaction(int replyId, int userId) {
        return ReplyReactionMapper.deleteReaction(replyId,userId);
    }

}
