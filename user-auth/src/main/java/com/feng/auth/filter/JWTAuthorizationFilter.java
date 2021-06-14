package com.feng.auth.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.feng.auth.util.JwtTokenUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
    public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        /**
         * 获取请求头中的token
         */
        String tokenHeader = request.getHeader(JwtTokenUtils.TOKEN_HEADER);
        /**如果请求头中没有Authorization信息则直接执行放行(或者请求头中没有TOKEN_PREFIX前缀)*/
        if (tokenHeader == null || !tokenHeader.startsWith(JwtTokenUtils.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }
        try {
            /**如果请求头中有token,则进行解析,并且设置认证信息*/
            SecurityContextHolder.getContext().setAuthentication(getAuthentication(tokenHeader));
        } catch (Exception e) {
            /**返回json形式的错误信息*/
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            String reason = "统一处理，原因：" + e.getMessage();
            response.getWriter().write(new ObjectMapper().writeValueAsString(reason));
            response.getWriter().flush();
            return;
        }
        super.doFilterInternal(request, response, chain);

    }

    /**
     * 将token进行解析,获取用户信息,并且设置认证信息(对Token进行校验)
     * @param tokenHeader
     * @return
     */
    private UsernamePasswordAuthenticationToken getAuthentication(String tokenHeader) {
        String token = tokenHeader.replace(JwtTokenUtils.TOKEN_PREFIX, "");
        boolean expiration = JwtTokenUtils.isExpiration(token);
        if (!expiration) {
            String username = JwtTokenUtils.getUserName(token);
            List<String> roles = JwtTokenUtils.getUserRole(token);
            if (username != null) {
                return new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());
            }
        }
        return null;
    }

}
