package cn.zswltech.preserver.core.datamap.context;

import cn.zswltech.preserver.field.control.domain.systemfield.SystemField;
import cn.zswltech.preserver.service.config.domain.ServiceConfig;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.compress.utils.Lists;

import java.util.List;
import java.util.Map;

/**
 * @author: xinhao.hu
 * @date: 2022/5/18 3:23 下午
 * @description:
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DataMappingContext {
    private List<Map<String,Object>> unExecuteDatas;

    private List<Map<SystemField,Object>> executedDatas;

    private ServiceConfig seviceConfig;

    private int extractId;
}
