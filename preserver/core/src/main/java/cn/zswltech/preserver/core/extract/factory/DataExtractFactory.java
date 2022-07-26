package cn.zswltech.preserver.core.extract.factory;

import cn.zswltech.preserver.core.extract.DataExtract;
import cn.zswltech.preserver.core.extract.constant.ExtractTypeEnum;
import cn.zswltech.preserver.core.spring.SpringContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * @author: xinhao.hu
 * @date: 2022/5/25 4:38 下午
 * @description: 根据类型获取DataExtract接口
 **/
@Component
public class DataExtractFactory {
    private Map<String, DataExtract> dataExtractMap = new HashMap<>();

    @PostConstruct
    public void init(){
        Collection<DataExtract> dataExtractImplList = SpringContextHolder.getBeansOfType(DataExtract.class);
        dataExtractImplList.forEach(dataExtract -> {
            dataExtractMap.put(dataExtract.getType().name(), dataExtract);
        });
    }

    public DataExtract getDataExtract(String type){
        return dataExtractMap.get(ExtractTypeEnum.valueOf(type).name());
    }
}
