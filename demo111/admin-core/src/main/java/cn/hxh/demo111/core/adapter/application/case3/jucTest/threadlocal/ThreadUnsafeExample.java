package cn.hxh.demo111.core.adapter.application.case3.jucTest.threadlocal;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadUnsafeExample {

    private AtomicInteger cnt = new AtomicInteger(0);

    public void add() {
        cnt.getAndAdd(1);
    }

    public int get() {
        return cnt.get();
    }
}