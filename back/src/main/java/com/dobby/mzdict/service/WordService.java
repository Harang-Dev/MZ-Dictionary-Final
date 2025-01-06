package com.dobby.mzdict.service;

import com.dobby.mzdict.mapper.WordMapper;
import com.dobby.mzdict.vo.WordVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WordService {
    private final WordMapper mapper;

    public WordService(WordMapper mapper) {
        this.mapper = mapper;
    }

    public List<WordVO> getWords() {
        return mapper.getWords();
    }

    public WordVO getWord(int id) {
        return mapper.getWord(id);
    }

    @Transactional
    public boolean updateWord(WordVO wordInfo){
        LocalDateTime currentTime = LocalDateTime.now();
        wordInfo.setUpdateTime(currentTime);

        int rowsAffected = mapper.updateWord(wordInfo);
        return rowsAffected > 0;
    }

    @Transactional
    public int deleteWord(int id) {
        return mapper.deleteWord(id);
    }

    @Transactional
    public int insertWord(WordVO wordInfo) {
        LocalDateTime currentTime = LocalDateTime.now();

        wordInfo.setCreateTime(currentTime);
        wordInfo.setUpdateTime(currentTime);
        wordInfo.setAcceptStatus(0);

        return mapper.insertWord(wordInfo);
    }

    public List<WordVO> findWord(String keyWord) {
        return mapper.findWord(keyWord);
    }

    public List<WordVO> getNotAcceptWord() {
        return mapper.getNotAcceptWord();
    }
}
