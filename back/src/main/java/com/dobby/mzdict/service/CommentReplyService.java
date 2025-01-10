package com.dobby.mzdict.service;

import com.dobby.mzdict.dto.ReplyAddDTO;
import com.dobby.mzdict.dto.ReplyUpdateDTO;
import com.dobby.mzdict.mapper.CommentReplyMapper;
import com.dobby.mzdict.vo.CommentReplyVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.stream.events.Comment;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentReplyService {
    private final CommentReplyMapper mapper;

    public CommentReplyService(CommentReplyMapper mapper) {
        this.mapper = mapper;
    }

    public CommentReplyVO getCommentById(int id){
        return mapper.getReplyById(id);
    }

    @Transactional
    public ReplyAddDTO addReply(ReplyAddDTO replyAddDTO, int userId) {
        CommentReplyVO commentReplyVO = CommentReplyVO.builder()
                        .commentId(replyAddDTO.getCommentId())
                        .replyText(replyAddDTO.getReplyText())
                        .createTime(LocalDateTime.now())
                        .updateTime(LocalDateTime.now())
                        .userId(userId)
                        .build();

        System.out.println(commentReplyVO.toString());
        mapper.addReply(commentReplyVO);
        return replyAddDTO;
    }

    @Transactional
    public ReplyUpdateDTO updateReply(ReplyUpdateDTO replyUpdateDTO) {
        CommentReplyVO prevCommentReplyVO = mapper.getReplyById(replyUpdateDTO.getId());
        CommentReplyVO updateCommentReplyVO = CommentReplyVO.builder()
                .commentId(prevCommentReplyVO.getCommentId())
                .replyText(replyUpdateDTO.getReplyText())
                .id(prevCommentReplyVO.getId())
                .userId(prevCommentReplyVO.getUserId())
                .updateTime(LocalDateTime.now())
                .build();

        mapper.updateReply(updateCommentReplyVO);
        return replyUpdateDTO;
    }

    public List<CommentReplyVO> getReplyByCommentId(int commentId){
        return mapper.getReplyByCommentId(commentId);
    }

    @Transactional
    public Boolean deleteReply(int id) {
        return mapper.deleteReply(id);
    }

    public List<CommentReplyVO> getReplys() {
        return mapper.getReplys();
    }
}
