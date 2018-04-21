package io.stephen.test.sj;

import java.util.*;
import java.util.Map.Entry;

/**
 * @author 10447
 * @since 2018/3/16
 */
public class Sort {

    public static void main(String[] args) {


        int[] a = {1, 4, 2, 1, 3, 2,6,2, 1, 2,4};

        sort(a);
    }


    public static void sort(int[] par) {
        LinkedHashMap map = new LinkedHashMap<Integer,Integer>();

        for (int p : par) {
            Integer i  = Integer.valueOf(p);
            Integer value = (Integer) map.getOrDefault(i, 0);

            map.put(i, ++value);
        }


        Set<Entry> set =  map.entrySet();

        List<Entry> list = new ArrayList<Entry>();
        list.addAll(set);

        list = selectionSort(list);


        System.out.println(list);
    }

    public static List<Entry>  selectionSort(List<Entry> list) {

        //冒泡排序实现
        for (int i = 0; i < list.size() - 1; i++) {

            for (int j = 0; j < list.size() - i - 1; j++) {

                int v1 = (int) list.get(j).getValue();

                int v2 = (int) list.get(j+1).getValue();

                if (v1 < v2) {
                    Entry temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
        return list;
    }



}
