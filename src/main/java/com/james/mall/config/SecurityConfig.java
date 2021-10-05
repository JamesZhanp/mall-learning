package com.james.mall.config;

import com.james.mall.component.RestAuthenticationEntryPoint;
import com.james.mall.component.RestfulAccessDeniedHandler;
import com.james.mall.service.UmsAdminService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author: JamesZhan
 * @create: 2021 - 10 - 02 15:47
 */
@Slf4j
@AllArgsConstructor
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UmsAdminService umsAdminService;
    private final RestfulAccessDeniedHandler restfulAccessDeniedHandler;
    private final RestAuthenticationEntryPoint restAuthenticationEntryPointer;

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
//                由于使用的是的JWT不需要csrf
                .csrf()
                .disable()
//                基于token不需要session
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
//                允许对于静态资源的未登录访问
                .antMatchers(HttpMethod.GET,
                        "/",
                        "/*.html",
                        "favicon.ico",
                        "/*/*.html",
                        "/*/*.css",
                        "/*/*.js",
                        "/swagger-resources/**",
                        "/v2/api-docs/**"
                        )
                .permitAll()
//                登录注册允许访问
                .antMatchers("/admin/login", "/admin/register")
                .permitAll()
//                跨域请求前会首先进行一次options请求
                .antMatchers(HttpMethod.OPTIONS)
                .permitAll()
//                  测试时允许全部访问
                  .antMatchers("/**")
                  .permitAll()
//                上述所有请求外均需要认证
                .anyRequest()
                .authenticated();
//        禁用缓存
        httpSecurity.headers().cacheControl();
//        httpSecurity.addFilterBefore(jwt)
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//        return username -> {
//            umsAdminService
//        }
//    }
}

