package cn.hxh.demo111.core.adapter.application.mybatis;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author: xinhao.hu
 * @date: 2022/4/8 10:07 上午
 * @description:
 **/
public interface DemoMapper {
    String selectAll(@Param("id") int id);
}
