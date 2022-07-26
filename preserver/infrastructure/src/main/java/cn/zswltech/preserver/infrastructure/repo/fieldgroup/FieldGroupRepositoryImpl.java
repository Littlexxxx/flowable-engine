package cn.zswltech.preserver.infrastructure.repo.fieldgroup;

import cn.zswltech.preserver.field.control.domain.fieldgroup.FieldGroup;
import cn.zswltech.preserver.field.control.domain.fieldgroup.FieldGroupRepository;
import cn.zswltech.preserver.infrastructure.dataobject.FieldGroupDO;
import cn.zswltech.preserver.infrastructure.mapper.FieldGroupMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: xinhao.hu
 * @date: 2022/5/10 10:09 上午
 * @description:
 **/
@Repository
public class FieldGroupRepositoryImpl implements FieldGroupRepository {

    @Resource
    private FieldGroupMapper fieldGroupMapper;

    @Resource
    private FieldGroupConverter fieldGroupConverter;

    @Override
    public void update(FieldGroup fieldGroup) {
        FieldGroupDO fieldGroupDO = fieldGroupConverter.serialize(fieldGroup);
        fieldGroupMapper.updateByPrimaryKey(fieldGroupDO);
    }

    @Override
    public void delete(FieldGroup fieldGroup) {
        FieldGroupDO fieldGroupDO = fieldGroupConverter.serialize(fieldGroup);
        fieldGroupMapper.delete(fieldGroupDO);
    }

    @Override
    public void create(FieldGroup fieldGroup) {
        FieldGroupDO fieldGroupDO = fieldGroupConverter.serialize(fieldGroup);
        fieldGroupMapper.insert(fieldGroupDO);
    }

    @Override
    public FieldGroup getFieldGroup(int id) {
        FieldGroupDO fieldGroupDO = fieldGroupMapper.selectByPrimaryKey(id);
        return fieldGroupConverter.deserialize(fieldGroupDO);
    }

    @Override
    public List<FieldGroup> searchFieldGroup() {
        List<FieldGroupDO> fieldGroupDOList = fieldGroupMapper.selectAll();
        return fieldGroupDOList.stream().map(fieldGroupConverter::deserialize).collect(Collectors.toList());
    }
}
