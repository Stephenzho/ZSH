package io.stephen.test.thread;

import io.stephen.test.BeanTe;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhoushuyi
 * @since 2018/5/31
 */
public class Concurrent {


    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();

        ThreadPoolExecutor executor =  new ThreadPoolExecutor(10, 20,
                1000L, TimeUnit.MILLISECONDS,
                queue);


        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {

                Integer ca = random.nextInt(300);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName()+"："+ca);
            });
        }
        Thread.sleep(7000);


        for (int i = 0; i < 200; i++) {
            queue.put(() -> {

                Integer ca = random.nextInt(300);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName()+"：新加的！啊啊啊:"+ca);
            });
        }


    }



}

