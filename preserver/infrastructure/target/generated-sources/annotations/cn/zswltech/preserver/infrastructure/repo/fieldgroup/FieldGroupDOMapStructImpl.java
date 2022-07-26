package cn.zswltech.preserver.infrastructure.repo.fieldgroup;

import cn.zswltech.preserver.field.control.domain.fieldgroup.FieldGroup;
import cn.zswltech.preserver.infrastructure.dataobject.FieldGroupDO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-24T21:26:59+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_302 (BellSoft)"
)
@Component
public class FieldGroupDOMapStructImpl implements FieldGroupDOMapStruct {

    @Override
    public FieldGroupDO toFieldGroupDO(FieldGroup fieldGroup) {
        if ( fieldGroup == null ) {
            return null;
        }

        FieldGroupDO fieldGroupDO = new FieldGroupDO();

        fieldGroupDO.setId( fieldGroup.getId() );
        fieldGroupDO.setName( fieldGroup.getName() );
        fieldGroupDO.setCode( fieldGroup.getCode() );
        fieldGroupDO.setDesc( fieldGroup.getDesc() );
        fieldGroupDO.setGmtCreate( fieldGroup.getGmtCreate() );
        fieldGroupDO.setCreatedBy( fieldGroup.getCreatedBy() );
        fieldGroupDO.setGmtUpdate( fieldGroup.getGmtUpdate() );
        fieldGroupDO.setUpdatedBy( fieldGroup.getUpdatedBy() );

        return fieldGroupDO;
    }

    @Override
    public FieldGroup toFieldGroup(FieldGroupDO fieldGroupDO) {
        if ( fieldGroupDO == null ) {
            return null;
        }

        FieldGroup fieldGroup = new FieldGroup();

        fieldGroup.setId( fieldGroupDO.getId() );
        fieldGroup.setName( fieldGroupDO.getName() );
        fieldGroup.setCode( fieldGroupDO.getCode() );
        fieldGroup.setDesc( fieldGroupDO.getDesc() );
        fieldGroup.setGmtCreate( fieldGroupDO.getGmtCreate() );
        fieldGroup.setCreatedBy( fieldGroupDO.getCreatedBy() );
        fieldGroup.setGmtUpdate( fieldGroupDO.getGmtUpdate() );
        fieldGroup.setUpdatedBy( fieldGroupDO.getUpdatedBy() );

        return fieldGroup;
    }
}
