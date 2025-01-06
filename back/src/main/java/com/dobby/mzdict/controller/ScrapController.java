package com.dobby.mzdict.controller;

import com.dobby.mzdict.model.ListResult;
import com.dobby.mzdict.model.SingleResult;
import com.dobby.mzdict.service.ScrapService;
import com.dobby.mzdict.service.UserService;
import com.dobby.mzdict.service.security.ResponseService;
import com.dobby.mzdict.vo.ScrapVO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/scrap")
public class ScrapController implements ScrapControllerDocs{
    private final ScrapService scrapService;
    private final ResponseService responseService;
    private final UserService userService;

    public ScrapController(ScrapService scrapService, ResponseService responseService, UserService userService) {
        this.scrapService = scrapService;
        this.responseService = responseService;
        this.userService = userService;
    }

    @Override
    @GetMapping("/")
    public ListResult<ScrapVO> getScraps(String token) {
        return responseService.getListResult(scrapService.getScraps());
    }

    @Override
    @GetMapping("/add")
    public SingleResult<Boolean> addScrap(String token, int wordId) {
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        LocalDateTime now = LocalDateTime.now();

        ScrapVO vo = new ScrapVO(userService.getUserByUserId(userId).getId(), wordId, now);
        return responseService.getSingleResult(scrapService.addScrap(vo));
    }

    @Override
    @GetMapping("/delete")
    public Object deleteScrap(String token, int wordId) {
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        LocalDateTime now = LocalDateTime.now();

        ScrapVO vo = new ScrapVO(userService.getUserByUserId(userId).getId(), wordId, now);
        return responseService.getSingleResult(scrapService.deleteScrap(vo));
    }
}
