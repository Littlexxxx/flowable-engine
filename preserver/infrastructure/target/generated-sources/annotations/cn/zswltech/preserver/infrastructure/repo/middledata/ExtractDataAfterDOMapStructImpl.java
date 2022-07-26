package cn.zswltech.preserver.infrastructure.repo.middledata;

import cn.zswltech.preserver.admin.middle.data.domain.after.ExtractDataAfter;
import cn.zswltech.preserver.infrastructure.dataobject.ExtractDataAfterDO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-24T21:26:59+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_302 (BellSoft)"
)
@Component
public class ExtractDataAfterDOMapStructImpl implements ExtractDataAfterDOMapStruct {

    @Override
    public ExtractDataAfterDO toExtractDataAfterDO(ExtractDataAfter systemField) {
        if ( systemField == null ) {
            return null;
        }

        ExtractDataAfterDO extractDataAfterDO = new ExtractDataAfterDO();

        extractDataAfterDO.setId( systemField.getId() );
        extractDataAfterDO.setExtractId( systemField.getExtractId() );
        extractDataAfterDO.setStatus( systemField.getStatus() );
        extractDataAfterDO.setModel( systemField.getModel() );
        extractDataAfterDO.setOrg( systemField.getOrg() );
        extractDataAfterDO.setGmtCreate( systemField.getGmtCreate() );
        extractDataAfterDO.setCreatedBy( systemField.getCreatedBy() );
        extractDataAfterDO.setGmtUpdate( systemField.getGmtUpdate() );
        extractDataAfterDO.setUpdatedBy( systemField.getUpdatedBy() );
        extractDataAfterDO.setData( systemField.getData() );

        return extractDataAfterDO;
    }

    @Override
    public ExtractDataAfter toExtractDataAfter(ExtractDataAfterDO systemField) {
        if ( systemField == null ) {
            return null;
        }

        ExtractDataAfter extractDataAfter = new ExtractDataAfter();

        extractDataAfter.setId( systemField.getId() );
        extractDataAfter.setExtractId( systemField.getExtractId() );
        extractDataAfter.setStatus( systemField.getStatus() );
        extractDataAfter.setModel( systemField.getModel() );
        extractDataAfter.setOrg( systemField.getOrg() );
        extractDataAfter.setGmtCreate( systemField.getGmtCreate() );
        extractDataAfter.setCreatedBy( systemField.getCreatedBy() );
        extractDataAfter.setGmtUpdate( systemField.getGmtUpdate() );
        extractDataAfter.setUpdatedBy( systemField.getUpdatedBy() );
        extractDataAfter.setData( systemField.getData() );

        return extractDataAfter;
    }
}
