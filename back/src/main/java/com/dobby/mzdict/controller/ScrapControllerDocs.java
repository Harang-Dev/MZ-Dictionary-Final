package com.dobby.mzdict.controller;

import com.dobby.mzdict.vo.CommentVO;
import com.dobby.mzdict.vo.ScrapVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "Scrap", description = "스크랩 관련 API 입니다.")
public interface ScrapControllerDocs {
    @Operation(summary = "스크랩 조회", description = "DB에 저장된 스크랩을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode= "200", description = "스크랩 조회 성공"),
            @ApiResponse(responseCode = "500", description = "스크랩 조회 실패")})
    public Object getScraps(@RequestHeader(value = "X-AUTH-TOKEN") String token);

    @Operation(summary = "스크랩 추가", description = "스크랩을 추가합니다..")
    @ApiResponses(value = {
            @ApiResponse(responseCode= "200", description = "스크랩 추가 성공"),
            @ApiResponse(responseCode = "500", description = "스크랩 추가 실패")})
    public Object addScrap(@RequestHeader(value = "X-AUTH-TOKEN") String token, @RequestParam int wordId);

    @Operation(summary = "스크랩 삭제", description = "스크랩을 삭제 합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode= "200", description = "스크랩 삭제 성공"),
            @ApiResponse(responseCode = "500", description = "스크랩 삭제 실패")})
    public Object deleteScrap(@RequestHeader(value = "X-AUTH-TOKEN") String token, @RequestParam int wordId);
}
