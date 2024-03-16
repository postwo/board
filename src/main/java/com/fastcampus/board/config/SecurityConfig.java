package com.fastcampus.board.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

//@EnableWebSecurity // 이거는 spring boot에서 spring security를 연동해서 쓸 때는 auto-config 안에 들어가 있다 그래서 안만들어도 된다
@Configuration
public class SecurityConfig  {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       return http
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll()) // auth를 받아서 auth에 어떤 리퀘스트든 다 열겠다고 하겠다
                .formLogin().and()//formLogin을 사용해서 로그인 페이지를 만들게끔 유도한다
               .build();
       // return http.build();
    }

}
