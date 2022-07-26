package cn.zswltech.preserver.infrastructure.repo.systemfield;

import cn.zswltech.preserver.field.control.domain.systemfield.SystemField;
import cn.zswltech.preserver.field.control.domain.systemfield.SystemFieldRepository;
import cn.zswltech.preserver.infrastructure.dataobject.SystemFieldDO;
import cn.zswltech.preserver.infrastructure.mapper.SystemFieldMapper;
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
public class SystemFieldRepositoryImpl implements SystemFieldRepository {

    @Resource
    private SystemFieldMapper systemFieldMapper;

    @Resource
    private SystemFieldConverter systemFieldConverter;

    @Override
    public SystemField getSystemField(int id) {
        SystemFieldDO systemFieldDO = systemFieldMapper.selectByPrimaryKey(id);
        return systemFieldConverter.deserialize(systemFieldDO);
    }

    @Override
    public List<SystemField> searchSystemFields() {
        List<SystemFieldDO> systemFieldDOS = systemFieldMapper.selectAll();
        return  systemFieldDOS.stream().map(systemFieldConverter::deserialize).collect(Collectors.toList());
    }

    @Override
    public void update(SystemField systemField) {
        SystemFieldDO systemFieldDO = systemFieldConverter.serialize(systemField);
        systemFieldMapper.updateByPrimaryKey(systemFieldDO);
    }

    @Override
    public void delete(SystemField systemField) {
        SystemFieldDO systemFieldDO = systemFieldConverter.serialize(systemField);
        systemFieldMapper.delete(systemFieldDO);
    }

    @Override
    public void create(SystemField systemField) {
        SystemFieldDO systemFieldDO = systemFieldConverter.serialize(systemField);
        systemFieldMapper.insert(systemFieldDO);
    }

    @Override
    public List<SystemField> queryAll() {
        List<SystemFieldDO> systemFieldDOS = systemFieldMapper.selectAll();
        return  systemFieldDOS.stream().map(systemFieldConverter::deserialize).collect(Collectors.toList());
    }
}
