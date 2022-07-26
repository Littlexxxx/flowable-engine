package cn.hxh.demo111.core.adapter.application.case3.jucTest.threadlocal;

/**
 * @author: xinhao.hu
 * @date: 2021/12/30 4:59 下午
 * @description:
 **/
public class BookStoreManager {
    private static final ThreadLocal<BookStore> bookStoreThreadLocal = new ThreadLocal<BookStore>(){
        @Override
        protected BookStore initialValue() {
            BookStore bookStore = new BookStore(Thread.currentThread().getName());
            return bookStore;
        }
    };

    public static BookStore getBookStore(){
        return bookStoreThreadLocal.get();
    }

    public static void setBookStore(){
        bookStoreThreadLocal.get().setName(Thread.currentThread().getName());
    }

    public static BookStore getBookStoreWithoutThreadLocal(){
        BookStore bookStore = new BookStore(Thread.currentThread().getName());
        return bookStore;
    }
}
