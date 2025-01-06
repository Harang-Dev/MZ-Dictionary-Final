package com.dobby.mzdict.controller;

import com.dobby.mzdict.dto.UserDiscussionDTO;
import com.dobby.mzdict.model.ListResult;
import com.dobby.mzdict.model.SingleResult;
import com.dobby.mzdict.service.DiscussionService;
import com.dobby.mzdict.service.UserService;
import com.dobby.mzdict.service.security.ResponseService;
import com.dobby.mzdict.vo.DiscussionVO;
import com.dobby.mzdict.vo.UserDiscussionVO;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/discussion")
public class DiscussionController implements DiscussionControllerDocs{
    private final DiscussionService service;
    private final ResponseService responseService;
    private final UserService userService;

    public DiscussionController(DiscussionService service, ResponseService responseService, UserService userService) {
        this.service = service;
        this.responseService = responseService;
        this.userService = userService;
    }

    @Override
    @PostMapping("/add")
    public SingleResult<Boolean> addDiscussion(String token, DiscussionVO discussionInfo) {
        return responseService.getSingleResult(service.addDiscussion(discussionInfo));
    }

    @Override
    @PutMapping("/update")
    public SingleResult<Boolean> updateDiscussion(String token, DiscussionVO discussionInfo) {
        return responseService.getSingleResult(service.updateDiscussion(discussionInfo));
    }

    @Override
    @DeleteMapping("/delete")
    public SingleResult<Boolean> deleteDiscussion(String token, int discussionId) {
        return responseService.getSingleResult(service.deleteDiscussion(discussionId));
    }

    @Override
    @GetMapping("/get")
    public SingleResult<DiscussionVO> getDiscussionById(String token, int discussionId) {
        return responseService.getSingleResult(service.getDiscussionById(discussionId));
    }

    @Override
    @GetMapping("/get/list")
    public ListResult<DiscussionVO> getDiscussions(String token) {
        return responseService.getListResult(service.getDiscussions());
    }

    @Override
    @GetMapping("/get/today")
    public SingleResult<DiscussionVO> getTodayDiscussion(String token) {
        return responseService.getSingleResult(service.getTodayDiscussion());
    }

    @Override
    @PostMapping("/select")
    public SingleResult<Boolean> selectDiscussionOption(String token, UserDiscussionDTO userDiscussionDTO) {
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        int id = userService.getUserByUserId(userId).getId();

        UserDiscussionVO userDiscussionInfo = new UserDiscussionVO();
        userDiscussionInfo.setUserId(id);
        userDiscussionInfo.setDiscussionId(userDiscussionDTO.getDiscussionId());
        userDiscussionInfo.setStat(userDiscussionDTO.isStat());

        return responseService.getSingleResult(service.selectOption(userDiscussionInfo));
    }

    @Override
    @GetMapping("/get/count")
    public SingleResult<Map<String, Integer>> getOptionCountByOptions(String token) {
        return responseService.getSingleResult(service.getOptionCounts());
    }
}
