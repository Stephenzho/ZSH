package io.stephen.demo;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author 10447
 * @since 2017/12/14
 */
public class test {


    public static void main(String[] arg){
        Scanner in = new Scanner(System.in);

        while(in.hasNext()){


            int start = in.nextInt();
            int end = in.nextInt();

            String result = "";
            boolean is = false;

            for(;start < end; start++){


                int s1 = start % 10;
                int s2 = start / 10 % 10;
                int s3 = start / 100;

                double bai = Math.pow(s1,3);
                double shi = Math.pow(s2,3);
                double ge = Math.pow(s3,3);

                double re = bai + shi + ge;

                if (re == start) {
                    is = true;
                    result = result + " " + start;
                }
            }


            if (is)
                System.out.println(result);
            else
                System.out.println("no");
        }
    }
}
