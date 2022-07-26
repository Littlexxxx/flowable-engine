package cn.zswltech.preserver.core.event.mysql.orm;

import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;

public interface DomainEventMapper extends Mapper<DomainEventDO>, InsertListMapper<DomainEventDO> {

    List<DomainEventDO> query(@Param("startId") Long startId);

    Long minIdAfterGmtModify(@Param("gmtModify") Date gmtModify);
}