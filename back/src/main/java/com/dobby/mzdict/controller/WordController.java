package com.dobby.mzdict.controller;

import com.dobby.mzdict.config.security.JwtTokenProvider;
import com.dobby.mzdict.dto.WordAddDTO;
import com.dobby.mzdict.dto.WordDetailDTO;
import com.dobby.mzdict.dto.WordUpdateDTO;
import com.dobby.mzdict.service.UserService;
import com.dobby.mzdict.service.WordService;
import com.dobby.mzdict.vo.WordVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@RestController
@RequestMapping("/word")
public class WordController implements WordControllerDocs{
    private final WordService service;
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    public WordController(WordService service, UserService userService, JwtTokenProvider jwtTokenProvider) {
        this.service = service;
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @GetMapping("/")
    public ResponseEntity<List<WordVO>> getWords(String token) {
        int userId = userService.getUserByUserId(jwtTokenProvider.getUserPK(token)).getId();
        List<WordVO> wordList = service.getWords(userId);

        if (!wordList.isEmpty()) {
            return ResponseEntity.ok(wordList);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/non-member")
    public ResponseEntity<List<WordVO>> getWordsByNonMember() {
        List<WordVO> wordList = service.getWordsByNonMember();
        if (!wordList.isEmpty()) {
            return ResponseEntity.ok(wordList);
        } else {
            return ResponseEntity.noContent().build();
        }
    };

    @GetMapping("/info")
    public ResponseEntity<WordDetailDTO> getWord(String token, int wordId) {
        int userId = userService.getUserByUserId(jwtTokenProvider.getUserPK(token)).getId();
        WordDetailDTO wordInfo = service.getWord(wordId, userId);
        if (wordInfo != null) {
            return ResponseEntity.ok(wordInfo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/info/non-member")
    public ResponseEntity<WordDetailDTO> getWordByNonMember(int wordId) {
        WordDetailDTO wordInfo = service.getWordByNonMember(wordId);
        if (wordInfo != null) {
            return ResponseEntity.ok(wordInfo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<WordAddDTO> insertWord(String token, WordAddDTO wordAddDTO) {
        int userId = userService.getUserByUserId(jwtTokenProvider.getUserPK(token)).getId();
        int result = service.insertWord(wordAddDTO, userId);

        if(result > 0) {
            return ResponseEntity.ok(wordAddDTO);
        } else {
            return ResponseEntity.status(400).build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Map<String, Object>> updateWord(String token, WordUpdateDTO wordUpdateDto) {
        boolean result = service.updateWord(wordUpdateDto);
        Map<String, Object> map = new HashMap<>();
        map.put("success", result);

        if (result) {
            map.put("message", "업데이트 성공");
            return ResponseEntity.ok(map);
        } else {
            map.put("message", "업데이트 실패");
            return ResponseEntity.status(400).body(map);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Integer> deleteWord(String token, int wordId) {
        int result = service.deleteWord(wordId);
        if(result > 0) {
            return ResponseEntity.status(200).body(result);
        } else {
            return ResponseEntity.status(400).body(-1);
        }
    }

    @GetMapping("/find")
    public ResponseEntity<List<WordVO>> findWord(String token, String keyWord) {
        int userId = userService.getUserByUserId(jwtTokenProvider.getUserPK(token)).getId();
        List<WordVO> result = service.findWord(keyWord, userId);

        if(!result.isEmpty()) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/find/non-member")
    public ResponseEntity<List<WordVO>> findWordByNonMember(String keyWord) {
        List<WordVO> result = service.findWordByNonMember(keyWord);

        if(!result.isEmpty()) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
