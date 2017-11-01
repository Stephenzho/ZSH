package io.stephen.security.exceptionHandle;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 10447
 * @since 2017/10/31
 */
@ControllerAdvice
public class CommonExceptionHandle {

    /**
     * 自定义拦截controller异常，进行处理
     *
     * @param error
     * @return
     */
    @ExceptionHandler(value = CommonException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> exceptionHandle(CommonException error) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", error.getId());
        map.put("msg", error.getMessage());
        return map;
    }

}
