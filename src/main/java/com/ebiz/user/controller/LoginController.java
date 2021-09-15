package com.ebiz.user.controller;

import com.ebiz.user.commons.util.JwtUtils;
import com.ebiz.user.commons.util.ResultModel;
import com.ebiz.user.commons.validation.Login;
import com.ebiz.user.commons.validation.UserSave;
import com.ebiz.user.model.User;
import com.ebiz.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dhl
 * @datetime 2021/8/12  17:35
 */
@RestController
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResultModel login(@Validated(Login.class) @RequestBody User user){
        User userInfo = userService.loginAuthentication(user);
        if (userInfo != null) {
            String jsonWebToken = JwtUtils.sign(userInfo.getId());
            Map resultMap = new HashMap();
            resultMap.put("token", jsonWebToken);
            return ResultModel.success(resultMap);
        } else {
            return ResultModel.error("您的用户名或密码错误");
        }

    }

    @PostMapping("/register")
    public ResultModel register(@Validated(UserSave.class) @RequestBody User user) {
        user.setCreatedUser(user.getUsername());
        user.setCreatedDate(new Date());
        user.setModifiedUser(user.getUsername());
        user.setModifiedDate(new Date());
        user.setIsDelete(0);
        userService.saveUser(user);
        HashMap resultMap = new HashMap();
        resultMap.put("registerUserInfo", user.getId());
        return ResultModel.success(resultMap);
    }
}