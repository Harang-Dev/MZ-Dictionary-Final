package com.dobby.mzdict.controller;

import com.dobby.mzdict.dto.UserQuizDTO;
import com.dobby.mzdict.vo.QuizVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "Quiz", description = "퀴즈에 관련한 API 입니다.")
public interface QuizControllerDocs {
    @Operation(summary = "퀴즈 추가", description = "퀴즈을 추가합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode= "200", description = "퀴즈 추가 성공"),
            @ApiResponse(responseCode = "400", description = "퀴즈 추가 실패")})
    public Object addQuiz(@RequestHeader(value = "X-AUTH-TOKEN") String token, @RequestBody QuizVO QuizInfo);

    @Operation(summary = "퀴즈 수정", description = "퀴즈을 수정합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode= "200", description = "퀴즈 수정 성공"),
            @ApiResponse(responseCode = "400", description = "퀴즈 수정 실패")})
    public Object updateQuiz(@RequestHeader(value = "X-AUTH-TOKEN") String token, @RequestBody QuizVO QuizInfo);

    @Operation(summary = "퀴즈 삭제", description = "퀴즈을 삭제합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode= "200", description = "퀴즈 삭제 성공"),
            @ApiResponse(responseCode = "400", description = "퀴즈 삭제 실패")})
    public Object deleteQuiz(@RequestHeader(value = "X-AUTH-TOKEN") String token, @RequestParam int QuizId);

    @Operation(summary = "퀴즈 조회", description = "특정 퀴즈의 데이터를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode= "200", description = "퀴즈 조회 성공"),
            @ApiResponse(responseCode = "400", description = "퀴즈 조회 실패")})
    public Object getQuizById(@RequestHeader(value = "X-AUTH-TOKEN") String token, @RequestParam int QuizId);

    @Operation(summary = "퀴즈 조회", description = "DB에 저장된 모든 퀴즈을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode= "200", description = "퀴즈 조회 성공"),
            @ApiResponse(responseCode = "400", description = "퀴즈 조회 실패")})
    public Object getQuizs(@RequestHeader(value = "X-AUTH-TOKEN") String token);

    @Operation(summary = "오늘의 퀴즈 조회", description = "오늘의 퀴즈을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode= "200", description = "오늘의 퀴즈 조회 성공"),
            @ApiResponse(responseCode = "400", description = "오늘의 퀴즈 조회 실패")})
    public Object getTodayQuiz(@RequestHeader(value = "X-AUTH-TOKEN") String token);

    @Operation(summary = "퀴즈 풀이", description = "퀴즈에 대한 정/오답을 처리합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode= "200", description = "퀴즈 풀이 성공"),
            @ApiResponse(responseCode = "400", description = "퀴즈 풀이 실패")})
    public Object userResolveQuiz(@RequestHeader(value = "X-AUTH-TOKEN") String token, @RequestBody UserQuizDTO QuizDTO);

    @Operation(summary = "퀴즈 풀이 여부 조회", description = "퀴즈에 대한 풀이를 진행했는지 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode= "200", description = "퀴즈 풀이 성공"),
            @ApiResponse(responseCode = "400", description = "퀴즈 풀이 실패")})
    public Object isQuiz(@RequestHeader(value = "X-AUTH-TOKEN") String token, @RequestParam int quizId);
}
