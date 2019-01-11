package io.stephen.test.enums;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author 10447
 * @since 2018/4/9
 */
public class test {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, InterruptedException {
/*       //获得构造器
        Constructor<En> con = En.class.getDeclaredConstructor();
        //设置为可访问
        con.setAccessible(true);
        //构造两个不同的对象
        En singleton1 = con.newInstance();
        En singleton2 = con.newInstance();
        //验证是否是不同对象
        System.out.println(singleton1.equals(singleton2));*/


        En.AB singleInstance = null;

    //    singleInstance  = En.SINGLE.getInstance();
        Class<?>[] pd =  En.class.getDeclaredClasses();

        System.out.println("属性有："+pd.length+"个");

        for (Class f : pd) {
            System.out.println(f);
            Constructor[] con =  f.getDeclaredConstructors();

            for (Constructor c : con) {
                c.setAccessible(true);
                System.out.println(c.newInstance());
            }

        }


        if (null != singleInstance){
            System.out.println(singleInstance);
        }else{
            System.out.println("null");
        }

    }
}
