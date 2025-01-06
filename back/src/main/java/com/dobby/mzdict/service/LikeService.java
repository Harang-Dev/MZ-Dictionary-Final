package com.dobby.mzdict.service;

import com.dobby.mzdict.mapper.LikeMapper;
import com.dobby.mzdict.vo.LikeVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LikeService {
    private final LikeMapper likeMapper;

    public LikeService(LikeMapper likeMapper) {
        this.likeMapper = likeMapper;
    }

    public List<LikeVO> getLikes() {
        return likeMapper.getLikes();
    }

    @Transactional
    public boolean addLike(LikeVO likeVO){
        return likeMapper.addLike(likeVO);
    }

    @Transactional
    public boolean deleteLike(LikeVO likeVO){
        return likeMapper.deleteLike(likeVO);
    }
}
