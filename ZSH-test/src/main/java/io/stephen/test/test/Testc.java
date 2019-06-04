package io.stephen.test.test;


import java.util.ArrayList;

/**
 * @author 10447
 * @since 2018/3/6
 */
public class Testc  {

    public static void main(String[] args) {

        System.out.println(fun(10, 0));

    }

    /**
     * @param n 递归的次数，例10
     * @param a 初始值，0
     * @return
     */
    public static int fun(int n, int a) {
        if (n <= 0) {
            return a;
        }
        a += 2;
        n--;
        return fun(n, a);
    }

}
