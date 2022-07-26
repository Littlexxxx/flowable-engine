package cn.zswltech.preserver.core.extract.impl;

import cn.zswltech.preserver.admin.middle.data.service.ExtractDataBeforeService;
import cn.zswltech.preserver.core.datasource.constant.ColumnInfo;
import cn.zswltech.preserver.core.datasource.constant.DataTypeEnum;
import cn.zswltech.preserver.core.extract.DataExtract;
import cn.zswltech.preserver.core.extract.constant.ExtractTypeEnum;
import cn.zswltech.preserver.core.datasource.DataSource;
import cn.zswltech.preserver.core.extract.context.ExtractContext;
import cn.zswltech.preserver.data.source.domain.DataSourceModel;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: xinhao.hu
 * @date: 2022/5/19 10:17 上午
 * @description:
 **/
@Component
public class LocalMiddleDataExtract implements DataExtract {

    @Autowired
    private ExtractDataBeforeService extractDataBeforeService;

    @Resource(name = "mysqlDataSourceImpl")
    private DataSource dataSource;

    @Override
    public List<Map<String, Object>> entireExtract(ExtractContext extractContext) {
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Map<String, Object>> incrementExtract(ExtractContext extractContext) {
        DataSourceModel dataSourceModel = extractContext.getDataSourceModel();
        List<Map<String,String>> extractDatas = extractDataBeforeService.extractData(dataSourceModel);
        Map<String, ColumnInfo> columnInfoMap = dataSource.parseMetaData(dataSourceModel);
        List<Map<String,Object>> res = Lists.newArrayList();
        for(Map<String,String> data : extractDatas){
            Map<String,Object> transferData = new HashMap<>();
            data.forEach((k,v)->{
                ColumnInfo columnInfo = columnInfoMap.get(k);
                Object value = DataTypeEnum.getByName(columnInfo.getType()).parseValueByType(v);
                transferData.put(k,value);
            });
            res.add(transferData);
        }

        return res;
    }

    @Override
    public ExtractTypeEnum getType() {
        return ExtractTypeEnum.LOCAL;
    }
}
