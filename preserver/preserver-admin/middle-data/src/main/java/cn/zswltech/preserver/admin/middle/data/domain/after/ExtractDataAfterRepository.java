package cn.zswltech.preserver.admin.middle.data.domain.after;

import java.util.List;

/**
 * @author: xinhao.hu
 * @date: 2022/5/18 5:29 下午
 * @description:
 **/
public interface ExtractDataAfterRepository {
    ExtractDataAfter getExtractDataAfter(int id);

    List<ExtractDataAfter> searchExtractDataAfters();

    void update(ExtractDataAfter extractDataAfter);

    void delete(ExtractDataAfter extractDataAfter);

    void create(ExtractDataAfter extractDataAfter);

    void batchInsert(List<ExtractDataAfter> list);
}
