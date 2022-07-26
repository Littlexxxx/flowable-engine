package cn.zswltech.preserver.field.control.service.impl;

import cn.zswltech.preserver.field.control.domain.fieldgroup.FieldGroupRepository;
import cn.zswltech.preserver.field.control.service.FieldGroupService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2022/05/09.
 */
@Service
@Transactional
public class FieldGroupServiceImpl implements FieldGroupService {
    @Resource
    private FieldGroupRepository fieldGroupRepository;

}
