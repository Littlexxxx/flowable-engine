package cn.zswltech.preserver.admin.middle.data.domain.before;

import cn.zswltech.preserver.admin.middle.data.domain.after.ExtractDataAfter;

import java.util.List;

/**
 * @author: xinhao.hu
 * @date: 2022/5/25 2:06 下午
 * @description:
 **/
public interface ExtractDataBeforeRepository {
    void update(ExtractDataBefore extractDataBefore);

    void delete(ExtractDataBefore extractDataBefore);

    void create(ExtractDataBefore extractDataBefore);

    ExtractDataBefore getExtractDataBefore(int id);

    List<ExtractDataBefore> searchUnextractDataByModelAndOrg(String model, int orgId, String status, int limit);
}
