package cn.zswltech.preserver.core.extract;


import cn.zswltech.preserver.core.extract.constant.ExtractTypeEnum;
import cn.zswltech.preserver.core.extract.context.ExtractContext;
import cn.zswltech.preserver.data.source.domain.DataSourceModel;

import java.util.List;
import java.util.Map;

/**
 * @author: xinhao.hu
 * @date: 2022/5/19 11:02 上午
 * @description:
 **/
public interface DataExtract {

    ExtractTypeEnum getType();

    List<Map<String,Object>> entireExtract(ExtractContext extractContext);

    List<Map<String,Object>> incrementExtract(ExtractContext extractContext);
}
