package com.dobby.mzdict.controller;

import com.dobby.mzdict.dto.CommentAddDTO;
import com.dobby.mzdict.dto.CommentUpdateDTO;
import com.dobby.mzdict.dto.ReplyAddDTO;
import com.dobby.mzdict.dto.ReplyUpdateDTO;
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
    public SingleResult<CommentAddDTO> addComment(String token, CommentAddDTO commentAddDTO){
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        int id = userService.getUserByUserId(userId).getId();

        return responseService.getSingleResult(commentService.addComment(commentAddDTO, id));
    }

    @PutMapping("/update")
    public SingleResult<CommentUpdateDTO> updateComment(String token, CommentUpdateDTO commentUpdateDTO) {
        return responseService.getSingleResult(commentService.updateComment(commentUpdateDTO));
    }

    @GetMapping("/get")
    public ListResult<CommentVO> getCommentByWordId(String token, int wordId){
        return responseService.getListResult(commentService.getCommentByWordId(wordId));
    }

    @GetMapping("/delete")
    public SingleResult<Integer> deleteComment(String token, int commentId) {
        return responseService.getSingleResult(commentService.deleteComment(commentId));
    }

    @GetMapping("/")
    public ListResult<CommentVO> getComments(String token) {
        return responseService.getListResult(commentService.getComments());
    }

    @Override
    @PostMapping("/reply/add")
    public SingleResult<ReplyAddDTO> addReply(String token, ReplyAddDTO replyInfo) {
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        int id = userService.getUserByUserId(userId).getId();

        return responseService.getSingleResult(commentReplyService.addReply(replyInfo, id));
    }

    @Override
    @PutMapping("/reply/update")
    public SingleResult<ReplyUpdateDTO> updateReply(String token, ReplyUpdateDTO replyUpdateDTO) {
        return responseService.getSingleResult(commentReplyService.updateReply(replyUpdateDTO));
    }

    @Override
    @GetMapping("/reply/get")
    public ListResult<CommentReplyVO> getReplyByCommentId(String token, int replyId) {
        return responseService.getListResult(commentReplyService.getReplyByCommentId(replyId));
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
