package io.stephen.test.enums;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author 10447
 * @since 2018/4/9
 */
public class test {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
  /*      //获得构造器
        Constructor<EnSingle.En> con = EnSingle.En.class.getDeclaredConstructor();
        //设置为可访问
        con.setAccessible(true);
        //构造两个不同的对象
        EnSingle.En singleton1 = (EnSingle.En)con.newInstance();
        EnSingle.En singleton2 = (EnSingle.En)con.newInstance();
        //验证是否是不同对象
        System.out.println(singleton1.equals(singleton2));*/

        EnSingle.En.aaa a =EnSingle.getInstance();
        System.out.println(a.toString());

    }
}
