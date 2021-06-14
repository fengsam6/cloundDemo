package com.feng.auth.service;

import com.feng.auth.entity.JwtUser;
import com.feng.common.entity.ResponseResult;
import com.feng.user.entity.SkUser;
import com.feng.auth.feign.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;

public class DBUserDetailsService implements UserDetailsService {
    @Autowired
    private UserClient userClient;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        ResponseResult<SkUser> userResponse = userClient.getUserByUserName(userName);
        SkUser user = userResponse.getData();
        if (user == null) {
            return null;
        }
        return new JwtUser(user.getId(),userName, user.getPassword());
    }
}
