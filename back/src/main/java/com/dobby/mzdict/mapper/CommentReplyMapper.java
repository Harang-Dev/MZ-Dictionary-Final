package com.dobby.mzdict.mapper;

import com.dobby.mzdict.vo.CommentReplyVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentReplyMapper {
    public boolean addReply(CommentReplyVO replyInfo);
    public CommentReplyVO getReplyById(int id);
    public boolean updateReply(CommentReplyVO commentInfo);
    public List<CommentReplyVO> getReplyByCommentId(int commentId);
    public boolean deleteReply(int replyId);
    public List<CommentReplyVO> getReplys();
}
