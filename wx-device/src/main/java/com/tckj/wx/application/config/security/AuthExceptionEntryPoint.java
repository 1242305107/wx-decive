package com.tckj.wx.application.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tckj.wx.application.common.util.ResultHelper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author WCH
 * @date 2020/6/28 14:40
 */
public class AuthExceptionEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException)
            throws ServletException {
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(response.getOutputStream(), ResultHelper.failed2Msg("身份认证错误"));
        } catch (Exception e) {
            throw new ServletException();
        }
    }
}