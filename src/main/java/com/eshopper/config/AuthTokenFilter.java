package com.eshopper.config;

import com.eshopper.model.Users;
import com.eshopper.service.CustomUserDetailsService;
import com.eshopper.utils.JwtUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AuthTokenFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);

    private final CustomUserDetailsService userDetailsService;
    private final JwtUtils jwtUtils;

    public AuthTokenFilter(final CustomUserDetailsService userRepo,
                           final JwtUtils jwtUtils) {
        this.userDetailsService = userRepo;
        this.jwtUtils = jwtUtils;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {
        try {
            // Get authorization header and validate
            final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
            logger.info("Header: {}", header);

            if (header == null || header.isEmpty() || !header.startsWith("Bearer ")) {
                chain.doFilter(request, response);
                return;
            }

            // Get jwt token and validate
            final String token = header.substring(7);
            if (!jwtUtils.validateJwtToken(token)) {
                chain.doFilter(request, response);
                return;
            }

            // Get user identity and set it on the spring security context
            String username = jwtUtils.getUserNameFromJwtToken(token);
            logger.info("Username: {}", username);
            Users user = userDetailsService.loadUserByUsername(username);
            logger.info("User: {}", user);

            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (Exception e) {
            logger.error("Cannot set user authentication: {}", e.getMessage());
        }
        chain.doFilter(request, response);
    }
}
