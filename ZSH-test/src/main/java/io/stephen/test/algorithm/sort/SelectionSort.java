package io.stephen.test.algorithm.sort;

import io.stephen.test.algorithm.testhelper.SortTestHelper;
import org.junit.Test;

/**
 * 选择排序
 *
 *
 * @author 10447
 * @since 2017/11/30
 */
public class SelectionSort {


    /**
     * 选择排序
     * 时间复杂度 O(n^2)
     * @param list
     * @return
     */
    public static void sort(Comparable[] list) {

        for (int i = 0; i < list.length; i++) {

            /*
               找出当前最小值
             */
            int minIndex = i;           // 最小值下标
            for (int j = i + 1; j < list.length; j++) {
                if (list[minIndex].compareTo(list[j]) > 0) {
                    minIndex = j;
                }
            }

            /*
             * 当前最小值与i交换位置
             */
            Comparable iVal = list[i];
            list[i] = list[minIndex];
            list[minIndex] = iVal;
        }
    }

    public static void sort(int[] list) {

        for (int i = 0; i < list.length; i++) {

            /*
               找出当前最小值
             */
            int minIndex = i;           // 最小值下标
            for (int j = i + 1; j < list.length; j++) {
                if (list[minIndex] > (list[j]) ) {
                    minIndex = j;
                }
            }

            /*
             * 当前最小值与i交换位置
             */
            int iVal = list[i];
            list[i] = list[minIndex];
            list[minIndex] = iVal;
        }
    }


    @Test
    public void mainTest() {
        int[] param = SortTestHelper.generateRandomArrayInt(10000, 0, 100000);

        long start = System.currentTimeMillis();
        sort(param);
        long end = System.currentTimeMillis();

        long time =  end - start;
        System.out.println("排序,时间为：" + time);
    }

}
