package cn.zswltech.preserver.core.datasource.utils;

import cn.zswltech.preserver.core.datasource.constant.ColumnInfo;
import cn.zswltech.preserver.core.datasource.constant.DataTypeEnum;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class ColumnInfoUtil {

    /**
     * 是否是数字类型的ColumnInfo
     * @param columnInfo
     * @return
     */
    public static boolean isNumberColumnInfo(ColumnInfo columnInfo) {
        return DataTypeEnum.DOUBLE.name().equals(columnInfo.getType())
                || DataTypeEnum.INT.name().equals(columnInfo.getType());
    }

    /**
     * 从columnInfoList中查找列名等于fieldName的元素
     * @param fieldName
     * @param columnInfoList
     * @return
     */
    public static ColumnInfo find(String fieldName, List<ColumnInfo> columnInfoList) {
        return columnInfoList
                .stream()
                .filter(item -> StringUtils.equals(fieldName, item.getName()))
                .findFirst()
                .orElse(null);
    }


    /**
     * 将数据类型转成标准数据类型(hive&mysql)
     * @param dataType 数据类型
     * @return DataTypeEnum
     */
    public static String fromDataType(String dataType) {
        switch (dataType.toLowerCase()) {
            case "int":
            case "tinyint":
            case "bigint":
            case "smallint":
            case "mediumint":
                return DataTypeEnum.INT.name();
            case "float":
            case "double":
            case "decimal":
            case "decimal(10,2)":
                return DataTypeEnum.DOUBLE.name();
            case "timestamp":
            case "date":
            case "time":
                return DataTypeEnum.DATE.name();
            default:
                return DataTypeEnum.STRING.name();
        }
    }

}