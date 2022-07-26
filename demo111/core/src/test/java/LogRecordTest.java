import cn.hxh.demo111.AppMain;
import cn.hxh.demo111.core.adapter.application.logrecord.LogTestService;
import cn.zswltech.lib.futurelog.core.save.LogRecordSave;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author: xinhao.hu
 * @date: 2022/4/11 9:55 上午
 * @description:
 **/
@SpringBootTest(classes = AppMain.class)
@RunWith(SpringRunner.class)
public class LogRecordTest {
    @Resource
    private LogTestService logTestService;

    @Test
    public void testFail(){
        String name = "122";
        String str = "2323";
        logTestService.testFail(name,str);
    }


    @Test
    public void testSuccess(){
        String name = "122";
        String str = "2323";
        logTestService.testSuccess(name,str);
    }

    @Test
    public void testCondition(){
        String name = "122";
        String str = "2323";
        logTestService.testCondition(name,str);
    }

    @Test
    public void testSpel(){
        String name = "122";
        String str = "2323";
        logTestService.testSpel(name,str);
    }

    @Test
    public void testFunction(){
        String name = "122";
        String str = "2323";
        LogRecordSave logRecordSave = new LogRecordSave();
        logRecordSave.setContent("ssfsfsf");
        logRecordSave.setOperator("sdsdsd");
        logTestService.testFunction(name,logRecordSave);
    }

}
