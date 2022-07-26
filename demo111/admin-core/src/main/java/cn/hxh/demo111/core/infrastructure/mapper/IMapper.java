package cn.hxh.demo111.core.infrastructure.mapper;

import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author: xinhao.hu
 * @date: 2022/1/26 5:14 下午
 * @description:
 **/

public interface IMapper<T> extends Mapper<T>, InsertListMapper<T> {
}
