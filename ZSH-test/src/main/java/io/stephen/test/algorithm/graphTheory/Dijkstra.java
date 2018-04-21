package io.stephen.test.algorithm.graphTheory;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author 10447
 * @since 2017/12/3
 */
public class Dijkstra {


    public static HashMap<String, ArrayList<HashMap>> map = new HashMap<String, ArrayList<HashMap>>();

    public static HashMap parent = new HashMap();

    public static HashMap consts = new HashMap();

    public static ArrayList processd = new ArrayList();



    @Test
    public void search() {
        String key = findLowestCostNode();

        while (key != null) {
            if ("终点".equals(key)) {
                break;
            }

            ArrayList<HashMap> ar = map.get(key);
            for (HashMap ma : ar) {

                Iterator iterator = ma.entrySet().iterator();

                while (iterator.hasNext()) {
                    HashMap.Entry ob = (HashMap.Entry) iterator.next();

                    Integer va1 = (Integer) ob.getValue() + (Integer) consts.get(key);
                    Integer va = (Integer) consts.get(ob.getKey());

                    if (va1.compareTo(va) == -1) {
                        consts.put(ob.getKey(), va1);
                        parent.put(ob.getKey(),key);

                    }

                    processd.add(key);
                }

            }


            key = findLowestCostNode();
        }

        System.out.println(parent);


    }

    public String findLowestCostNode() {
        Iterator it = consts.entrySet().iterator();

        Integer va = Integer.MAX_VALUE;
        String ke = null;
        while (it.hasNext()) {
            HashMap.Entry ob = (HashMap.Entry) it.next();

            String key = (String) ob.getKey();
            Integer value = (Integer) ob.getValue();

            if (va.compareTo(value) == 1 && !processd.contains(key)) {
                va = value;
                ke = key;
            }

        }


        return ke;
    }



    @Before
    public void before() {
        // ------------------
        ArrayList<HashMap> qi = new ArrayList<HashMap>();
        HashMap qia = new HashMap();
        qia.put("a", 6);
        HashMap qib = new HashMap();
        qib.put("b", 2);
        qi.add(qia);
        qi.add(qib);

        ArrayList<HashMap> lista = new ArrayList<HashMap>();
        HashMap amap = new HashMap();
        amap.put("终点", 1);
        lista.add(amap);

        ArrayList<HashMap> listb = new ArrayList<HashMap>();
        HashMap bmap1 = new HashMap();
        bmap1.put("a", 1);
        HashMap bmap2 = new HashMap();
        bmap2.put("终点", 5);
        listb.add(bmap1);
        listb.add(bmap2);

        map.put("起点",qi);
        map.put("a",lista);
        map.put("b",listb);
        map.put("终点", null);

        // ------------------
        parent.put("a", "起点");
        parent.put("b", "起点");
        parent.put("终点","-");

        // ---------------------
        consts.put("a", 6);
        consts.put("b", 2);
        consts.put("终点", Integer.MAX_VALUE);


    }
}
