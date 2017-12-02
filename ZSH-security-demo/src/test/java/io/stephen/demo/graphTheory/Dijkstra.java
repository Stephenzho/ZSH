package io.stephen.demo.graphTheory;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * Dijkstra算法
 *
 * @author 10447
 * @since 2017/12/2
 */
public class Dijkstra {

    public static Map<Integer,ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

    public static ArrayDeque<Integer> queue = new ArrayDeque<>();



    @Test
    public void start() {
        queue.add(1);
        queue.add(2);

        String re = "我-";

        while (!queue.isEmpty()) {
            Integer i = queue.poll();

            if (i == 10) {
                re = re + "终点";
                break;
            } else {
                re = re + i + "-";

                ArrayList<Integer> list = map.get(i);
                if (list == null) {
                    break;
                }
                queue.addAll(list);
            }


        }

        System.out.println(re);
    }

    @Before
    public void before() {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(3);
        list1.add(4);

        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add(4);
        list2.add(5);
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        list3.add(6);
        ArrayList<Integer> list4 = new ArrayList<Integer>();
        list4.add(5);
        list4.add(0);
        list4.add(6);

        ArrayList<Integer> list5 = new ArrayList<Integer>();
        list5.add(0);

        ArrayList<Integer> list6 = new ArrayList<Integer>();
        list6.add(0);

        map.put(1, list1);
        map.put(2, list2);
        map.put(3, list3);
        map.put(4, list4);
        map.put(5, list5);
        map.put(6, list6);



    }
}
