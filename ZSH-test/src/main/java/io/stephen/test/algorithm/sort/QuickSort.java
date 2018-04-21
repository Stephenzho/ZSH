package io.stephen.test.algorithm.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 快速排序
 * @author 10447
 * @since 2017/12/2
 */
public class QuickSort {


    public static List<Integer> sort(List<Integer> list) {
        List left = new ArrayList<Integer>();
        List rigth = new ArrayList<Integer>();

        int index = list.size();

        Integer middle = list.get(index >> 1);
        list.remove(index >> 1);

        for (Integer i : list) {

            if (i.compareTo(middle) >= 0) {
                rigth.add(i);
            } else {
                if (i.compareTo(middle) < 0)
                    left.add(i);
            }
        }

        List<Integer> li = null;
        if (left.size() == 0) {
            li = new ArrayList<Integer>();
        }else{
            li = sort(left);
        }

        li.addAll(Arrays.asList(middle));

        if (rigth.size() != 0)
            li.addAll(sort(rigth));

        return li;


    }



    public static void main(String[] arg) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(7);
        list.add(-2);
        list.add(0);
        list.add(10);
        list.add(10);list.add(18);list.add(-3);list.add(4);list.add(1);list.add(6);list.add(-9);list.add(12);

        long start = System.currentTimeMillis();

        System.out.println(sort(list));

        System.out.println(start - System.currentTimeMillis());
    }


    @Test
    public void wei() {
        int a = 15;

        int n = a << 2;

        System.out.println(n);

    }


}
