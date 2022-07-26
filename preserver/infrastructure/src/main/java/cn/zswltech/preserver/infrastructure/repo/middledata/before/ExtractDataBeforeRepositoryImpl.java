package cn.zswltech.preserver.infrastructure.repo.middledata.before;

import cn.zswltech.preserver.admin.middle.data.domain.before.ExtractDataBefore;
import cn.zswltech.preserver.admin.middle.data.domain.before.ExtractDataBeforeRepository;
import cn.zswltech.preserver.infrastructure.dataobject.ExtractDataBeforeDO;
import cn.zswltech.preserver.infrastructure.mapper.ExtractDataBeforeMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: xinhao.hu
 * @date: 2022/5/25 2:29 下午
 * @description:
 **/
@Repository
public class ExtractDataBeforeRepositoryImpl implements ExtractDataBeforeRepository {

    @Resource
    private ExtractDataBeforeMapper extractDataBeforeMapper;

    @Resource
    private ExtractDataBeforeConverter extractDataBeforeConverter;

    @Override
    public void update(ExtractDataBefore extractDataBefore) {
        ExtractDataBeforeDO extractDataBeforeDO = extractDataBeforeConverter.serialize(extractDataBefore);
        extractDataBeforeMapper.updateByPrimaryKey(extractDataBeforeDO);
    }

    @Override
    public void delete(ExtractDataBefore extractDataBefore) {
        ExtractDataBeforeDO extractDataBeforeDO = extractDataBeforeConverter.serialize(extractDataBefore);
        extractDataBeforeMapper.delete(extractDataBeforeDO);
    }

    @Override
    public void create(ExtractDataBefore extractDataBefore) {
        ExtractDataBeforeDO extractDataBeforeDO = extractDataBeforeConverter.serialize(extractDataBefore);
        extractDataBeforeMapper.insertSelective(extractDataBeforeDO);
    }

    @Override
    public ExtractDataBefore getExtractDataBefore(int id) {
        ExtractDataBeforeDO extractDataBeforeDO = extractDataBeforeMapper.selectByPrimaryKey(id);
        return extractDataBeforeConverter.deserialize(extractDataBeforeDO);
    }

    @Override
    public List<ExtractDataBefore> searchUnextractDataByModelAndOrg(String model, int orgId, String status, int limit) {
        PageHelper.startPage(1,limit,"gmtUpdate desc");
        Example example = new Example(ExtractDataBeforeDO.class);
        example.createCriteria().andEqualTo("orgId",orgId)
                .andEqualTo("model",model)
                .andEqualTo("status",status);
        List<ExtractDataBeforeDO> extractDatas = extractDataBeforeMapper.selectByExample(example);
        return extractDatas.stream()
                .map(extractDataBeforeConverter::deserialize)
                .collect(Collectors.toList());
    }

}
