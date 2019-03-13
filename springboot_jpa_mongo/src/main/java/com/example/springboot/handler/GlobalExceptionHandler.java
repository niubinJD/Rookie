package com.example.springboot.handler;

import com.example.springboot.ReturnData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ReturnData jsonErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        LOGGER.error(e.getMessage());
        ReturnData r = new ReturnData(null, 500, e.getMessage());
        return r;
    }

}
