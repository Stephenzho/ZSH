package io.stephen.demo.ChapterOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 选择算法
 *
 *
 * @author 10447
 * @since 2017/11/30
 */
public class SelectionSort {

    /**
     * 找出最小值
     * @param list
     * @return
     */
    public static Integer findSmallest(List<Integer> list) {
        int start = list.get(0);

        for (int i = 1 ; i< list.size() ;i++)
            if (start > list.get(i))
                start = list.get(i);

        return start;
    }

    /**
     * 选择排序
     * @param li
     * @return
     */
    public static List selectionSort(List<Integer> li) {
        List<Integer> arr = new ArrayList<>();

        Iterator iterator = li.iterator();

        while (iterator.hasNext()) {
            Integer min = findSmallest(li);

            arr.add(min);

            li.remove(min);
        }

        return arr;
    }

    public static void main(String[] arg) {
        int[] a = {3,1,2,5,7,-8,7,0};

        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(7);
        list.add(-2);
        list.add(0);


        System.out.println(selectionSort(list));
    }

}
