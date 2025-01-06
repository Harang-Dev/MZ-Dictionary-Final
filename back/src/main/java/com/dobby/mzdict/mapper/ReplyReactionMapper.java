package com.dobby.mzdict.mapper;

import com.dobby.mzdict.vo.CommentReactionVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReplyReactionMapper {
    public List<CommentReactionVO> getReactions();
    public List<CommentReactionVO> getReactionByReplyId(int replyId);
    public CommentReactionVO getReactionById(int replyId, int userId);

    public boolean addReaction(CommentReactionVO commentReactionVO);
    public boolean updateReaction(CommentReactionVO commentReactionVO);
    public boolean deleteReaction(int replyId, int userId);

}
