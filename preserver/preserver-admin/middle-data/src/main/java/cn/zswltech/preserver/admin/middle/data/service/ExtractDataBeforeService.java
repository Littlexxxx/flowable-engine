package cn.zswltech.preserver.admin.middle.data.service;

import cn.zswltech.preserver.data.source.domain.DataSourceModel;

import java.util.List;
import java.util.Map;

/**
 * @author: xinhao.hu
 * @date: 2022/5/25 2:54 下午
 * @description:
 **/
public interface ExtractDataBeforeService {
    List<Map<String,String>> extractData(DataSourceModel dataSourceModel);
}
