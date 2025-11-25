package com.clinica.proyecto.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class TokenFilter extends OncePerRequestFilter {
    @Autowired
    private AuthTokenService authTokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        boolean dashboardPath = uri.startsWith("/api/dashboard") && !"/api/dashboard".equals(uri);
        boolean staticPath = uri.endsWith(".html") || uri.endsWith(".css") || uri.endsWith(".js");
        boolean openPath = uri.equals("/") || uri.startsWith("/api/auth");

        if (dashboardPath) {
            String token = request.getHeader("X-Auth-Token");
            if (!authTokenService.isValid(token)) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
        }

        filterChain.doFilter(request, response);
    }
}
