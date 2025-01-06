package com.dobby.mzdict.mapper;

import com.dobby.mzdict.vo.CommentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    public boolean addComment(CommentVO commentInfo);
    public CommentVO getCommentById(int id);
    public boolean updateComment(CommentVO commentInfo);
    public List<CommentVO> getCommentByWordId(int wordId);
    public int deleteComment(int commentId);
    public List<CommentVO> getComments();
}
