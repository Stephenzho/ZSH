package io.stephen.commons.web;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @author 10447
 * @since 2017/8/4
 */
public class ResultBody implements Serializable {

    private static final long serialVersionUID = 4034141575693632511L;
    /**
     * 响应代码
     */
    private String code = HttpStatus.OK.toString();

    /**
     * 响应消息
     */
    private String message = HttpStatus.OK.getReasonPhrase();

    /**
     * 响应结果
     */
    private Object result = null;


    public ResultBody(String code, String message, Object result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public ResultBody(String code, String message) {
        this.code = code;
        this.message = message;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
