package cn.zswltech.preserver.infrastructure.repo.middledata;

import cn.zswltech.preserver.admin.middle.data.domain.after.ExtractDataAfter;
import cn.zswltech.preserver.infrastructure.common.Converter;
import cn.zswltech.preserver.infrastructure.dataobject.ExtractDataAfterDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author: xinhao.hu
 * @date: 2022/5/10 10:34 上午
 * @description: 
 **/
@Component
public class ExtractDataAfterConverter implements Converter<ExtractDataAfter, ExtractDataAfterDO> {
    @Resource
    private ExtractDataAfterDOMapStruct extractDataAfterDOMapStruct;

    @Override
    public ExtractDataAfterDO serialize(ExtractDataAfter extractDataAfter) {
        return extractDataAfterDOMapStruct.toExtractDataAfterDO(extractDataAfter);
    }

    @Override
    public ExtractDataAfter deserialize(ExtractDataAfterDO extractDataAfterDO) {
        return extractDataAfterDOMapStruct.toExtractDataAfter(extractDataAfterDO);
    }
}
