package com.ebiz.user.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dhl
 * @datetime 2021/8/13  11:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginException extends RuntimeException{
    private int code;
    private String message;

    public LoginException(String message) {
        super(message);
    }

    public LoginException(String message, Throwable cause) {
        super(message, cause);
    }
}