package cn.zswltech.preserver.field.control.domain.systemfield;

import java.util.List;

/**
 * @author: xinhao.hu
 * @date: 2022/5/10 10:07 上午
 * @description:
 **/
public interface SystemFieldRepository {
    SystemField getSystemField(int id);

    List<SystemField> searchSystemFields();

    void update(SystemField systemField);

    void delete(SystemField systemField);

    void create(SystemField systemField);

    List<SystemField> queryAll();

}
