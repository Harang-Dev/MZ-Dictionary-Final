package com.dobby.mzdict.controller;

import com.dobby.mzdict.vo.CommentReplyVO;
import com.dobby.mzdict.vo.CommentVO;
import com.dobby.mzdict.vo.WordVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "Comment", description = "댓글과 관련된 API 입니다.")
public interface CommentControllerDocs {

    @Operation(summary = "댓글 추가", description = "댓글을 추가합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode= "200", description = "댓글 추가 성공"),
            @ApiResponse(responseCode = "400", description = "댓글 추가 실패")})
    public Object addComment(@RequestHeader(value = "X-AUTH-TOKEN") String token, @RequestBody CommentVO commentInfo);

    @Operation(summary = "댓글 수정", description = "댓글을 수정합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode= "200", description = "댓글 수정 성공"),
            @ApiResponse(responseCode = "400", description = "댓글 수정 실패")})
    public Object updateComment(@RequestHeader(value = "X-AUTH-TOKEN") String token, @RequestBody CommentVO commentInfo);

    @Operation(summary = "댓글 조회", description = "단어별 댓글을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode= "200", description = "댓글 조회 성공"),
            @ApiResponse(responseCode = "400", description = "댓글 조회 실패")})
    public Object getCommentByWordId(@RequestHeader(value = "X-AUTH-TOKEN") String token, @RequestParam int wordId);

    @Operation(summary = "댓글 삭제", description = "댓글을 삭제합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode= "200", description = "댓글 삭제 성공"),
            @ApiResponse(responseCode = "400", description = "댓글 삭제 실패")})
    public Object deleteComment(@RequestHeader(value = "X-AUTH-TOKEN") String token, @RequestParam int commentId);

    @Operation(summary = "댓글 조회", description = "DB에 저장된 모든 댓글을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode= "200", description = "댓글 조회 성공"),
            @ApiResponse(responseCode = "400", description = "댓글 조회 실패")})
    public Object getComments(@RequestHeader(value = "X-AUTH-TOKEN") String token);

    @Operation(summary = "답글 추가", description = "답글을 추가합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode= "200", description = "답글 추가 성공"),
            @ApiResponse(responseCode = "400", description = "답글 추가 실패")})
    public Object addReply(@RequestHeader(value = "X-AUTH-TOKEN") String token, @RequestBody CommentReplyVO replyInfo);

    @Operation(summary = "답글 수정", description = "답글을 수정합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode= "200", description = "답글 수정 성공"),
            @ApiResponse(responseCode = "400", description = "답글 수정 실패")})
    public Object updateReply(@RequestHeader(value = "X-AUTH-TOKEN") String token, @RequestBody CommentReplyVO replyInfo);

    @Operation(summary = "답글 조회", description = "댓글별 답글을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode= "200", description = "답글 조회 성공"),
            @ApiResponse(responseCode = "400", description = "답글 조회 실패")})
    public Object getReplyByCommentId(@RequestHeader(value = "X-AUTH-TOKEN") String token, @RequestParam int commentId);

    @Operation(summary = "답글 삭제", description = "답글을 삭제합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode= "200", description = "답글 삭제 성공"),
            @ApiResponse(responseCode = "400", description = "답글 삭제 실패")})
    public Object deleteReply(@RequestHeader(value = "X-AUTH-TOKEN") String token, @RequestParam int replyId);

    @Operation(summary = "답글 조회", description = "DB에 저장된 모든 답글을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode= "200", description = "답글 조회 성공"),
            @ApiResponse(responseCode = "400", description = "답글 조회 실패")})
    public Object getReplys(@RequestHeader(value = "X-AUTH-TOKEN") String token);
}
