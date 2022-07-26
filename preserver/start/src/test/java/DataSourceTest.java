import cn.zswl.oss.core.OssClient;
import cn.zswltech.preserver.core.datasource.DataSource;
import cn.zswltech.preserver.core.datasource.constant.ColumnInfo;
import cn.zswltech.preserver.data.source.domain.DataSourceModel;
import cn.zswltech.preserver.start.PreserverApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author: xinhao.hu
 * @date: 2022/5/17 11:24 上午
 * @description:
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PreserverApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DataSourceTest {

    @Resource(name = "mysqlDataSourceImpl")
    private DataSource mysqlDataSource;

    @Resource(name = "fileDataSourceImpl")
    private DataSource fileDataSource;

    @Autowired
    private OssClient ossClient;

    @Test
    public void testMysql(){
        String dataConfig = "{\n" +
                "\t\"address\":\"127.0.0.1\",\n" +
                "\t\"port\":3306,\n" +
                "\t\"userName\":\"root\",\n" +
                "\t\"password\":123456\n" +
                "}";
        DataSourceModel dataSourceModel = new DataSourceModel();
        dataSourceModel.setConfig(dataConfig);
        System.out.println(mysqlDataSource.testConnection(dataSourceModel));
        Map<String, ColumnInfo> map = mysqlDataSource.parseMetaData(dataSourceModel);
        System.out.println(map);
    }


    @Test
    public void testOss(){
        String dataConfig = "{\n" +
                "    \"address\": \"test/testExcel.xlsx\"\n" +
                "}";
        DataSourceModel dataSourceModel = new DataSourceModel();
        dataSourceModel.setConfig(dataConfig);
        Map<String, ColumnInfo> metaData = fileDataSource.parseMetaData(dataSourceModel);
        System.out.println(metaData);

    }
}
