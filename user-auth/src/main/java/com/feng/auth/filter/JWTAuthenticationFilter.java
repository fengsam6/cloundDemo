package com.feng.auth.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.feng.auth.entity.JwtUser;
import com.feng.auth.util.JwtTokenUtils;
import com.feng.common.util.ResponseUtil;
import com.feng.common.entity.ResponseResult;
import com.feng.user.entity.SkUser;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    /**
     * 并发情况的安全线程 - 为每个用户配置唯一的登录持久化状态
     */
    private ThreadLocal<Integer> rememberMe = new ThreadLocal<>();

    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    /**
     * 第一步：获取用户参数,并进行校验(用户名密码)
     *
     * @param request
     * @param response
     * @return
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            /**从输入流中获取到登录的信息*/
            SkUser loginUser = new ObjectMapper().readValue(request.getInputStream(), SkUser.class);
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginUser.getNickname(), loginUser.getPassword(), new ArrayList<>())
            );
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        /**获取上一步验证后的JwtUser对象*/
        JwtUser jwtUser = (JwtUser) authResult.getPrincipal();
//        boolean isRemember = rememberMe.get() == 1;
//        List<String> role = new ArrayList<>();
//        Collection<? extends GrantedAuthority> authorities = jwtUser.getAuthorities();
//        if (authorities != null && authorities.size() > 0) {
//            for (GrantedAuthority authority : authorities) {
//                role.add(authority.getAuthority());
//            }
//        }
        /**根据jwtUser信息该创建一个token*/
        String token = JwtTokenUtils.createToken(jwtUser, new ArrayList<>(), false);
        /**
         * 1.返回创建成功的token
         * 2.按照jwt的规定,最后请求的时候应该是 "Bearer token"
         * 3.返回token加上"Bearer "前缀
         */
        response.setHeader("token", JwtTokenUtils.TOKEN_PREFIX + token);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("token",token);
        jwtUser.setPassWord("protected");
        map.put("user",jwtUser);
        map.put("loginName",jwtUser.getUsername());
        ResponseUtil.out(response, ResponseResult.success(map,""));
    }
}
