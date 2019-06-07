package io.stephen.test.invoke;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @author zhoushuyi
 * @since 2018/11/22
 */
public class MethodHandleTest {

    static class ClassA{
        public void println(String string) {
            System.out.println(string);
        }
    }


    public static MethodHandle getPrintlnMh(Object obj) throws NoSuchMethodException, IllegalAccessException {

        MethodType mt = MethodType.methodType(void.class, String.class);

        MethodHandle println = MethodHandles.lookup().findVirtual(obj.getClass(), "println", mt).bindTo(obj);

        return println;
    }



    public static void main(String[] args) throws Throwable {
        Object obj = System.currentTimeMillis() % 2 == 0 ? System.out : new ClassA();

        getPrintlnMh(obj).invokeExact("zhou");
    }


}
