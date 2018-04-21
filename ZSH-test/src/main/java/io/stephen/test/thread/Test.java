package io.stephen.test.thread;


import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 10447
 * @since 2018/1/25
 */
public class Test implements Serializable{

    public void aqs() {

        ReentrantLock lock = new ReentrantLock();
        lock.lock();




    }









    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        final List<Integer> l = new LinkedList<Integer>();

        ThreadPoolExecutor tp = new ThreadPoolExecutor(100, 100, 60,
                TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(20000));


        final Random random = new Random();

        for (int i = 0; i < 20000; i++){
            tp.execute(new Runnable(){
                public void run(){
                    l.add(random.nextInt());
                }
            });
        }

        tp.shutdown();

        try{
            tp.awaitTermination(1, TimeUnit.DAYS);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("用时："+String.valueOf(System.currentTimeMillis() - startTime));
        System.out.println("list长度为："+l.size());
    }


    @org.junit.Test
    public void test() throws InterruptedException, ExecutionException {
//        ExecutorService executor = Executors.newSingleThreadExecutor();
//
//
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("i思思"+ Thread.currentThread().getName());
//            }
//        });
//        thread.start();
//
//        Thread.sleep(2000);


        FutureTask futureTask = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                return "123";
            }
        });

        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

        Thread thread = new Thread(futureTask);
        thread.start();

        Thread.sleep(2000);

        System.out.println(futureTask.isDone());
        Object o = futureTask.get();

         if (!(o instanceof String)){
             System.out.println("不是string");
             return;
         }
         thread.interrupt();


        System.out.println((String) o);


    }


}