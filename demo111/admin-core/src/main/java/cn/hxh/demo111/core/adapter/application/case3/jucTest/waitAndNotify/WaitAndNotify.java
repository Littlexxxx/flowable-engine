package cn.hxh.demo111.core.adapter.application.case3.jucTest.waitAndNotify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: xinhao.hu
 * @date: 2022/1/1 11:29 上午
 * @description:
 **/
public class WaitAndNotify {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 2; i++) {
            pool.execute(new ThreadTest(i));
        }
    }
}
