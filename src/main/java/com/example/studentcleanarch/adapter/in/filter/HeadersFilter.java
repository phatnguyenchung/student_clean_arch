package com.example.studentcleanarch.adapter.in.filter;

import com.example.studentcleanarch.adapter.in.rest.dto.request.Headers;
import com.example.studentcleanarch.application.holder.LogRefIdHolder;
import com.example.studentcleanarch.application.holder.UserIdHolder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class HeadersFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String tracerId = request.getHeader(Headers.CONTEXT_ID) == null
                ? UUID.randomUUID().toString()
                : request.getHeader(Headers.CONTEXT_ID);
        String userId = request.getHeader(Headers.USER_ID);
        Long lUserId = 0L;
        try {
            lUserId = Long.valueOf(userId);
        } catch (Exception e) {

        }
        LogRefIdHolder.set(tracerId);
        UserIdHolder.set(lUserId);
        filterChain.doFilter(request, response);
    }
}
