package io.stephen.security.demo.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;


/**
 * @author 10447
 * @since 2017/11/4
 */
@RestController
public class asyncController {

    private Logger logger =  LoggerFactory.getLogger(getClass());


    @RequestMapping("/order")
    public Callable<String> order() {
        logger.info("主线程开始");

        /*
           主线程调用副线程来处理，提高主线程效率，提高服务性能
         */
        Callable<String> result = new Callable<String>() {
            @Override
            public String call() throws Exception {
                logger.info("副线程开始");

                Thread.sleep(1000);

                logger.info("副线程结束");
                return "success";
            }
        };


        logger.info("主线程结束");
        return result;
    }




}
