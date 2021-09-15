package com.ebiz.user.commons.util;

import lombok.Getter;
import lombok.ToString;

/**
 * @author dhl
 * @datetime 2021/8/12  17:08
 */
@Getter
@ToString
public class ResultModel<T> {
    private int code;
    private String message;
    private T content;

    public ResultModel() {
    }

    public ResultModel(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultModel(int code, String message, T content) {
        this.code = code;
        this.message = message;
        this.content = content;
    }

    public static <T> ResultModel<T> success(){
        return new ResultModel(0, "请求成功");
    }
    public static <T> ResultModel<T> success(T content){
        return new ResultModel(0 , "请求成功", content);
    }
    public static <T> ResultModel<T> success( String message, T content){
        return new ResultModel(0, message, content);
    }
    public static <T> ResultModel<T> error(){
        return new ResultModel<>(-1, "您的操作有误");
    }
    public static <T> ResultModel<T> error(String message){
        return new ResultModel<>(-1,message);
    }
    public static <T> ResultModel<T> error(int code, String message) {
        return new ResultModel<>(code, message);
    }
}