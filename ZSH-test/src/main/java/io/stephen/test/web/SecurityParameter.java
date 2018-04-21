package io.stephen.test.web;

/**
 * @author 10447
 * @since 2018/4/16
 */
public @interface SecurityParameter {

    /**
     * 入参是否解密，默认解密
     */
    boolean inDecode() default true;

    /**
     * 出参是否加密，默认加密
     */
    boolean outEncode() default true;
}
