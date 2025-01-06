package com.dobby.mzdict.controller;

import com.dobby.mzdict.model.ListResult;
import com.dobby.mzdict.model.SingleResult;
import com.dobby.mzdict.service.LikeService;
import com.dobby.mzdict.service.UserService;
import com.dobby.mzdict.service.security.ResponseService;
import com.dobby.mzdict.vo.LikeVO;
import com.dobby.mzdict.vo.ScrapVO;
import org.apache.coyote.Response;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/like")
public class LikeController implements LikeControllerDocs{
    private final LikeService likeService;
    private final ResponseService responseService;
    private final UserService userService;

    public LikeController(LikeService likeService, ResponseService responseService, UserService userService) {
        this.likeService = likeService;
        this.responseService = responseService;
        this.userService = userService;
    }

    @Override
    @GetMapping("/")
    public ListResult<LikeVO> getLikes(String token) {
        return responseService.getListResult(likeService.getLikes());
    }

    @Override
    @GetMapping("/add")
    public SingleResult<Boolean> addLike(String token, int wordId) {
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        LocalDateTime now = LocalDateTime.now();

        LikeVO vo = new LikeVO(userService.getUserByUserId(userId).getId(), wordId, now);
        return responseService.getSingleResult(likeService.addLike(vo));
    }

    @Override
    @GetMapping("/delete")
    public SingleResult<Boolean> deleteLike(String token, int wordId) {
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        LocalDateTime now = LocalDateTime.now();

        LikeVO vo = new LikeVO(userService.getUserByUserId(userId).getId(), wordId, now);
        return responseService.getSingleResult(likeService.deleteLike(vo));
    }
}
