import cn.zswltech.preserver.core.rule.context.RuleExecuteContext;
import cn.zswltech.preserver.core.rule.eval.RuleExecuteEngine;
import cn.zswltech.preserver.core.rule.rule.Rule;
import cn.zswltech.preserver.core.rule.parser.RuleParser;
import cn.zswltech.preserver.core.rule.rule.detail.DetailCallable;
import cn.zswltech.preserver.start.PreserverApplication;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

/**
 * @author: xinhao.hu
 * @date: 2022/5/16 2:00 下午
 * @description:
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PreserverApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RuleTest {
    String json = "{\n" +
            "    \"ruleDetails\": [\n" +
            "        {\n" +
            "            \"type\": \"RuleGroup\",\n" +
            "            \"detail\": {\n" +
            "                \"type\": \"and\",\n" +
            "                \"rules\": [\n" +
            "                    {\n" +
            "                        \"op\": \"gt\",\n" +
            "                        \"leftVar\": {\n" +
            "                            \"type\": \"field\",\n" +
            "                            \"name\": \"ss\",\n" +
            "                            \"dataType\": \"int\"\n" +
            "                        },\n" +
            "                        \"rightVar\": {\n" +
            "                            \"type\": \"const\",\n" +
            "                            \"value\": \"1324\",\n" +
            "                            \"dataType\": \"int\"\n" +
            "                        }\n" +
            "                    }\n" +
            "                ]\n" +
            "            }\n" +
            "        },\n" +
            "        {\n" +
            "            \"type\": \"SimpleRule\",\n" +
            "            \"detail\": {\n" +
            "                \"op\": \"lt\",\n" +
            "                \"leftVar\": {\n" +
            "                    \"type\": \"field\",\n" +
            "                    \"name\": \"sw\",\n" +
            "                    \"dataType\": \"int\"\n" +
            "                },\n" +
            "                \"rightVar\": {\n" +
            "                    \"type\": \"const\",\n" +
            "                    \"value\": \"1666\",\n" +
            "                    \"dataType\": \"int\"\n" +
            "                }\n" +
            "            }\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    @Autowired
    private RuleParser ruleParser;

    @Autowired
    private RuleExecuteEngine ruleExecuteEngine;

    @Test
    public void testRule(){
        Rule rule = ruleParser.ruleParser(json);
        ruleExecuteEngine.execute(rule, new RuleExecuteContext() {

            @Override
            public Object getField(String name) {
                if(name.equals("ss")){
                    return 1003;
                }else return 1444;
            }

            @Override
            public void setField(String name, Object value) {

            }

            @Override
            public Map<String, Object> getOriginDatas() {
                return null;
            }

            @Override
            public void saveDetail(DetailCallable detailCallable, String ruleName) {

            }
        });

    }
}
