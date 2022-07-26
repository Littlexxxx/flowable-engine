package cn.hxh.demo111.core.infrastructure;

/**
 * @author: xinhao.hu
 * @date: 2022/1/26 4:49 下午
 * @description:
 **/
public interface Converter<DomainEntity,DataObject> {

    DomainEntity toDomainEntity(DataObject dataObject);

    DataObject toDataObject(DomainEntity domainEntity);
}
