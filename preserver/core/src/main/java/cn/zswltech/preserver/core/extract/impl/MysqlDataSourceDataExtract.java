package cn.zswltech.preserver.core.extract.impl;

import cn.zswltech.preserver.core.datasource.DataSource;
import cn.zswltech.preserver.core.extract.DataExtract;
import cn.zswltech.preserver.core.extract.constant.ExtractTypeEnum;
import cn.zswltech.preserver.core.extract.context.ExtractContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author: xinhao.hu
 * @date: 2022/6/7 2:25 下午
 * @description:
 **/
@Component
public class MysqlDataSourceDataExtract implements DataExtract {

    @Resource(name = "mysqlDataSourceImpl")
    private DataSource mysqlDataSource;

    @Override
    public ExtractTypeEnum getType() {
        return ExtractTypeEnum.MYSQL;
    }

    @Override
    public List<Map<String, Object>> entireExtract(ExtractContext extractContext) {
        return null;
    }

    @Override
    public List<Map<String, Object>> incrementExtract(ExtractContext extractContext) {
        return null;
    }
}
