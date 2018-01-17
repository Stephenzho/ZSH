package io.stephen.commons;

import org.junit.Test;

import java.nio.CharBuffer;

/**
 * @author 10447
 * @since 2018/1/8
 */
public class BufferTest {

    @Test
    public void but() {
        double sum1 = 0, sum2 = 0, hight = 100.0;

        double m=0;

        for (int i = 0; i < 12; i++){
            sum1 = sum1 + hight;
            // 显示了一下高度的变化


            hight = hight / 2;
            if (i == 8) {
                m = hight;
            }


            if (i < 8){
                sum2 = sum2 + hight;
            }
        }


        System.out.println("第12次落地时，共经过" + (sum1 + sum2) + "米");
        System.out.println("第9次反弹高度为" + m + "米");

    }

    @Test
    public void a() {


        double h = 100.0, s1 = 0, s2 = 100.0;

        double sum = 0,m=0;

        for (int i=0; i<12;i++) {

            sum = sum + s1 + s2;

            h = h / 2;

            s1 = h;
            s2 = h;

            if (i == 8) {
                m = h;
            }
        }


        System.out.println("第12次落地时，共经过" + sum + "米");
        System.out.println("第9次反弹高度为" + m + "米");



    }



}
