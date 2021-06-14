package com.feng.auth.config;

import com.feng.auth.filter.JWTAuthenticationFilter;
import com.feng.auth.filter.JWTAuthorizationFilter;
import com.feng.auth.handler.JWTAccessDeniedHandler;
import com.feng.auth.handler.JWTAuthenticationEntryPoint;
import com.feng.auth.service.DBUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //关闭跨域保护
        //关闭跨域保护
        http.cors().and().csrf().disable()
                // 无状态模式，不需要session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeRequests().antMatchers("/v2/**", "/swagger-resources/**", "/webjars/**", "/swagger-ui.html").permitAll()
                //  .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/auth/login")
                .permitAll()
                .and()
                /**添加自定义的登录拦截方式(JWTAuthenticationFilter配置类) 注意：顺序：JWTAuthenticationFilter必须在JWTAuthorizationFilter之前*/
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                /**添加自定义的请求拦截方式(JWTAuthorizationFilter配置类)*/
                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                /**不需要session*/
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                /**自定义异常处理(没有携带token或者token无效,JWTAuthenticationEntryPoint类配置处理)*/
                .exceptionHandling().authenticationEntryPoint(new JWTAuthenticationEntryPoint())
                /**添加无权限时的处理(JWTAccessDeniedHandler类配置无访问权限异常处理)*/
                .accessDeniedHandler(new JWTAccessDeniedHandler());

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(12);
//    }


    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        return new DBUserDetailsService();
    }
}