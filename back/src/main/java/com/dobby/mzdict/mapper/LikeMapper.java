package com.dobby.mzdict.mapper;

import com.dobby.mzdict.vo.LikeVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LikeMapper {
    public List<LikeVO> getLikes();
    public boolean addLike(LikeVO likeVO);
    public boolean deleteLike(LikeVO likeVO);

}
