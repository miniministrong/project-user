package com.ebiz.user.handler;

import com.ebiz.user.commons.util.ResultModel;
import com.ebiz.user.exception.LoginException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dhl
 * @datetime 2021/8/13  13:25
 */
@RestControllerAdvice
public class LoginExceptionHandler {
    /**
     * 登录错误异常信息返回
     * @param e
     * @return
     */
    @ExceptionHandler(LoginException.class)
    public ResultModel loginErrorHandler(LoginException e) {
        String message = e.getMessage();
        Map resultMap = new HashMap();
        resultMap.put("loginError", message);
        return ResultModel.error(resultMap.toString());
    }
}