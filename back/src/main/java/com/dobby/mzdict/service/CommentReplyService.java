package com.dobby.mzdict.service;

import com.dobby.mzdict.mapper.CommentReplyMapper;
import com.dobby.mzdict.vo.CommentReplyVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public CommentReplyVO addReply(CommentReplyVO replyInfo) {
        LocalDateTime now = LocalDateTime.now();

        replyInfo.setCreateTime(now);
        replyInfo.setUpdateTime(now);

        mapper.addReply(replyInfo);
        return replyInfo;
    }

    @Transactional
    public CommentReplyVO updateReply(CommentReplyVO replyInfo) {
        LocalDateTime now = LocalDateTime.now();
        boolean result = mapper.updateReply(replyInfo);
        return replyInfo;
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
