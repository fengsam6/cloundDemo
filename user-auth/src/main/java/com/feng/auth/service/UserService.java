package com.feng.auth.service;

import com.feng.auth.entity.JwtUser;
import com.feng.auth.util.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    @Qualifier("userDetailsService")
    @Autowired
    private UserDetailsService dbUserDetailsService;
    public String login(String userName, String password) {
        UserDetails userDetails = dbUserDetailsService.loadUserByUsername(userName);
        if(userDetails!=null){
            return JwtTokenUtils.createToken((JwtUser) userDetails, new ArrayList<>(), false);
        }
        return null;
    }
}
