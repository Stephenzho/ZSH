package io.stephen.test.enums;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 使用枚举实现绝对单例（抗反射）
 *
 * @author 10447
 * @since 2018/4/9
 */
public enum En{
    SINGLE;

    private AB ab;

    En(){
        System.out.println("初始化单例AB");
        ab = new AB();
    }


    public class AB{
        private String str = "123";

        private AB() {
        }

        @Override
        public String toString() {
            return "AB{" +
                    "str='" + str + '\'' +
                    '}';
        }
    }

    public AB getInstance(){
        return ab;
    }

}


