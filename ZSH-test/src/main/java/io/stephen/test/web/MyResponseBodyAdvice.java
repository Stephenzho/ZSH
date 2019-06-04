package io.stephen.test.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import io.stephen.test.filter.DESHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author 10447
 * @since 2018/4/16
 */
@RestControllerAdvice(basePackages = "io.stephen.test.controller")
public class MyResponseBodyAdvice  implements ResponseBodyAdvice {


    private final static Logger logger = LoggerFactory.getLogger(MyResponseBodyAdvice.class);

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        logger.info("对方法method :【" + methodParameter.getMethod().getName() + "】返回数据进行加密");

        Gson gson = new Gson();
        try {
            String result = gson.toJson(body);
            return DESHelper.decrypt(result);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("对方法method :【" + methodParameter.getMethod().getName() + "】返回数据进行解密出现异常："+e.getMessage());
        }
        return body;
    }

}
