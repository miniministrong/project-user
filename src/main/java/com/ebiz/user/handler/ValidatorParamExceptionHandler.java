package com.ebiz.user.handler;

import com.ebiz.user.commons.util.ResultModel;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dhl
 * @datetime 2021/8/13  9:29
 */
@RestControllerAdvice
public class ValidatorParamExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResultModel<?> validationErrorHandler(MethodArgumentNotValidException e) {
        List<String> errorInfo = e
                .getBindingResult()
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        return new ResultModel(400, errorInfo.toString());
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ResultModel validationParamErrorHandler(ConstraintViolationException e) {
        List<String> errorInfo = e
                .getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());
        return new ResultModel(400, errorInfo.toString());
    }
}