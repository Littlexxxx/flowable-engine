package cn.zswltech.preserver.core.datasource.impl.file;

import lombok.Data;

/**
 * @author: xinhao.hu
 * @date: 2022/5/17 4:13 下午
 * @description:
 **/
@Data
public class FileDataSourceConfig {
    private String address;
    private String bucket;
    private String fileType;
    // 默认取sheet0的数据
    private Integer sheetId = 0;
}
