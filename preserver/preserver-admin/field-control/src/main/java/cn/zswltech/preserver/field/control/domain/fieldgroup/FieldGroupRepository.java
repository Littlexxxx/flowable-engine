package cn.zswltech.preserver.field.control.domain.fieldgroup;

import java.util.List;

/**
 * @author: xinhao.hu
 * @date: 2022/5/10 10:07 上午
 * @description:
 **/
public interface FieldGroupRepository {
    void update(FieldGroup fieldGroup);

    void delete(FieldGroup fieldGroup);

    void create(FieldGroup fieldGroup);

    FieldGroup getFieldGroup(int id);

    List<FieldGroup> searchFieldGroup();
}
