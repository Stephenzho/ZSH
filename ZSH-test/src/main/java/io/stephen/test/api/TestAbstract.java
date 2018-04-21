package io.stephen.test.api;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.System.gc;

/**
 * @author 10447
 * @since 2018/2/24
 */
public abstract class  TestAbstract {

    public static void main(String[] args){


        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("","");

        AtomicInteger integer = new AtomicInteger(1);
        integer.addAndGet(2);
        System.out.println(integer.get());



    }

    public TestAbstract() {
        System.out.println("123");

    }

    public  void syscous() {
        System.out.println("输出");
        gc();
    }


    static class abs{

    }
}
