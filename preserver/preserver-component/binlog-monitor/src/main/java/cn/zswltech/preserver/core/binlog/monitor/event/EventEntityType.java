package cn.zswltech.preserver.core.binlog.monitor.event;

public enum EventEntityType {
    UPDATE("update"),
    INSERT("insert"),
    DELETE("delete");

    String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    EventEntityType(String desc) {
        this.desc = desc;
    }
}
