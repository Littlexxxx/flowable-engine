package cn.hxh.demo111.core.adapter.application.case3.jucTest.threadlocal;

import java.util.concurrent.Callable;

/**
 * @author: xinhao.hu
 * @date: 2021/12/30 4:39 下午
 * @description:
 **/
public class DemoCall implements Callable {

    private BookStore bookStore;

    public DemoCall(BookStore bookStore){
        this.bookStore = bookStore;
    }

    @Override
    public Object call() throws Exception {
        //bookStore = BookStoreManager.getBookStore();
        bookStore = BookStoreManager.getBookStoreWithoutThreadLocal();
        return bookStore.getName();
    }
}
