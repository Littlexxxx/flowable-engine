package cn.zswltech.preserver.infrastructure.repo.middledata.before;

import cn.zswltech.preserver.admin.middle.data.domain.after.ExtractDataAfter;
import cn.zswltech.preserver.admin.middle.data.domain.before.ExtractDataBefore;
import cn.zswltech.preserver.infrastructure.dataobject.ExtractDataAfterDO;
import cn.zswltech.preserver.infrastructure.dataobject.ExtractDataBeforeDO;
import cn.zswltech.preserver.infrastructure.repo.middledata.ExtractDataAfterDOMapStruct;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author: xinhao.hu
 * @date: 2022/5/25 2:29 下午
 * @description:
 **/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ExtractDataBeforeDOMapStruct {
    ExtractDataBeforeDOMapStruct INSTANCE = Mappers.getMapper(ExtractDataBeforeDOMapStruct.class);


    ExtractDataBeforeDO toExtractDataBeforeDO(ExtractDataBefore extractDataBefore);

    ExtractDataBefore toExtractDataBefore(ExtractDataBeforeDO extractDataBeforeDO);
}
