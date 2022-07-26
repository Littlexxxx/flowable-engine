package cn.zswltech.preserver.core.datasource;

import cn.zswltech.preserver.core.extract.DataExtract;
import cn.zswltech.preserver.core.spring.SpringContextHolder;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * @author: xinhao.hu
 * @date: 2022/5/24 5:09 下午
 * @description:
 **/
@Component
@DependsOn("springContextHolder")
public class DataSourceFactory {
    private Map<String,DataSource> dataSourceMap = new HashMap<>();

    @PostConstruct
    public void init(){
        Collection<DataSource> dataSourceImplList = SpringContextHolder.getBeansOfType(DataSource.class);
        dataSourceImplList.forEach(dataSource -> {
            dataSourceMap.put(dataSource.getName(), dataSource);
        });
    }

    public DataSource getDataSource(String name){
        return dataSourceMap.get(name);
    }

}
