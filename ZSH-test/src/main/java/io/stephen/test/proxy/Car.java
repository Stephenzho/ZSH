package io.stephen.test.proxy;

/**
 * @author 10447
 * @since 2018/1/18
 */
public class Car implements Moveable{
    @Override
    public String move() {
        System.out.println("汽车行驶中....");
        return "123123";
    }
}
