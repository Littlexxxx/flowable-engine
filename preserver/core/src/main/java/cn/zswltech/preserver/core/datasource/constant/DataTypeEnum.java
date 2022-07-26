package cn.zswltech.preserver.core.datasource.constant;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public enum DataTypeEnum {


    /**
     * 数据类型
     */
    STRING(1, "string", "字符型"),
    INT(2, "int", "整型"),
    DOUBLE(3, "double", "小数型"),
    DATE(4, "date", "日期型"),
    ENUMS(5, "enum", "枚举"),
    BOOLEAN(6, "boolean", "布尔");

    private static final Logger LOGGER = LoggerFactory.getLogger(DataTypeEnum.class);

    private final int type;

    private final String name;

    private final String desc;

    DataTypeEnum(int type, String name, String desc) {
        this.type = type;
        this.name = name;
        this.desc = desc;
    }

    public static String nameByType(Integer type) {
        DataTypeEnum typeEnum = getByType(type);
        return typeEnum != null ? typeEnum.name : ("未定义的类型" + type);
    }

    public static String descByType(Integer type) {
        DataTypeEnum typeEnum = getByType(type);
        return typeEnum != null ? typeEnum.desc : ("未定义的类型" + type);
    }

    public static DataTypeEnum getByType(Integer type) {
        if (type == null) {
            return null;
        }
        for (DataTypeEnum typeEnum : DataTypeEnum.values()) {
            if (typeEnum.type == type.intValue()) {
                return typeEnum;
            }
        }
        return null;
    }

    public static DataTypeEnum getByName(String name){
        if ("DATETIME".equals(name)){
            return DataTypeEnum.DATE;
        }
        return DataTypeEnum.valueOf(name);
    }

    public Object randomValue() {
        Object result = null;
        switch (this) {
            case STRING:
                result = RandomStringUtils.randomAlphanumeric(5);
                break;
            case INT:
                result = RandomUtils.nextInt(10, 1000);
                break;
            case DATE:
                result = new Date();
                break;
            case ENUMS:
                result = 1;
                break;
            case DOUBLE:
                result = RandomUtils.nextDouble(10d, 1000d);
                break;
            case BOOLEAN:
                result = (System.currentTimeMillis() % 2 == 1);
                break;
        }
        return result;
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public int compare(Object left, Object right, DataTypeEnum type){
        int result = -2;
        switch (this) {
            case STRING:
            case BOOLEAN:
            case ENUMS:
                result = left.equals(right)?0:-1;
                break;
            case INT:
                try{
                    result = Integer.compare(Integer.parseInt(String.valueOf(left))
                            ,Integer.parseInt(String.valueOf(right)));
                }catch (Exception exception){
                    LOGGER.error("比较失败",exception);
                }
                break;
            case DOUBLE:
                try{
                    result = Double.compare(Double.parseDouble(String.valueOf(left))
                            ,Double.parseDouble(String.valueOf(right)));
                }catch (Exception exception){
                    LOGGER.error("比较失败",exception);
                }
                break;
            case DATE:
                try{
                    Date leftDate = DateUtils.parseDate((String) left);
                    Date rightDate = DateUtils.parseDate((String) right);
                    result = leftDate.compareTo(rightDate);
                }catch (Exception exception){
                    LOGGER.error("比较失败",exception);
                }
                break;
            default:
                return -2;
        }
        return result;
    }

    public Object parseValueByType(Object value){
        switch (this) {
            case INT:
                try{
                    return Integer.valueOf(String.valueOf(value));
                }catch (Exception exception){
                    LOGGER.error("转换失败",exception);
                }
                break;
            case DOUBLE:
                try{
                    return Double.valueOf(String.valueOf(value));
                }catch (Exception exception){
                    LOGGER.error("转换失败",exception);
                }
                break;
            case DATE:
                try{
                    return DateUtils.parseDate(String.valueOf(value));
                }catch (Exception exception){
                    LOGGER.error("转换失败",exception);
                }
                break;
            default:
                return value;
        }
        return value;
    }
}