package com.dobby.mzdict.controller;

import com.dobby.mzdict.model.ListResult;
import com.dobby.mzdict.model.SingleResult;
import com.dobby.mzdict.service.CommentReplyService;
import com.dobby.mzdict.service.CommentService;
import com.dobby.mzdict.service.UserService;
import com.dobby.mzdict.service.security.ResponseService;
import com.dobby.mzdict.vo.CommentReplyVO;
import com.dobby.mzdict.vo.CommentVO;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController implements CommentControllerDocs{

    private final CommentService commentService;
    private final CommentReplyService commentReplyService;
    private final UserService userService;
    private final ResponseService responseService;

    public CommentController(CommentService service, CommentReplyService commentReplyService, UserService userService, ResponseService responseService) {
        this.commentService = service;
        this.commentReplyService = commentReplyService;
        this.userService = userService;
        this.responseService = responseService;
    }

    @PostMapping("/add")
    public SingleResult<CommentVO> addComment(@RequestHeader(value = "X-AUTH-TOKEN") String token, @RequestBody CommentVO commentVO){
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        int id = userService.getUserByUserId(userId).getId();

        commentVO.setUserId(id);
        return responseService.getSingleResult(commentService.addComment(commentVO));
    }

    @PutMapping("/update")
    public SingleResult<CommentVO> updateComment(@RequestHeader(value = "X-AUTH-TOKEN") String token, @RequestBody CommentVO commentVO) {
        return responseService.getSingleResult(commentService.updateComment(commentVO));
    }

    @GetMapping("/get")
    public ListResult<CommentVO> getCommentByWordId(@RequestHeader(value = "X-AUTH-TOKEN") String token, @RequestParam int wordId){
        return responseService.getListResult(commentService.getCommentByWordId(wordId));
    }

    @GetMapping("/delete")
    public SingleResult<Integer> deleteComment(@RequestHeader(value = "X-AUTH-TOKEN") String token, @RequestParam int commentId) {
        return responseService.getSingleResult(commentService.deleteComment(commentId));
    }

    @GetMapping("/")
    public ListResult<CommentVO> getComments(@RequestHeader(value = "X-AUTH-TOKEN") String token) {
        return responseService.getListResult(commentService.getComments());
    }

    @Override
    @PostMapping("/reply/add")
    public SingleResult<CommentReplyVO> addReply(String token, CommentReplyVO replyInfo) {
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        int id = userService.getUserByUserId(userId).getId();

        replyInfo.setUserId(id);
        return responseService.getSingleResult(commentReplyService.addReply(replyInfo));
    }

    @Override
    @PutMapping("/reply/update")
    public SingleResult<CommentReplyVO> updateReply(String token, CommentReplyVO replyInfo) {
        return responseService.getSingleResult(commentReplyService.updateReply(replyInfo));
    }

    @Override
    @GetMapping("/reply/get")
    public ListResult<CommentReplyVO> getReplyByCommentId(String token, int commentId) {
        return responseService.getListResult(commentReplyService.getReplyByCommentId(commentId));
    }

    @Override
    @GetMapping("/reply/delete")
    public SingleResult<Boolean> deleteReply(String token, int replyId) {
        return responseService.getSingleResult(commentReplyService.deleteReply(replyId));
    }

    @Override
    @GetMapping("/reply")
    public ListResult<CommentReplyVO> getReplys(String token) {
        return responseService.getListResult(commentReplyService.getReplys());
    }


}
