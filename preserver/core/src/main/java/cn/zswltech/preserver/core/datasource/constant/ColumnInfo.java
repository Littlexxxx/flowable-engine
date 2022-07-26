package cn.zswltech.preserver.core.datasource.constant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: xinhao.hu
 * @date: 2022/5/12 3:38 下午
 * @description:
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ColumnInfo {
    private String name;
    private String type;
    private String comment;
}
