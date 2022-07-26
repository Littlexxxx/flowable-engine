package cn.zswltech.preserver.core.cache;

import cn.zswltech.preserver.core.cache.api.ILocalCache;
import cn.zswltech.preserver.data.source.domain.DataSourceModel;
import cn.zswltech.preserver.data.source.domain.DataSourceRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author: xinhao.hu
 * @date: 2022/5/26 2:44 下午
 * @description:
 **/
@Component
public class DataSourceModelCache implements ILocalCache<Integer, DataSourceModel> {

    private Map<Integer, DataSourceModel> dataSourceModelCache = new HashMap();

    @Resource
    private DataSourceRepository dataSourceRepository;

    @Override
    public DataSourceModel get(Integer key) {
        return dataSourceModelCache.get(key);
    }

    @Override
    public void put(Integer key, DataSourceModel value) {
        dataSourceModelCache.put(key,value);
    }

    @Override
    public DataSourceModel remove(Integer key) {
        return dataSourceModelCache.remove(key);
    }

    @PostConstruct
    public void init(){
        List<DataSourceModel> dataSourceModelList = dataSourceRepository.queryAll();
        dataSourceModelCache.putAll(dataSourceModelList.stream().collect(Collectors.toMap(DataSourceModel::getId, Function.identity())));

    }
}
