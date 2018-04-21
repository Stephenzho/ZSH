package io.stephen.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author 10447
 * @since 2018/1/18
 */
public class TimeProxy implements InvocationHandler {

    private Object target;

    public TimeProxy(Object target) {
        super();
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("汽车开始行驶");

        Object s = method.invoke(target);

        System.out.println("汽车行驶结束："+s);



        return s;
    }



}
