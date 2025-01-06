package com.dobby.mzdict.controller;

import com.dobby.mzdict.vo.LoginVO;
import com.dobby.mzdict.vo.UserVO;
import com.dobby.mzdict.vo.WordVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "Word", description = "단어와 관련된 API 입니다.")
public interface WordControllerDocs {

    @Operation(summary = "단어 조회", description = "DB에 저장된 모든 단어를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "단어 조회 성공"),
            @ApiResponse(responseCode = "204", description = "단어 조회 실패")})
    public Object getWords(@RequestHeader (value = "X-AUTH-TOKEN") String token);

    @Operation(summary = "특정 단어 조회", description = "DB에 저장된 단어 중 특정 단어를 조회합니다..")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "단어 조회 성공"),
            @ApiResponse(responseCode = "404", description = "단어 조회 실패")})
    public Object getWord(@RequestHeader (value = "X-AUTH-TOKEN") String token, @RequestParam int wordId);

    @Operation(summary = "단어 추가", description = "DB에 단어의 정보를 추가합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode= "200", description = "단어 추가 성공"),
            @ApiResponse(responseCode = "400", description = "단어 추가 실패")})
    public Object insertWord(@RequestHeader (value = "X-AUTH-TOKEN") String token, @RequestBody WordVO wordInfo);

    @Operation(summary = "단어 수정", description = "저장된 단어의 정보를 수정합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode= "200", description = "단어 수정 성공"),
            @ApiResponse(responseCode = "400", description = "단어 수정 실패")})
    public Object updateWord(@RequestHeader (value = "X-AUTH-TOKEN") String token, @RequestBody WordVO wordInfo);

    @Operation(summary = "단어 삭제", description = "저장된 단어의 정보를 삭제합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode= "200", description = "단어 삭제 성공"),
            @ApiResponse(responseCode = "400", description = "단어 삭제 실패")})
    public Object deleteWord(@RequestHeader (value = "X-AUTH-TOKEN") String token, @RequestParam int wordId);

    @Operation(summary = "단어 검색", description = "검색어를 기준으로 단어를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode= "200", description = "단어 검색 성공"),
            @ApiResponse(responseCode = "500", description = "단어 검색 실패")})
    public Object findWord(@RequestHeader(value = "X-AUTH-TOKEN") String token,  @RequestParam String keyWord);

}
