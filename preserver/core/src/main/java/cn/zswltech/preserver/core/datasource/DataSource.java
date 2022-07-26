package cn.zswltech.preserver.core.datasource;

import cn.zswltech.preserver.core.datasource.constant.ColumnInfo;
import cn.zswltech.preserver.data.source.domain.DataSourceModel;

import java.util.Map;

/**
 * @author: xinhao.hu
 * @date: 2022/5/12 3:37 下午
 * @description:
 **/
public interface DataSource {
    Map<String, ColumnInfo> parseMetaData(DataSourceModel dataSourceModel);

    Boolean testConnection(DataSourceModel dataSourceModel);

    String getName();
}
