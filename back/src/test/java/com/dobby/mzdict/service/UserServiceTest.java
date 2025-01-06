package com.dobby.mzdict.service;

import com.dobby.mzdict.vo.LoginVO;
import com.dobby.mzdict.vo.UserVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void test() {
        LoginVO vo = new LoginVO();
        vo.setUserId("string");
        vo.setPassword("string");

        userService.login(vo);
    }
}
