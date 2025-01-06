package com.dobby.mzdict.service;

import com.dobby.mzdict.mapper.ScrapMapper;
import com.dobby.mzdict.vo.ScrapVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ScrapService {
    private final ScrapMapper scrapMapper;

    public ScrapService(ScrapMapper scrapMapper) {
        this.scrapMapper = scrapMapper;
    }

    public List<ScrapVO> getScraps() {
        return scrapMapper.getScraps();
    }

    @Transactional
    public boolean addScrap(ScrapVO scrapVO){
        return scrapMapper.addScrap(scrapVO);
    }

    @Transactional
    public boolean deleteScrap(ScrapVO scrapVO){
        return scrapMapper.deleteScrap(scrapVO);
    }
}
