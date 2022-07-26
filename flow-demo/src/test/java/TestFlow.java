import cn.zswltech.flow.core.api.FlowExecutionApiService;
import cn.zswltech.flow.core.api.FlowProcessApiService;
import cn.zswltech.flow.core.api.FlowTaskApiService;
import cn.zswltech.flow.core.api.FlowUserApiService;
import cn.zswltech.flow.core.domain.req.SetTaskApproverReq;
import cn.zswltech.flow.core.domain.req.StartProcessReq;
import cn.zswltech.flow.core.domain.req.execution.ExecutionTaskBaseReq;
import cn.zswltech.flow.core.domain.req.task.ProcessPageReq;
import cn.zswltech.flow.core.domain.resp.ProcessResp;
import cn.zswltech.flow.core.util.Page;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.hxh.AppMain;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @author: xinhao.hu
 * @date: 2022/7/11 5:34 下午
 * @description:
 **/
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppMain.class)
public class TestFlow {

    @Resource
    private FlowExecutionApiService flowExecutionApiService;

    @Resource
    private FlowProcessApiService flowProcessApiService;

    @Resource
    private FlowTaskApiService flowTaskApiService;

    @Resource
    private FlowUserApiService flowUserApiService;


    private static final String MODEL_KEY = "TestDemo";

    /**
     * submit 表示一次提交
     * 1、创建流程，设置创建人id和业务id
     */
    @Test
    public void submit(){
        // 创建流程
        StartProcessReq req = new StartProcessReq();
        req.setModelKey(MODEL_KEY);
        // 设置创建人id
        String startUesrId = "1";
        String businessKey = "1";
        String nextUserId = "2";
        req.setStartUserId(startUesrId);
        req.setBusinessKey(businessKey);
        String processInstanceId = flowProcessApiService.start(req);
        log.info(processInstanceId);
        // 将processInstanceId 绑定到业务数据中,例:
        // riskOrg.setProcessInstanceId(processInstanceId);
        // riskOrgMapper.save();

    }

    /**
     * 设置下个审批人
     */
    @Test
    public void setAuditor(){
        String businessKey = "1";
        String nextUserId = "2";
        String processInstanceId = "b3ddae8b-01c8-11ed-8ca1-ae307f116243";
        ProcessPageReq processPageReq = new ProcessPageReq();
        processPageReq.setBusinessKey(businessKey);
        processPageReq.setModelKey(MODEL_KEY);
        List<ProcessResp> processRespList = flowTaskApiService.queryProcess(processPageReq).getContents();
        ProcessResp processResp = processRespList.stream()
                .filter(t -> t.getProcessInstanceId().equals(processInstanceId))
                .findFirst().get();
        // 默认只有一个
        String curTaskActivityId = JSON.parseArray(processResp.getCurTaskActivityIds(),String.class).get(0);
        // 设置下个节点的审批人
        if(curTaskActivityId != null){
            SetTaskApproverReq setTaskApproverReq = new SetTaskApproverReq();
            setTaskApproverReq.setActivityId(curTaskActivityId);
            setTaskApproverReq.setApproverIdList(Lists.newArrayList(nextUserId));
            setTaskApproverReq.setProcessInstanceId(processInstanceId);
            flowUserApiService.setTaskApprover(setTaskApproverReq);
        }
        // 业务数据状态变更
    }

    /**
     * 根据当前
     */
    public void audit(){
        String businessKey = "1";
        String processInstanceId = "";
        String auditor = "2";
        // audit = 0 驳回，audit = 1 通过
        int audit = 1;
        String suggest = "通过";
        // 查询流程
        ProcessPageReq processPageReq = new ProcessPageReq();
        processPageReq.setBusinessKey(businessKey);
        processPageReq.setModelKey(MODEL_KEY);
        List<ProcessResp> processRespList = flowTaskApiService.queryProcess(processPageReq).getContents();
        ProcessResp processResp = processRespList.stream()
                .filter(t -> t.getProcessInstanceId().equals(processInstanceId))
                .findFirst().get();
        // 判断是否当前用户审批
        String taskId = JSON.parseArray(processResp.getCurTaskIds(),String.class).get(0);
        // 审批，通过
        if(audit == 1){
            ExecutionTaskBaseReq executionTaskBaseReq = new ExecutionTaskBaseReq();
            executionTaskBaseReq.setHandlerId(auditor);
            executionTaskBaseReq.setTaskId(taskId);
            executionTaskBaseReq.setMessage(suggest);
            flowExecutionApiService.pass(executionTaskBaseReq);
        }else{
            // 驳回，将当前节点跳转到第一个节点
        }

    }

    public void withdraw(){

    }




}