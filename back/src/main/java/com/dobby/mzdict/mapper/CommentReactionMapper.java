package com.dobby.mzdict.mapper;

import com.dobby.mzdict.vo.CommentReactionVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface CommentReactionMapper {
    public List<CommentReactionVO> getReactions();
    public List<CommentReactionVO> getReactionByCommentId(int commentId);
    public CommentReactionVO getReactionById(int commentId, int userId);

    public boolean addReaction(CommentReactionVO commentReactionVO);
    public boolean updateReaction(CommentReactionVO commentReactionVO);
    public boolean deleteReaction(int commentId, int userId);
}
