package io.stephen.test.lock;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 10447
 * @since 2018/1/18
 */
public class LockTest {


    class ThreadDomain{
        private Lock lock = new ReentrantLock(true);

        public void testMethod() {
            try {

                lock.lock();
                System.out.println("ThreadName" + Thread.currentThread().getName() + "获得锁");

            } catch (Exception e) {
                lock.unlock();
            }
        }
    }


    @Test
    public void main() {
        ThreadDomain td = new ThreadDomain();


        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("线程" + Thread.currentThread().getName() + "运行了");
                td.testMethod();

            }
        };


        Thread[] t = new Thread[5];

        for (int i = 0; i < 5; i++)
            t[i] = new Thread(r);


        for (int i = 0; i < 5; i++)
            t[i].start();



    }




}
