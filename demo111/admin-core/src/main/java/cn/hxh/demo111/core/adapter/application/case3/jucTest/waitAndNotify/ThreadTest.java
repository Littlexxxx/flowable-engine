package cn.hxh.demo111.core.adapter.application.case3.jucTest.waitAndNotify;

import lombok.SneakyThrows;

import static java.lang.Thread.sleep;

public class ThreadTest implements Runnable {

    private static int runNum = 0;

    private int result;

    public ThreadTest(int result){
        this.result = result;
    }

    @Override
    public void run() {
        execute();
    }

    @SneakyThrows
    public void execute(){
        for (int i = 0; i < 10; i++) {
            //加synchronsized保证一次只有一个线程执行
            synchronized (ThreadTest.class){
                while((runNum & 1) == result){
                    ThreadTest.class.wait();
                }
                runNum++;
                System.out.print(i + " ");
                ThreadTest.class.notifyAll();

            }
        }
        char a = "ss".charAt(0);
    }
}