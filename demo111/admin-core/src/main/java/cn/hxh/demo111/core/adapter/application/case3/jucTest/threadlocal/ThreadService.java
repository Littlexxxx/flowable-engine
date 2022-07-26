package cn.hxh.demo111.core.adapter.application.case3.jucTest.threadlocal;

import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.*;

/**
 * @author: xinhao.hu
 * @date: 2021/12/30 4:12 下午
 * @description:
 **/
public class ThreadService {
    public static final ThreadPoolExecutor threadPoolCreate1 = new ThreadPoolExecutor(
            5,
            10,
            5000,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy()
    );

    public static final ExecutorService threadPoolCreate2 = Executors.newCachedThreadPool(
            new CustomizableThreadFactory("springThread-pool-")
    );



}
