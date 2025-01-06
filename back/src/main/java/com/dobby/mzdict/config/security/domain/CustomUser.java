package com.dobby.mzdict.config.security.domain;

import com.dobby.mzdict.vo.UserVO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
@Setter
public class CustomUser extends User {

    private UserVO user;

    public CustomUser(String userId, String password, Collection<? extends GrantedAuthority> authorities) {

        super(userId, password, authorities);
    }

    public CustomUser(UserVO user) {
        super(user.getUserId(), user.getPassWord(), user.getAuthorities());
    }

    public int getUserId() {
        return user.getId();
    }

    public String getUserName() {
        return user.getUserNickName();
    }
}
