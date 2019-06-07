package test;

import org.omg.SendingContext.RunTime;

import java.util.Timer;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhoushuyi
 * @since 2018/12/11
 */
public class Test {

    private AtomicInteger n = new AtomicInteger(0);

    @org.junit.Test
    public void tett() throws ExecutionException {

        ExecutorService executorService = Executors.newCachedThreadPool();


        executorService.submit(new Runnable() {
            @Override
            public void run() {


            }
        });




    }

}
