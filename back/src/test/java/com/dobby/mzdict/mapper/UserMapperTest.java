package com.dobby.mzdict.mapper;

import com.dobby.mzdict.vo.UserVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Log4j2
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() {
        List<UserVO> vo  = userMapper.getUsers();
        System.out.println(vo);
    }
}
