package com.github.mahui53541.kedacom.core.exception;

import com.github.mahui53541.kedacom.core.vo.ReturnMessageVO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.AccessDeniedException;

/**
 * @description:全局异常处理
 * @author: MaHui
 * @created: 2018/1/4 14:40
 * @version:1.0.0
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

//    @ExceptionHandler(value=AccessDeniedException.class)
//    public String AccessDeniedExceptionHandler(HttpServletRequest request, AccessDeniedException exception) throws Exception{
//        return "user/login";
//    }
    /**
     * 所有异常报错
     * @param request
     * @param exception
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value=Exception.class)
    public ReturnMessageVO allExceptionHandler(HttpServletRequest request, Exception exception) throws Exception{
        return ReturnMessageVO.fail(exception.getMessage());
    }
}
