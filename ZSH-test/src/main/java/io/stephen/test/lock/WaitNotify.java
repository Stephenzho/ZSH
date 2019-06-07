package io.stephen.test.lock;

import org.junit.Test;

/**
 * @author zhoushuyi
 * @since 2018/5/20
 */
public class WaitNotify {

    synchronized void look() throws InterruptedException {
        System.out.println("来看");

        this.wait();

        System.out.println("wait过后");

    }

    synchronized void notifys(){

        this.notifyAll();
        System.out.println("通知过后");
    }

    @Test
    public void test() throws InterruptedException {
        WaitNotify w = new WaitNotify();

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                try {
                    w.look();
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
            }
        };


        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                w.notifys();
            }
        };

        Thread h1 = new Thread(r1) ;
        h1.start();
        h1.join();


        Thread h2 = new Thread(r2) ;
        h2.start();
        h2.join();


    }


}
