package com.dobby.mzdict.mapper;

import com.dobby.mzdict.vo.RoleVO;
import com.dobby.mzdict.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public UserVO getUser(int id);
    public List<UserVO> getUsers();
    public UserVO getUserByUserId(String userId);

    public int addUser(UserVO userInfo);
    public void addRole(RoleVO roleVO);
}
