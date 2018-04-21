package io.stephen.test.algorithm.sort;

import io.stephen.test.algorithm.testhelper.SortTestHelper;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * 插入排序
 * O(n^2)
 *
 * 排序算法受比较方式（方法）影响较大。
 *
 * @author 10447
 * @since 2018/3/26
 */
public class InsertionSort {


    public static void sort(Comparable[] list) {

        for (int i = 0; i < list.length; i++) {

            Comparable e = list[i];

            int j = i;
            for (; j > 0 && list[i-1].compareTo(e) > 0; j--)
                list[j] = list[j - 1];

            list[j] = e;
        }
    }


    public static void sort(int[] list) {
        for (int i = 0; i < list.length; i++) {

            int e = list[i];

            int j = i;
            for (; j > 0 && e < list[j - 1]; --j)
                list[j] = list[j - 1];

            list[j] = e;
        }
    }


    @Test
    public void test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        int[] param = SortTestHelper.generateRandomArrayInt(10000, 0, 100000);

        long start = System.currentTimeMillis();
        sort(param);
        long end = System.currentTimeMillis();

        long time =  end - start;
        System.out.println("排序,时间为：" + time);
    }
}
