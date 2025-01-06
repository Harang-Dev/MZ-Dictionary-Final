package com.dobby.mzdict.controller;

import com.dobby.mzdict.model.CommonResult;
import com.dobby.mzdict.model.ListResult;
import com.dobby.mzdict.model.SingleResult;
import com.dobby.mzdict.service.CommentReactionService;
import com.dobby.mzdict.service.ReplyReactionService;
import com.dobby.mzdict.service.UserService;
import com.dobby.mzdict.service.security.ResponseService;
import com.dobby.mzdict.vo.CommentReactionVO;
import com.dobby.mzdict.vo.CommentReplyVO;
import com.dobby.mzdict.vo.CommentVO;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.xml.stream.events.Comment;

@RestController
@RequestMapping("/reaction")
public class CommentReactionController implements CommentReactionControllerDocs{
    private final UserService userService;
    private final CommentReactionService commentReactionService;
    private final ReplyReactionService replyReactionService;
    private final ResponseService responseService;

    public CommentReactionController(UserService userService, CommentReactionService commentReactionService, ReplyReactionService replyReactionService, ResponseService responseService){
        this.userService = userService;
        this.commentReactionService = commentReactionService;
        this.replyReactionService = replyReactionService;
        this.responseService = responseService;
    }

    @Override
    @PostMapping("/comment/add")
    public SingleResult<Boolean> addReaction(String token, CommentReactionVO reactionInfo) {
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        int id = userService.getUserByUserId(userId).getId();

        reactionInfo.setUserId(id);
        return responseService.getSingleResult(commentReactionService.addReaction(reactionInfo));
    }

    @Override
    @PutMapping("/comment/update")
    public SingleResult<Boolean> updateReaction(String token, CommentReactionVO reactionInfo) {
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        int id = userService.getUserByUserId(userId).getId();

        reactionInfo.setUserId(id);
        return responseService.getSingleResult(commentReactionService.updateReaction(reactionInfo));
    }

    @Override
    @GetMapping("/comment/get-by-both")
    public SingleResult<CommentReactionVO> getReactionById(String token, int commentId) {
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        int id = userService.getUserByUserId(userId).getId();

        return responseService.getSingleResult(commentReactionService.getReactionById(commentId, id));
    }

    @Override
    @GetMapping("/comment/delete")
    public SingleResult<Boolean> deleteReaction(String token, int commentId) {
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        int id = userService.getUserByUserId(userId).getId();

        return responseService.getSingleResult(commentReactionService.deleteReaction(commentId, id));
    }

    @Override
    @GetMapping("/comment")
    public ListResult<CommentReactionVO> getReactions(String token) {
        return responseService.getListResult(commentReactionService.getReactions());
    }

    @Override
    @GetMapping("/comment/get-by-comment")
    public ListResult<CommentReactionVO> getReactionsByCommentId(String token, int commentId) {
        return responseService.getListResult(commentReactionService.getReactionByCommentId(commentId));
    }

    @Override
    @PostMapping("/reply/add")
    public SingleResult<Boolean> addReplyReaction(String token, CommentReactionVO replyInfo) {
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        int id = userService.getUserByUserId(userId).getId();

        replyInfo.setUserId(id);
        return responseService.getSingleResult(replyReactionService.addReaction(replyInfo));
    }

    @Override
    @PutMapping("/reply/update")
    public SingleResult<Boolean> updateReplyReaction(String token, CommentReactionVO replyInfo) {
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        int id = userService.getUserByUserId(userId).getId();

        replyInfo.setUserId(id);
        return responseService.getSingleResult(replyReactionService.updateReaction(replyInfo));
    }

    @Override
    @GetMapping("/reply/get-by-both")
    public SingleResult<CommentReactionVO> getReplyReactionById(String token, int replyId) {
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        int id = userService.getUserByUserId(userId).getId();

        return responseService.getSingleResult(replyReactionService.getReactionById(replyId, id));
    }

    @Override
    @GetMapping("/reply/delete")
    public SingleResult<Boolean> deleteReplyReaction(String token, int replyId) {
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        int id = userService.getUserByUserId(userId).getId();

        return responseService.getSingleResult(replyReactionService.deleteReaction(replyId, id));
    }

    @Override
    @GetMapping("/reply")
    public ListResult<CommentReactionVO> getReplyReactions(String token) {
        return responseService.getListResult(replyReactionService.getReactions());
    }

    @Override
    @GetMapping("/reply/get-by-reply")
    public ListResult<CommentReactionVO> getReactionsByReplyId(String token, int replyId) {
        return responseService.getListResult(replyReactionService.getReactionByReplyId(replyId));
    }
}
