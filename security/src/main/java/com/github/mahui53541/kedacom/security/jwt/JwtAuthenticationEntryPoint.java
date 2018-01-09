package com.github.mahui53541.kedacom.security.jwt;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * @description:用户未登录时返回
 * @author: MaHui
 * @created: 2018/1/9 9:52
 * @version:1.0.0
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

    /**
     * This is invoked when user tries to access a secured REST resource without supplying any credentials
     * @param httpServletRequest
     * @param httpServletResponse
     * @param e
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        // We should just send a 401 Unauthorized response because there is no 'login page' to redirect to
        //httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
        httpServletResponse.sendRedirect("/login");
    }
}
