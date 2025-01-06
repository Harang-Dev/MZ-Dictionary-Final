package com.dobby.mzdict.controller;
import com.dobby.mzdict.model.CommonResult;
import com.dobby.mzdict.model.SingleResult;
import com.dobby.mzdict.vo.LoginVO;
import com.dobby.mzdict.vo.UserVO;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@Tag(name = "User", description = "사용자와 관련된 API 입니다.")
public interface UserControllerDocs {

    @Operation(summary = "회원가입", description = "회원가입 합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "회원가입 성공"),
            @ApiResponse(responseCode = "409", description = "회원가입 실패 (중복)")})
    public CommonResult userRegister(@RequestBody UserVO userInfo);

    @Operation(summary = "로그인", description = "로그인 기능을 테스트 합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "로그인 성공"),
            @ApiResponse(responseCode = "404", description = "로그인 실패")})
    public SingleResult<String> userLogin(@RequestBody LoginVO userInfo);

    @Operation(summary = "전체 유저 조회", description = "전체 유저 정보를 조회합니다")
    @ApiResponse(responseCode = "200", description = "유저 정보 조회 성공")
    public List<UserVO> getUsers(@RequestHeader(value = "X-AUTH-TOKEN", required = true) String token);

    @Operation(summary = "유저 조회", description = "특정 유저 정보를 조회합니다")
    @ApiResponse(responseCode = "200", description = "유저 정보 조회 성공")
    public UserVO getUser(@RequestHeader(value = "X-AUTH-TOKEN", required = true) String token);
}
