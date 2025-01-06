package com.dobby.mzdict.mapper;

import com.dobby.mzdict.vo.WordVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WordMapper {
    public List<WordVO> getWords();

    public WordVO getWord(int id);

    public int updateWord(WordVO wordInfo);

    public int deleteWord(int id);

    public int insertWord(WordVO wordInfo);

    public List<WordVO> findWord(String keyWord);

    public List<WordVO> getNotAcceptWord();
}
