package cn.zswltech.preserver.service.config.domain;

import java.util.List;

/**
 * @author: xinhao.hu
 * @date: 2022/5/10 2:44 下午
 * @description:
 **/
public interface ServiceConfigRepository {
    void update(ServiceConfig serviceConfig);

    void delete(ServiceConfig serviceConfig);

    void create(ServiceConfig serviceConfig);

    ServiceConfig getFieldGroup(int id);

    List<ServiceConfig> searchFieldGroup();

    List<ServiceConfig> queryAll();
}
