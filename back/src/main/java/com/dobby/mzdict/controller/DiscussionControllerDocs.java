package com.dobby.mzdict.controller;

import com.dobby.mzdict.dto.UserDiscussionDTO;
import com.dobby.mzdict.vo.CommentReactionVO;
import com.dobby.mzdict.vo.DiscussionVO;
import com.dobby.mzdict.vo.UserDiscussionVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "Discussion", description = "토론에 관련한 API 입니다.")
public interface DiscussionControllerDocs {
    @Operation(summary = "토론 추가", description = "토론을 추가합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode= "200", description = "토론 추가 성공"),
            @ApiResponse(responseCode = "400", description = "토론 추가 실패")})
    public Object addDiscussion(@RequestHeader(value = "X-AUTH-TOKEN") String token, @RequestBody DiscussionVO discussionInfo);

    @Operation(summary = "토론 수정", description = "토론을 수정합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode= "200", description = "토론 수정 성공"),
            @ApiResponse(responseCode = "400", description = "토론 수정 실패")})
    public Object updateDiscussion(@RequestHeader(value = "X-AUTH-TOKEN") String token, @RequestBody DiscussionVO discussionInfo);

    @Operation(summary = "토론 삭제", description = "토론을 삭제합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode= "200", description = "토론 삭제 성공"),
            @ApiResponse(responseCode = "400", description = "토론 삭제 실패")})
    public Object deleteDiscussion(@RequestHeader(value = "X-AUTH-TOKEN") String token, @RequestParam int discussionId);

    @Operation(summary = "토론 조회", description = "특정 토론의 데이터를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode= "200", description = "토론 조회 성공"),
            @ApiResponse(responseCode = "400", description = "토론 조회 실패")})
    public Object getDiscussionById(@RequestHeader(value = "X-AUTH-TOKEN") String token, @RequestParam int discussionId);

    @Operation(summary = "토론 조회", description = "DB에 저장된 모든 토론을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode= "200", description = "토론 조회 성공"),
            @ApiResponse(responseCode = "400", description = "토론 조회 실패")})
    public Object getDiscussions(@RequestHeader(value = "X-AUTH-TOKEN") String token);

    @Operation(summary = "오늘의 토론 조회", description = "오늘의 토론을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode= "200", description = "오늘의 토론 조회 성공"),
            @ApiResponse(responseCode = "400", description = "오늘의 토론 조회 실패")})
    public Object getTodayDiscussion(@RequestHeader(value = "X-AUTH-TOKEN") String token);

    @Operation(summary = "토론 옵션 선택", description = "토론에 대한 찬/반을 투표합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode= "200", description = "토론 투표 성공"),
            @ApiResponse(responseCode = "400", description = "토론 투표 실패")})
    public Object selectDiscussionOption(@RequestHeader(value = "X-AUTH-TOKEN") String token, @RequestBody UserDiscussionDTO userDiscussionDTO);

    @Operation(summary = "토론 투표 수 조회", description = "토론의 찬/반 투표 수를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode= "200", description = "토론 투표 수 조회 성공"),
            @ApiResponse(responseCode = "400", description = "토론 투표 수 조회 실패")})
    public Object getOptionCountByOptions(@RequestHeader(value = "X-AUTH-TOKEN") String token);
}
