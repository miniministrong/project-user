package com.ebiz.user.dto;

import lombok.Data;
import lombok.ToString;

/**
 * @author 汶泽
 * @date 2021/8/15-21:46
 */
@Data
@ToString
public class UserDTO {
    private String username;
    private String password;

    public void setPassword(String password) {
        this.password = "**********";
    }
}
