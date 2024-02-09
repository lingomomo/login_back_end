package com.practice.p0208manager.exception;

import com.practice.p0208manager.vo.UserResult;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;


@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public UserResult defaultErrorHandler(Exception ex, HttpServletResponse response){
        ex.printStackTrace();
        //实际的状态码是200，改成500
        response.setStatus(500);
        //从jsr303异常里面获取message，把message传到页面去就行了
        if (ex instanceof BindException){
            BindException bindException = (BindException) ex;//从父亲强转为儿子
            BindingResult bindingResult = bindException.getBindingResult();
            ObjectError objectError = bindingResult.getAllErrors().get(0);
            String defaultMessage = objectError.getDefaultMessage();
            if (defaultMessage.length()<15)
                return  UserResult.error(defaultMessage);
        }
        //判断是否为我们抛出去的异常
        if (ex instanceof RuntimeException){
            String message = ex.getMessage();
            if (message.length()<15){
                return UserResult.error(message);
            }
        }
        return UserResult.error("システムエラー、管理者に連絡してください");
    }
}
