package com.dobby.mzdict.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Data
public class UserVO {
    private int id;
    private String userId;
    private String userEmail;
    private String userNickName;
    private String passWord;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    private List<RoleVO> authList;

    public Collection<SimpleGrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (RoleVO role : authList) {
            System.out.println(role.toString());
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }

        return authorities;
    }
}
