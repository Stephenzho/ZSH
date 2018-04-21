package io.stephen.test.algorithm.testhelper;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 10447
 * @since 2018/3/22
 */
public class SortTestHelper {

    public static Integer[] generateRandomArrayInteger(int n, int rangeL ,int rangeR) {
        assert rangeL <= rangeR;


        Integer[] integers = new Integer[n];

        for (int i = 0; i < n; i++) {
            double random = Math.random();
            integers[i] = Integer.valueOf((int)( random * (rangeR - rangeL + 1) + rangeL));
        }

        return integers;
    }

    public static int[] generateRandomArrayInt(int n, int rangeL ,int rangeR) {
        assert rangeL <= rangeR;


        int[] num = new int[n];

        for (int i = 0; i < n; i++) {
            double random = Math.random();
            num[i] = (int)( random * (rangeR - rangeL + 1) + rangeL);
        }

        return num;
    }





    public static int testSortMethod(Class methodClass) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {

        Integer[] param = SortTestHelper.generateRandomArrayInteger(10000, 0, 100000);

        Method method = methodClass.getDeclaredMethod("sort",Comparable.class);

        long start = System.currentTimeMillis();
        method.invoke(null,param);
        long end = System.currentTimeMillis();

        long time =  end - start;
        System.out.println("排序,时间为：" + time);
        return (int) time;
    }




    @Test
    public void test() {
        Integer[] arr = generateRandomArrayInteger(10, 0, 10);
        for (int i = 0; i < arr.length; i++){
            System.out.print( arr[i] );
            System.out.print( ' ' );
        }
        System.out.println();

    }
}
