package io.stephen.test.proxy;

import java.lang.reflect.Proxy;

/**
 * @author 10447
 * @since 2018/1/18
 */
public class ProxyTest {


    public static void main(String[] arg) {

        Car car = new Car();
        TimeProxy tp = new TimeProxy(car);


        Moveable m = (Moveable) Proxy.newProxyInstance(car.getClass().getClassLoader(), car.getClass().getInterfaces(), tp);


        System.out.println(m.move());
    }



}
