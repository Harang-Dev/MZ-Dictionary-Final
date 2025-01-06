package com.dobby.mzdict.controller;

import com.dobby.mzdict.vo.CommentReactionVO;
import com.dobby.mzdict.vo.CommentReactionVO;
import com.dobby.mzdict.vo.CommentReactionVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Comment Reaction", description = "댓글 리액션 리액션에 관련한 API 입니다.")
public interface CommentReactionControllerDocs {
    @Operation(summary = "댓글 리액션 추가", description = "댓글 리액션을 추가합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode= "200", description = "댓글 리액션 추가 성공"),
            @ApiResponse(responseCode = "400", description = "댓글 리액션 추가 실패")})
    public Object addReaction(@RequestHeader(value = "X-AUTH-TOKEN") String token, @RequestBody CommentReactionVO reactionInfo);

    @Operation(summary = "댓글 리액션 수정", description = "댓글 리액션을 수정합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode= "200", description = "댓글 리액션 수정 성공"),
            @ApiResponse(responseCode = "400", description = "댓글 리액션 수정 실패")})
    public Object updateReaction(@RequestHeader(value = "X-AUTH-TOKEN") String token, @RequestBody CommentReactionVO reactionInfo);

    @Operation(summary = "댓글 리액션 조회", description = "특정 사용자의 댓글 리액션을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode= "200", description = "댓글 리액션 조회 성공"),
            @ApiResponse(responseCode = "400", description = "댓글 리액션 조회 실패")})
    public Object getReactionById(@RequestHeader(value = "X-AUTH-TOKEN") String token, @RequestParam int commentId);

    @Operation(summary = "댓글 리액션 삭제", description = "댓글 리액션을 삭제합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode= "200", description = "댓글 리액션 삭제 성공"),
            @ApiResponse(responseCode = "400", description = "댓글 리액션 삭제 실패")})
    public Object deleteReaction(@RequestHeader(value = "X-AUTH-TOKEN") String token, @RequestParam int commentId);

    @Operation(summary = "리액션 조회", description = "DB에 저장된 모든 댓글 리액션을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode= "200", description = "댓글 리액션 조회 성공"),
            @ApiResponse(responseCode = "400", description = "댓글 리액션 조회 실패")})
    public Object getReactions(@RequestHeader(value = "X-AUTH-TOKEN") String token);

    @Operation(summary = "댓글 리액션 조회", description = "특정 댓글의 리액션을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode= "200", description = "댓글 리액션 조회 성공"),
            @ApiResponse(responseCode = "400", description = "댓글 리액션 조회 실패")})
    public Object getReactionsByCommentId(@RequestHeader(value = "X-AUTH-TOKEN") String token, @RequestParam int commentId);



    @Operation(summary = "답글 리액션 추가", description = "답글 리액션을 추가합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode= "200", description = "답글 리액션 추가 성공"),
            @ApiResponse(responseCode = "400", description = "답글 리액션 추가 실패")})
    public Object addReplyReaction(@RequestHeader(value = "X-AUTH-TOKEN") String token, @RequestBody CommentReactionVO replyInfo);

    @Operation(summary = "답글 리액션 수정", description = "답글 리액션을 수정합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode= "200", description = "답글 리액션 수정 성공"),
            @ApiResponse(responseCode = "400", description = "답글 리액션 수정 실패")})
    public Object updateReplyReaction(@RequestHeader(value = "X-AUTH-TOKEN") String token, @RequestBody CommentReactionVO replyInfo);

    @Operation(summary = "답글 리액션 조회", description = "특정 사용자의 답글 리액션을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode= "200", description = "답글 리액션 조회 성공"),
            @ApiResponse(responseCode = "400", description = "답글 리액션 조회 실패")})
    public Object getReplyReactionById(@RequestHeader(value = "X-AUTH-TOKEN") String token, @RequestParam int replyId);

    @Operation(summary = "답글 리액션 삭제", description = "답글 리액션을 삭제합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode= "200", description = "답글 리액션 삭제 성공"),
            @ApiResponse(responseCode = "400", description = "답글 리액션 삭제 실패")})
    public Object deleteReplyReaction(@RequestHeader(value = "X-AUTH-TOKEN") String token, @RequestParam int replyId);

    @Operation(summary = "답글 리액션 조회", description = "DB에 저장된 모든 답글 리액션을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode= "200", description = "답글 리액션 조회 성공"),
            @ApiResponse(responseCode = "400", description = "답글 리액션 조회 실패")})
    public Object getReplyReactions(@RequestHeader(value = "X-AUTH-TOKEN") String token);

    @Operation(summary = "답글 리액션 조회", description = "특정 답글의 리액션을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode= "200", description = "댓글 리액션 조회 성공"),
            @ApiResponse(responseCode = "400", description = "댓글 리액션 조회 실패")})
    public Object getReactionsByReplyId(@RequestHeader(value = "X-AUTH-TOKEN") String token, @RequestParam int replyId);
}
