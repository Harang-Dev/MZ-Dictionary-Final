package com.dobby.mzdict.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RoleMapperTest {
    @Autowired
    public RoleMapper roleMapper;

    @Test
    public void test() {
        roleMapper.getRoles();
    }
}
