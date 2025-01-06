package com.dobby.mzdict.mapper;

import com.dobby.mzdict.vo.RoleVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {
    public List<RoleVO> getRoles();
    public RoleVO getRoleById(int id);
}
