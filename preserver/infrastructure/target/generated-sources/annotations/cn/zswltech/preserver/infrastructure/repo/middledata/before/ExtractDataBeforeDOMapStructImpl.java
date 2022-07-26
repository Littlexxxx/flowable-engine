package cn.zswltech.preserver.infrastructure.repo.middledata.before;

import cn.zswltech.preserver.admin.middle.data.domain.before.ExtractDataBefore;
import cn.zswltech.preserver.infrastructure.dataobject.ExtractDataBeforeDO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-24T21:26:58+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_302 (BellSoft)"
)
@Component
public class ExtractDataBeforeDOMapStructImpl implements ExtractDataBeforeDOMapStruct {

    @Override
    public ExtractDataBeforeDO toExtractDataBeforeDO(ExtractDataBefore extractDataBefore) {
        if ( extractDataBefore == null ) {
            return null;
        }

        ExtractDataBeforeDO extractDataBeforeDO = new ExtractDataBeforeDO();

        extractDataBeforeDO.setId( extractDataBefore.getId() );
        extractDataBeforeDO.setStatus( extractDataBefore.getStatus() );
        extractDataBeforeDO.setModel( extractDataBefore.getModel() );
        extractDataBeforeDO.setOrgId( extractDataBefore.getOrgId() );
        extractDataBeforeDO.setGmtCreate( extractDataBefore.getGmtCreate() );
        extractDataBeforeDO.setCreatedBy( extractDataBefore.getCreatedBy() );
        extractDataBeforeDO.setGmtUpdate( extractDataBefore.getGmtUpdate() );
        extractDataBeforeDO.setUpdatedBy( extractDataBefore.getUpdatedBy() );
        extractDataBeforeDO.setData( extractDataBefore.getData() );
        extractDataBeforeDO.setExtractId( String.valueOf( extractDataBefore.getExtractId() ) );

        return extractDataBeforeDO;
    }

    @Override
    public ExtractDataBefore toExtractDataBefore(ExtractDataBeforeDO extractDataBeforeDO) {
        if ( extractDataBeforeDO == null ) {
            return null;
        }

        ExtractDataBefore extractDataBefore = new ExtractDataBefore();

        extractDataBefore.setId( extractDataBeforeDO.getId() );
        extractDataBefore.setStatus( extractDataBeforeDO.getStatus() );
        extractDataBefore.setModel( extractDataBeforeDO.getModel() );
        extractDataBefore.setOrgId( extractDataBeforeDO.getOrgId() );
        extractDataBefore.setGmtCreate( extractDataBeforeDO.getGmtCreate() );
        extractDataBefore.setCreatedBy( extractDataBeforeDO.getCreatedBy() );
        extractDataBefore.setGmtUpdate( extractDataBeforeDO.getGmtUpdate() );
        extractDataBefore.setUpdatedBy( extractDataBeforeDO.getUpdatedBy() );
        extractDataBefore.setData( extractDataBeforeDO.getData() );
        if ( extractDataBeforeDO.getExtractId() != null ) {
            extractDataBefore.setExtractId( Integer.parseInt( extractDataBeforeDO.getExtractId() ) );
        }

        return extractDataBefore;
    }
}
