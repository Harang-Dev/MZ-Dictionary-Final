package com.dobby.mzdict.service;

import com.dobby.mzdict.mapper.UserMapper;
import com.dobby.mzdict.vo.RoleVO;
import com.dobby.mzdict.vo.LoginVO;
import com.dobby.mzdict.vo.UserVO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {
    private final UserMapper mapper;
    private final PasswordEncoder pwdEncoder;

    public UserService(UserMapper mapper, PasswordEncoder pwdEncoder) {
        this.mapper = mapper;
        this.pwdEncoder = pwdEncoder;
    }

    public UserVO getUser(int id) {
        return mapper.getUser(id);
    }

    public UserVO getUserByUserId(String userId){
        return mapper.getUserByUserId(userId);
    }

    public List<UserVO> getUsers() {
        return mapper.getUsers();
    }

    public Boolean login(LoginVO userInfo) {
        UserVO vo = mapper.getUserByUserId(userInfo.getUserId());
        return pwdEncoder.matches(userInfo.getPassword(), vo.getPassWord());
    }

    @Transactional
    public UserVO register(UserVO userInfo) {
        UserVO vo = mapper.getUserByUserId(userInfo.getUserId());
        if (vo != null) {
            throw new RuntimeException("이미 존재하는 아이디입니다: " + userInfo.getUserId());
        }

        LocalDateTime now = LocalDateTime.now();

        userInfo.setCreateTime(now);
        userInfo.setUpdateTime(now);

        String encryptPassword = pwdEncoder.encode(userInfo.getPassWord());
        userInfo.setPassWord(encryptPassword);

        mapper.addUser(userInfo);
        int userIndex = mapper.getUserByUserId(userInfo.getUserId()).getId();

        RoleVO auth = new RoleVO(userIndex, "ROLE_USER");
        mapper.addRole(auth);

        return mapper.getUserByUserId(userInfo.getUserId());
    }
}
