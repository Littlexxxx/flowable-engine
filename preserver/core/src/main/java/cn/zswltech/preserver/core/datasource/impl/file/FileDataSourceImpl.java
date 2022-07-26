package cn.zswltech.preserver.core.datasource.impl.file;

import cn.zswl.oss.core.OssClient;
import cn.zswl.oss.core.minio.MinioOssProperties;
import cn.zswltech.preserver.core.datasource.DataSource;
import cn.zswltech.preserver.core.datasource.constant.ColumnInfo;
import cn.zswltech.preserver.data.source.domain.DataSourceModel;
import cn.zswltech.preserver.core.datasource.utils.ExcelUtils;
import com.alibaba.fastjson.JSON;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author: xinhao.hu
 * @date: 2022/5/17 4:13 下午
 * @description:
 **/
@Component
public class FileDataSourceImpl implements DataSource {

    @Autowired
    private OssClient ossClient;

    @Autowired
    private MinioOssProperties properties;

    @Override
    public Map<String, ColumnInfo> parseMetaData(DataSourceModel dataSourceModel) {
        FileDataSourceConfig config = parseConfig(dataSourceModel);
        ByteArrayOutputStream os = getTargetFileStream(config);
        ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
        Workbook workbook = ExcelUtils.getWorkBook(is,config.getAddress());
        List<String> metaData = ExcelUtils.getTitle(workbook,config.getSheetId());
        Map<String, ColumnInfo> res = metaData.stream().collect(Collectors.toMap(Function.identity(), t -> new ColumnInfo(t, null, null)));
        return res;
    }

    @Override
    public Boolean testConnection(DataSourceModel dataSourceModel) {
        FileDataSourceConfig fileDataSourceConfig = parseConfig(dataSourceModel);
        return ossClient.doesObjectExist(fileDataSourceConfig.getBucket(),fileDataSourceConfig.getAddress());
    }

    @Override
    public String getName() {
        return "FILE";
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
