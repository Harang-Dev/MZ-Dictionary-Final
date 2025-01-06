package com.dobby.mzdict.config.security;

import com.dobby.mzdict.config.security.domain.CustomUser;
import com.dobby.mzdict.mapper.UserMapper;
import com.dobby.mzdict.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserMapper mapper;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserVO userInfo = mapper.getUserByUserId(username);

        if (userInfo == null) {
            throw new UsernameNotFoundException(username);
        }

        return new CustomUser(userInfo);
    }

}
