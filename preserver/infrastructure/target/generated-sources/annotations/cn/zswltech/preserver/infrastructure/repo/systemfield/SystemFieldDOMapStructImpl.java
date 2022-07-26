package cn.zswltech.preserver.infrastructure.repo.systemfield;

import cn.zswltech.preserver.field.control.domain.systemfield.SystemField;
import cn.zswltech.preserver.infrastructure.dataobject.SystemFieldDO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-24T21:26:59+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_302 (BellSoft)"
)
@Component
public class SystemFieldDOMapStructImpl implements SystemFieldDOMapStruct {

    @Override
    public SystemFieldDO toSystemFieldDO(SystemField systemField) {
        if ( systemField == null ) {
            return null;
        }

        SystemFieldDO systemFieldDO = new SystemFieldDO();

        systemFieldDO.setId( systemField.getId() );
        systemFieldDO.setName( systemField.getName() );
        systemFieldDO.setCode( systemField.getCode() );
        systemFieldDO.setDataType( systemField.getDataType() );
        if ( systemField.getFieldGroupId() != null ) {
            systemFieldDO.setFieldGroupId( String.valueOf( systemField.getFieldGroupId() ) );
        }
        systemFieldDO.setSuffixName( systemField.getSuffixName() );
        systemFieldDO.setGmtCreate( systemField.getGmtCreate() );
        systemFieldDO.setCreatedBy( systemField.getCreatedBy() );
        systemFieldDO.setGmtUpdate( systemField.getGmtUpdate() );
        systemFieldDO.setUpdatedBy( systemField.getUpdatedBy() );
        systemFieldDO.setDescription( systemField.getDescription() );
        systemFieldDO.setFieldInfo( systemField.getFieldInfo() );

        return systemFieldDO;
    }

    @Override
    public SystemField toSystemField(SystemFieldDO systemField) {
        if ( systemField == null ) {
            return null;
        }

        SystemField systemField1 = new SystemField();

        systemField1.setId( systemField.getId() );
        systemField1.setName( systemField.getName() );
        systemField1.setCode( systemField.getCode() );
        systemField1.setDataType( systemField.getDataType() );
        if ( systemField.getFieldGroupId() != null ) {
            systemField1.setFieldGroupId( Integer.parseInt( systemField.getFieldGroupId() ) );
        }
        systemField1.setSuffixName( systemField.getSuffixName() );
        systemField1.setGmtCreate( systemField.getGmtCreate() );
        systemField1.setCreatedBy( systemField.getCreatedBy() );
        systemField1.setGmtUpdate( systemField.getGmtUpdate() );
        systemField1.setUpdatedBy( systemField.getUpdatedBy() );
        systemField1.setDescription( systemField.getDescription() );
        systemField1.setFieldInfo( systemField.getFieldInfo() );

        return systemField1;
    }
}
