package io.stephen.test.test;

import org.junit.Test;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author 10447
 * @since 2018/3/6
 */
public class Testc extends HashMap {


    @Test
    public void tc() {
        new StringBuilder();

        new StringBuffer();

        new String();




    }








    public static void main(String[] arg) {

//        int[] num={2,5,7,9};
//        int count=0;   //计算满足条件的数的个数
//        for(int i=0;i<num.length;i++)
//            for(int j=0;j<num.length;j++)
//                for(int k=0;k<num.length;k++){
//                    if(num[i]!=num[j]&&num[i]!=num[k]&&num[j]!=num[k]){
//                        System.out.print(num[i]);
//                        System.out.print(num[j]);
//                        System.out.println(num[k]);
//                        count++;
//                    }
//                }
//        System.out.print("总共有"+count+"个。");

        int i=0;
        int j=0;
        int k=0;
        int x=0;
        System.out.print("请输入三个数\n");
        Scanner input = new Scanner(System.in);
        i=input.nextInt();
        j=input.nextInt();
        k=input.nextInt();
        if(i>j){
            x=i;
            i=j;
            j=x;
        }
        if(i>k){
            x=i;
            i=k;
            k=x;
        }
        if(j>k){
            x=j;
            j=k;
            k=x;
        }
        System.out.println(i+", "+j+", "+k);




    }



    @Test
    public  void main() {

        Scanner mscan = new Scanner(System.in);
        System.out.println("m的值位：");
        double m = mscan.nextDouble();
        System.out.println("n的值位：");
        double n = mscan.nextDouble();

        double cont = 0;

        for (int i =0; i<m; i++) {
            cont = cont + n;

            n = Math.sqrt(n);
        }

        System.out.println(cont);

    }



}
