package cn.zswltech.preserver.core.binlog.monitor.position;

import lombok.Data;

@Data
public class BinlogPositionEntity {
    String binlogName;
    Long position;
    Long serverId;

    @Override
    public String toString() {
        return "BinlogPositionEntity{" +
                "binlogName='" + binlogName + '\'' +
                ", position=" + position +
                ", serverId=" + serverId +
                '}';
    }
}
