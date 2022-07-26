package cn.zswltech.preserver.infrastructure.repo.middledata.before;

import cn.zswltech.preserver.admin.middle.data.domain.after.ExtractDataAfter;
import cn.zswltech.preserver.admin.middle.data.domain.before.ExtractDataBefore;
import cn.zswltech.preserver.infrastructure.common.Converter;
import cn.zswltech.preserver.infrastructure.dataobject.ExtractDataAfterDO;
import cn.zswltech.preserver.infrastructure.dataobject.ExtractDataBeforeDO;
import cn.zswltech.preserver.infrastructure.repo.middledata.ExtractDataAfterDOMapStruct;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author: xinhao.hu
 * @date: 2022/5/25 2:30 下午
 * @description:
 **/
@Component
public class ExtractDataBeforeConverter implements Converter<ExtractDataBefore, ExtractDataBeforeDO> {
    @Resource
    private ExtractDataBeforeDOMapStruct extractDataBeforeDOMapStruct;

    @Override
    public ExtractDataBeforeDO serialize(ExtractDataBefore extractDataBefore) {
        return extractDataBeforeDOMapStruct.toExtractDataBeforeDO(extractDataBefore);
    }

    @Override
    public ExtractDataBefore deserialize(ExtractDataBeforeDO extractDataBeforeDO) {
        return extractDataBeforeDOMapStruct.toExtractDataBefore(extractDataBeforeDO);
    }
}
