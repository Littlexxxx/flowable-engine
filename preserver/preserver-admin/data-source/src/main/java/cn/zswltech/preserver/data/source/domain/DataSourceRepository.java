package cn.zswltech.preserver.data.source.domain;

import java.util.List;

/**
 * @author: xinhao.hu
 * @date: 2022/5/13 9:59 上午
 * @description:
 **/
public interface DataSourceRepository {
    void update(DataSourceModel dataSourceModel);

    void delete(DataSourceModel dataSourceModel);

    void create(DataSourceModel dataSourceModel);

    DataSourceModel getDataSourcep(int id);

    List<DataSourceModel> searchDataSource();

    List<DataSourceModel> queryAll();
}
