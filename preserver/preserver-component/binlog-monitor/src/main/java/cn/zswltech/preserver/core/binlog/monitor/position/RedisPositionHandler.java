package cn.zswltech.preserver.core.binlog.monitor.position;

import cn.zswltech.preserver.core.binlog.monitor.config.SyncConfig;
import cn.zswltech.preserver.core.binlog.monitor.exception.BinlogMonitorRuntimeException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisPositionHandler implements IPositionHandler {

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public BinlogPositionEntity getPosition(SyncConfig syncConfig) throws BinlogMonitorRuntimeException {
        try {
            String position = (String) redisTemplate.opsForValue().get(getPositionKey(syncConfig));
            if (position != null) {
                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.readValue(position, BinlogPositionEntity.class);
            }
        } catch (JsonProcessingException e) {
            return null;
        }
        return null;
    }

    @Override
    public void savePosition(SyncConfig syncConfig, BinlogPositionEntity binlogPositionEntity) throws BinlogMonitorRuntimeException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            redisTemplate.opsForValue().set(getPositionKey(syncConfig), objectMapper.writeValueAsString(binlogPositionEntity));
        } catch (JsonProcessingException e) {
            throw new BinlogMonitorRuntimeException("save position error!" + binlogPositionEntity.toString(), e);
        }
    }

    private String getPositionKey(SyncConfig syncConfig){
        return syncConfig.getHost() + ":" + syncConfig.getPort();
    }
}
