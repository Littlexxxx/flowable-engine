package cn.hxh.demo111.core.adapter.application.case3.jucTest.threadlocal;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author: xinhao.hu
 * @date: 2021/12/30 5:06 下午
 * @description:
 **/
public class ThreadLocalTest {
    public static void main(String[] args) {
        List<DemoCall> tasks = Lists.newArrayList();
        for (int i = 0; i < 3; i++) {
            DemoCall call = new DemoCall(BookStoreManager.getBookStore());
            tasks.add(call);
        }
        List<Future> results = Lists.newArrayList();
        tasks.forEach(t -> {
            Future future = ThreadService.threadPoolCreate1.submit(t);
            results.add(future);
        });
        results.forEach(t -> {
            try {
                System.out.println((String) t.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

    }
}
