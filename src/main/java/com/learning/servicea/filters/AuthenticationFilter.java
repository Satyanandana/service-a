package com.learning.servicea.filters;

import com.learning.servicea.security.AuthContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Component
@Slf4j
public class AuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        AuthContext.setIsAuthenticated(true);
        AuthContext.setRequestId(UUID.randomUUID().toString().toUpperCase().replace("-", ""));
        log.info("Request on Service A -requestId {}",AuthContext.getRequestId());
        filterChain.doFilter(request, response);
    }
}
