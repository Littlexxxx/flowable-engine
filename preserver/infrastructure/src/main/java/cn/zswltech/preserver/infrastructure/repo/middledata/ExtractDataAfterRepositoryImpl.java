package cn.zswltech.preserver.infrastructure.repo.middledata;


import cn.zswltech.preserver.admin.middle.data.domain.after.ExtractDataAfter;
import cn.zswltech.preserver.admin.middle.data.domain.after.ExtractDataAfterRepository;
import cn.zswltech.preserver.infrastructure.dataobject.ExtractDataAfterDO;
import cn.zswltech.preserver.infrastructure.mapper.ExtractDataAfterMapper;
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
public class ExtractDataAfterRepositoryImpl implements ExtractDataAfterRepository {

    @Resource
    private ExtractDataAfterMapper ExtractDataAfterMapper;

    @Resource
    private ExtractDataAfterConverter ExtractDataAfterConverter;

    @Override
    public ExtractDataAfter getExtractDataAfter(int id) {
        ExtractDataAfterDO ExtractDataAfterDO = ExtractDataAfterMapper.selectByPrimaryKey(id);
        return ExtractDataAfterConverter.deserialize(ExtractDataAfterDO);
    }

    @Override
    public List<ExtractDataAfter> searchExtractDataAfters() {
        List<ExtractDataAfterDO> ExtractDataAfterDOS = ExtractDataAfterMapper.selectAll();
        return  ExtractDataAfterDOS.stream().map(ExtractDataAfterConverter::deserialize).collect(Collectors.toList());
    }

    @Override
    public void update(ExtractDataAfter extractDataAfter) {
        ExtractDataAfterDO ExtractDataAfterDO = ExtractDataAfterConverter.serialize(extractDataAfter);
        ExtractDataAfterMapper.updateByPrimaryKey(ExtractDataAfterDO);
    }

    @Override
    public void delete(ExtractDataAfter extractDataAfter) {
        ExtractDataAfterDO ExtractDataAfterDO = ExtractDataAfterConverter.serialize(extractDataAfter);
        ExtractDataAfterMapper.delete(ExtractDataAfterDO);
    }

    @Override
    public void create(ExtractDataAfter extractDataAfter) {
        ExtractDataAfterDO ExtractDataAfterDO = ExtractDataAfterConverter.serialize(extractDataAfter);
        ExtractDataAfterMapper.insertSelective(ExtractDataAfterDO);
    }

    @Override
    public void batchInsert(List<ExtractDataAfter> list) {

    }
}
