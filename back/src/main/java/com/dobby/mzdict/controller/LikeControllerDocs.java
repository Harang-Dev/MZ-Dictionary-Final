package com.dobby.mzdict.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "Like", description = "좋아요 관련 API 입니다.")
public interface LikeControllerDocs {
    @Operation(summary = "좋아요 조회", description = "DB에 저장된 좋아요를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode= "200", description = "좋아요 조회 성공"),
            @ApiResponse(responseCode = "500", description = "좋아요 조회 실패")})
    public Object getLikes(@RequestHeader(value = "X-AUTH-TOKEN") String token);

    @Operation(summary = "좋아요 추가", description = "좋아요을 추가합니다..")
    @ApiResponses(value = {
            @ApiResponse(responseCode= "200", description = "좋아요 추가 성공"),
            @ApiResponse(responseCode = "500", description = "좋아요 추가 실패")})
    public Object addLike(@RequestHeader(value = "X-AUTH-TOKEN") String token, @RequestParam int wordId);

    @Operation(summary = "좋아요 삭제", description = "좋아요을 삭제 합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode= "200", description = "좋아요 삭제 성공"),
            @ApiResponse(responseCode = "500", description = "좋아요 삭제 실패")})
    public Object deleteLike(@RequestHeader(value = "X-AUTH-TOKEN") String token, @RequestParam int wordId);
}
