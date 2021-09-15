package com.ebiz.user.commons.interceptor;

import com.ebiz.user.commons.util.JwtUtils;
import com.ebiz.user.exception.LoginException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author dhl
 * @datetime 2021/8/13  11:35
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (StringUtils.isNotBlank(token) && !JwtUtils.verify(token)) {
            return true;
        } else {
            throw new LoginException(-1, "token不正确");
        }
    }
}