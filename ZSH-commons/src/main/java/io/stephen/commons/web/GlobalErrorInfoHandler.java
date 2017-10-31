package io.stephen.commons.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


/**
 * @author 10447
 * @since 2017/8/4
 */
@ControllerAdvice
public class GlobalErrorInfoHandler {


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultBody errorHandlerOverJson(Exception exception) {

        String message = exception.getMessage();

        System.err.println(exception);

        return new ResultBody(HttpStatus.INTERNAL_SERVER_ERROR.toString(),message);
    }

}
