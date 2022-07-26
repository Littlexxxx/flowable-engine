package cn.zswltech.preserver.infrastructure.repo.middledata;

import cn.zswltech.preserver.admin.middle.data.domain.after.ExtractDataAfter;
import cn.zswltech.preserver.infrastructure.dataobject.ExtractDataAfterDO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author: xinhao.hu
 * @date: 2022/5/10 10:11 上午
 * @description:
 **/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ExtractDataAfterDOMapStruct {
    ExtractDataAfterDOMapStruct INSTANCE = Mappers.getMapper(ExtractDataAfterDOMapStruct.class);


    ExtractDataAfterDO toExtractDataAfterDO(ExtractDataAfter systemField);


    ExtractDataAfter toExtractDataAfter(ExtractDataAfterDO systemField);
}
