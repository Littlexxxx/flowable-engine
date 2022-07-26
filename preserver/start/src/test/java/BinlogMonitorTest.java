//import cn.zswltech.preserver.core.binlog.monitor.BinlogClientStarter;
//import cn.zswltech.preserver.core.binlog.monitor.config.SyncConfig;
//import cn.zswltech.preserver.core.binlog.monitor.factory.BinaryLogClientFactory;
//import cn.zswltech.preserver.start.PreserverApplication;
//import com.github.shyiko.mysql.binlog.BinaryLogClient;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.io.IOException;
//import java.util.Collections;
//
///**
// * @author: xinhao.hu
// * @date: 2022/5/23 2:26 下午
// * @description:
// **/
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = PreserverApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class BinlogMonitorTest {
//
//    @Autowired
//    private BinlogClientStarter binlogClientStarter;
//
//    @Autowired
//    private BinaryLogClientFactory binaryLogClientFactory;
//
//    @Autowired
//    private MysqlBinlogEventHandler mysqlBinlogEventHandler;
//
//
//    @Test
//    public void testBinlogClient() throws InterruptedException {
//        SyncConfig syncConfig = new SyncConfig();
//        syncConfig.setHost("127.0.0.1");
//        syncConfig.setPort(3306);
//        syncConfig.setUserName("root");
//        syncConfig.setPassword("123456");
//        syncConfig.setEventHandlerList(Collections.singletonList(mysqlBinlogEventHandler));
//
//        BinaryLogClient client = binaryLogClientFactory.getClient(syncConfig);
//        Thread thread = new Thread(() -> {
//            try {
//                client.setHeartbeatInterval(10 * 1000L);
//                client.connect();
//            } catch (IOException e) {
//            }
//        },"test");
//        thread.start();
//
//        thread.join();
//    }
//}
