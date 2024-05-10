package com.example.hw5.config;

import com.example.hw5.oauth.PrincipalOauth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;


@Configuration //Security Config 같은 것들을 spring 에서 관리해줌, 필터에도 등록해줌.
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final PrincipalOauth2UserService principalOauth2UserService;
    private final CorsConfig corsConfig;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)
            throws Exception{
        http.csrf(AbstractHttpConfigurer::disable); //csrf 를 풀어주는 방식 (부정 클릭 등)
        http.addFilter(corsConfig.corsFilter());
        http.authorizeHttpRequests(au ->
                au.anyRequest().permitAll());
        http.oauth2Login(
                oauth -> oauth
                        .loginPage("/loginForm")
                        .defaultSuccessUrl("/home")
                        .userInfoEndpoint( //로직 처리가 이 밑에 코드에 들어간다. (security 처리 로직)
                                userInfo ->
                                        userInfo.userService(principalOauth2UserService)
                        )
        );
        return http.build();
    }
}