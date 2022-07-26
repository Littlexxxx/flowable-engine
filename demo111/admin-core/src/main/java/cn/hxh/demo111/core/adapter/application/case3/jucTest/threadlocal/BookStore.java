package cn.hxh.demo111.core.adapter.application.case3.jucTest.threadlocal;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

/**
 * @author: xinhao.hu
 * @date: 2021/12/30 4:42 下午
 * @description:
 **/
@Data
public class BookStore {

    public BookStore(String name){
        this.name = name;
    }

    private String name;
    private List<Book> books = Lists.newArrayList();
}
