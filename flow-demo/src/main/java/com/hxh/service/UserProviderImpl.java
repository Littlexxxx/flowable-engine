package com.hxh.service;

import cn.zswltech.flow.core.extension.provider.UserProvider;
import cn.zswltech.flow.core.extension.req.UserReq;
import cn.zswltech.flow.core.service.impl.FlowUserService;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: xinhao.hu
 * @date: 2022/7/12 5:12 下午
 * @description:
 **/
@Service
public class UserProviderImpl implements UserProvider {
    @Override
    public List<String> queryUserIdList(UserReq userReq) {
        return Lists.newArrayList("123");
    }
}
