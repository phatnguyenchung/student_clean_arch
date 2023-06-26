package com.example.studentcleanarch.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //    private final TokenAuthenticationFilter tokenAuthenticationFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors()
                .and()
                .csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling()
                .accessDeniedHandler(new TokenAccessDeniedHandler())
                .and()
                .authorizeRequests()
                .antMatchers(
                        "/api-docs**",
                        "/api-docs/**",
                        "/api-docs/**/*",
                        "/swagger-ui",
                        "/swagger-ui/**",
                        "/swagger-ui/**/*",
                        "/health",
                        "/**",
                        "/health/readiness",
                        "/config/**")
                .permitAll()
                .anyRequest()
                .authenticated();
        //                .and()
        //                .addFilterBefore(tokenAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }

    private static class TokenAccessDeniedHandler implements AccessDeniedHandler {
        @Override
        public void handle(
                HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e)
                throws IOException {
            httpServletResponse.setContentType("application/json");
            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpServletResponse
                    .getWriter()
                    .print(HttpStatus.UNAUTHORIZED.name() + ": " + HttpStatus.UNAUTHORIZED.getReasonPhrase());
        }
    }
}
