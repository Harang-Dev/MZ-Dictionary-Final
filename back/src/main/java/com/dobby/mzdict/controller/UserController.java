package com.dobby.mzdict.controller;

import com.dobby.mzdict.config.security.JwtTokenProvider;
import com.dobby.mzdict.model.CommonResult;
import com.dobby.mzdict.model.SingleResult;
import com.dobby.mzdict.service.UserService;
import com.dobby.mzdict.service.security.ResponseService;
import com.dobby.mzdict.vo.LoginVO;
import com.dobby.mzdict.vo.RoleVO;
import com.dobby.mzdict.vo.UserVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@RestController
@RequestMapping("/user")
public class UserController implements UserControllerDocs{

    private final UserService service;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final ResponseService responseService;

    public UserController(UserService service, JwtTokenProvider jwtTokenProvider, PasswordEncoder passwordEncoder, ResponseService responseService, ResponseService responseService1) {
        this.service = service;
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;
        this.responseService = responseService1;
    }

    @Override
    @PostMapping("/signup")
    public CommonResult userRegister(UserVO userInfo) {
        UserVO vo = service.register(userInfo);
        return responseService.getSuccessResult();
    }

    @Override
    @PostMapping("/signin")
    public SingleResult<String> userLogin(LoginVO userInfo) {
        UserVO vo = service.getUserByUserId(userInfo.getUserId());
        if (!passwordEncoder.matches(userInfo.getPassword(), vo.getPassWord())) {
            throw new RuntimeException();
        }

        List<String> sAuthList = new ArrayList<>();

        for (RoleVO role : vo.getAuthList()) {
            sAuthList.add(role.getRole());
        }
        return responseService.getSingleResult(jwtTokenProvider.createToken(String.valueOf(vo.getUserId()), sAuthList));
    }

    @GetMapping("/test")
    public List<UserVO> getUsers(@RequestHeader(value = "X-AUTH-TOKEN") String token) {
        return service.getUsers();
    }

    @GetMapping("/detail")
    public UserVO getUser(@RequestHeader(value = "X-AUTH-TOKEN", required = true) String token) {
        String userId = jwtTokenProvider.getUserPK(token);
        return service.getUserByUserId(userId);
    }
}
