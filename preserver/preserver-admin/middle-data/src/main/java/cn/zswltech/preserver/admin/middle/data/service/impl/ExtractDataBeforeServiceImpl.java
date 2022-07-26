package cn.zswltech.preserver.admin.middle.data.service.impl;

import cn.zswltech.preserver.admin.middle.data.domain.before.ExtractDataBefore;
import cn.zswltech.preserver.admin.middle.data.domain.before.ExtractDataBeforeRepository;
import cn.zswltech.preserver.admin.middle.data.domain.before.ExtractDataBeforeStatusEnum;
import cn.zswltech.preserver.admin.middle.data.service.ExtractDataBeforeService;
import cn.zswltech.preserver.data.source.domain.DataSourceModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author: xinhao.hu
 * @date: 2022/5/25 2:54 下午
 * @description:
 **/
@Service
public class ExtractDataBeforeServiceImpl implements ExtractDataBeforeService {

    @Autowired
    private ExtractDataBeforeRepository extractDataBeforeRepository;

    @Value("${preserver.extract.batch.size}")
    private int batchSize;

    @Override
    public List<Map<String,String>> extractData(DataSourceModel dataSourceModel){
        List<ExtractDataBefore> extractDataBefores =
                extractDataBeforeRepository.searchUnextractDataByModelAndOrg(dataSourceModel.getModel(), 1, ExtractDataBeforeStatusEnum.UNEXTRACT.name(),batchSize);

        List<Map<String,String>> result = Lists.newArrayList();
        for(ExtractDataBefore before : extractDataBefores){
            List<Map<String,String>> data = JSON.parseObject(before.getData(),new TypeReference<List<Map<String, String>>>(){});
            result.addAll(data);
            before.updateStatusAndExtractId(ExtractDataBeforeStatusEnum.EXTRACTED.name());extractDataBeforeRepository.update(before);

        }

        return result;
    }
}
