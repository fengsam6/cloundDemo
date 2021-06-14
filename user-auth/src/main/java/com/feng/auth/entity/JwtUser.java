package com.feng.auth.entity;

import com.feng.user.entity.SkUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class JwtUser implements UserDetails {

    /**
     * 用户ID
     */
    private long id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String passWord;
    /**
     * 权限信息
     */
    private Collection<? extends GrantedAuthority> authorities=new ArrayList<>();

    /**
     * 无参构造器
     */
    public JwtUser() {
    }

    /**
     * 使用user创建jwtUser的构造器
     *
     * @param user 用户对象
     */
    public JwtUser(SkUser user) {
        id = user.getId();
        userName = user.getNickname();
        passWord = user.getPassword();
    }

    public JwtUser(long id,String userName,String passWord) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return passWord;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "JwtUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", authorities=" + authorities +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
