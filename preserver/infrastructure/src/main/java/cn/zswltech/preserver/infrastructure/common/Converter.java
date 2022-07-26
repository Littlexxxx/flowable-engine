package cn.zswltech.preserver.infrastructure.common;

public interface Converter<DomainEntity, DataObject> {

    DataObject serialize(DomainEntity domainEntity);

    DomainEntity deserialize(DataObject dataObject);
}