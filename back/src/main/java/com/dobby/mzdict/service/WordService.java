package com.dobby.mzdict.service;

import com.dobby.mzdict.dto.WordAddDTO;
import com.dobby.mzdict.dto.WordUpdateDTO;
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

    public List<WordVO> getWords(int userId) {
        return mapper.getWords(userId);
    }

    public List<WordVO> getWordsByNonMember() { return mapper.getWordsByNonMember(); }

    public WordVO getWord(int id, int userId) {
        return mapper.getWord(id, userId);
    }

    public WordVO getWordByNonMember(int id) { return mapper.getWordByNonMember(id); }

    @Transactional
    public boolean updateWord(WordUpdateDTO wordUpdateDTO){
        WordVO wordVO = WordVO.builder()
                .id(wordUpdateDTO.getId())
                .wordTitle(wordUpdateDTO.getWordTitle())
                .meaning(wordUpdateDTO.getMeaning())
                .usingExample(wordUpdateDTO.getUsingExample())
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();

        int rowsAffected = mapper.updateWord(wordVO);
        return rowsAffected > 0;
    }

    @Transactional
    public int deleteWord(int id) {
        return mapper.deleteWord(id);
    }

    @Transactional
    public int insertWord(WordAddDTO wordAddDTO, int userId) {
        WordVO wordVO = WordVO.builder()
                .wordTitle(wordAddDTO.getWordTitle())
                .meaning(wordAddDTO.getMeaning())
                .usingExample(wordAddDTO.getUsingExample())
                .userId(userId)
                .acceptStatus(0)
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();

        return mapper.insertWord(wordVO);
    }

    public List<WordVO> findWord(String keyWord, int userId) {
        return mapper.findWord(keyWord, userId);
    }

    public List<WordVO> findWordByNonMember(String keyWord) {
        return mapper.findWordByNonMember(keyWord);
    }

    public List<WordVO> getNotAcceptWord() {
        return mapper.getNotAcceptWord();
    }
}
