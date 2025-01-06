package com.dobby.mzdict.controller;

import com.dobby.mzdict.config.security.JwtTokenProvider;
import com.dobby.mzdict.service.UserService;
import com.dobby.mzdict.service.WordService;
import com.dobby.mzdict.vo.WordVO;
import lombok.extern.log4j.Log4j2;
import org.apache.coyote.Response;
import org.apache.ibatis.annotations.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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
    public ResponseEntity<List<WordVO>> getWords(@RequestHeader (value = "X-AUTH-TOKEN") String token) {
        List<WordVO> wordList = service.getWords();
        if (!wordList.isEmpty()) {
            return ResponseEntity.ok(wordList);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/info")
    public ResponseEntity<WordVO> getWord(@RequestHeader (value = "X-AUTH-TOKEN") String token, @RequestParam int wordId) {
        WordVO wordInfo = service.getWord(wordId);
        if (wordInfo != null) {
            return ResponseEntity.ok(wordInfo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<WordVO> insertWord(@RequestHeader (value = "X-AUTH-TOKEN") String token, @RequestBody WordVO wordVO) {
        int userId = userService.getUserByUserId(jwtTokenProvider.getUserPK(token)).getId();
        wordVO.setUserId(userId);

        int result = service.insertWord(wordVO);

        if(result > 0) {
            return ResponseEntity.ok(service.getWord(wordVO.getId()));
        } else {
            return ResponseEntity.status(400).build();
        }
    }


    @PutMapping("/update")
    public ResponseEntity<Map<String, Object>> updateWord(@RequestHeader (value = "X-AUTH-TOKEN") String token, @RequestBody WordVO wordVO) {
        boolean result = service.updateWord(wordVO);
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
    public ResponseEntity<Integer> deleteWord(@RequestHeader (value = "X-AUTH-TOKEN") String token, @RequestParam int wordId) {
        int result = service.deleteWord(wordId);
        if(result > 0) {
            return ResponseEntity.status(200).body(result);
        } else {
            return ResponseEntity.status(400).body(-1);
        }
    }

    @GetMapping("/find")
    public ResponseEntity<List<WordVO>> findWord(@RequestHeader (value = "X-AUTH-TOKEN") String token, @RequestParam String keyWord) {
        List<WordVO> result = service.findWord(keyWord);
        if(!result.isEmpty()) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
