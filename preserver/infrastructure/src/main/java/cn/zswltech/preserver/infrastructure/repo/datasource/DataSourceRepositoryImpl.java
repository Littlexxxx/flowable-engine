package cn.zswltech.preserver.infrastructure.repo.datasource;

import cn.zswltech.preserver.data.source.domain.DataSourceModel;
import cn.zswltech.preserver.data.source.domain.DataSourceRepository;
import cn.zswltech.preserver.infrastructure.dataobject.DataSourceDO;
import cn.zswltech.preserver.infrastructure.mapper.DataSourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: xinhao.hu
 * @date: 2022/5/26 5:00 下午
 * @description:
 **/
@Repository
public class DataSourceRepositoryImpl implements DataSourceRepository {
    @Autowired
    private DataSourceConverter dataSourceConverter;

    @Autowired
    private DataSourceMapper dataSourceMapper;

    @Override
    public void update(DataSourceModel dataSourceModel) {

    }

    @Override
    public void delete(DataSourceModel dataSourceModel) {

    }

    @Override
    public void create(DataSourceModel dataSourceModel) {

    }

    @Override
    public DataSourceModel getDataSourcep(int id) {
        return null;
    }

    @Override
    public List<DataSourceModel> searchDataSource() {
        return null;
    }

    @Override
    public List<DataSourceModel> queryAll() {
        List<DataSourceDO> dataSourceDOList = dataSourceMapper.selectAll();
        return  dataSourceDOList.stream().map(dataSourceConverter::deserialize).collect(Collectors.toList());
    }
}
