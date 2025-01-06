package com.dobby.mzdict.mapper;

import com.dobby.mzdict.vo.ScrapVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScrapMapper {
    public List<ScrapVO> getScraps();
    public boolean addScrap(ScrapVO scrapVO);
    public boolean deleteScrap(ScrapVO scrapVO);
}
