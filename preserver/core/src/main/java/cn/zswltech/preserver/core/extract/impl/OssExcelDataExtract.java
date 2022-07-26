package cn.zswltech.preserver.core.extract.impl;

import cn.zswl.oss.core.OssClient;
import cn.zswl.oss.core.minio.MinioOssProperties;
import cn.zswltech.preserver.core.datasource.impl.file.FileDataSourceConfig;
import cn.zswltech.preserver.core.datasource.utils.ExcelUtils;
import cn.zswltech.preserver.core.extract.DataExtract;
import cn.zswltech.preserver.core.extract.constant.ExtractTypeEnum;
import cn.zswltech.preserver.core.extract.context.ExtractContext;
import cn.zswltech.preserver.data.source.domain.DataSourceModel;
import com.alibaba.fastjson.JSON;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.*;

/**
 * @author: xinhao.hu
 * @date: 2022/5/24 19:33
 * @description:
 **/
@Service
public class OssExcelDataExtract implements DataExtract {

    @Autowired
    private OssClient ossClient;

    @Autowired
    private MinioOssProperties properties;

    @Override
    public ExtractTypeEnum getType() {
        return ExtractTypeEnum.FILE;
    }

    @Override
    public List<Map<String, Object>> entireExtract(ExtractContext extractContext) {
        FileDataSourceConfig config = parseConfig(extractContext.getDataSourceModel());
        ByteArrayOutputStream os = getTargetFileStream(config);
        ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
        Workbook workbook = ExcelUtils.getWorkBook(is,config.getAddress());
        List<Map<String, Object>> data = ExcelUtils.getDataWithTitle(config.getSheetId(),workbook);
        return data;
    }

    /**
     * 文件不可增量拉取
     * @param extractContext
     * @return
     */
    @Override
    public List<Map<String, Object>> incrementExtract(ExtractContext extractContext) {
        throw new RuntimeException("文件不可增量拉取");
    }

    private FileDataSourceConfig parseConfig(DataSourceModel dataSourceModel){
        FileDataSourceConfig config = JSON.parseObject(dataSourceModel.getConfig(),FileDataSourceConfig.class);
        if(Objects.isNull(config.getBucket())){
            config.setBucket(properties.getBucketName());
        }
        return config;
    }

    private ByteArrayOutputStream getTargetFileStream(FileDataSourceConfig dataSourceConfig){
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ossClient.downLoad(os,dataSourceConfig.getAddress());
        return os;
    }
}
