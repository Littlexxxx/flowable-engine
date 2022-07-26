package cn.zswltech.preserver.infrastructure.common;


import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author: xinhao.hu
 * @date: 2022/3/31 1:51 下午
 * @description:
 **/
public interface IMapper<T> extends Mapper<T>, InsertListMapper<T> {
}
