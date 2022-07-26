package com.hxh.service;

import cn.zswltech.flow.core.api.FlowModelApiService;
import cn.zswltech.flow.core.api.FlowProcessApiService;
import cn.zswltech.flow.core.domain.req.SaveModelReq;
import cn.zswltech.flow.core.domain.req.StartProcessReq;
import cn.zswltech.flow.core.enums.ApprovalMethodEnum;
import cn.zswltech.flow.core.enums.ParallelApprovalMethedEnum;
import cn.zswltech.flow.core.enums.UserDefineTypeEnum;
import cn.zswltech.flow.core.model.ext.GlobalExt;
import cn.zswltech.flow.core.model.ext.UserTaskExt;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.flowable.bpmn.converter.BpmnXMLConverter;
import org.flowable.bpmn.model.BpmnModel;
import org.flowable.editor.language.json.converter.BpmnJsonConverter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author: xinhao.hu
 * @date: 2022/7/11 5:59 下午
 * @description:
 **/
@Slf4j
@Service
public class TestService {

    @Resource
    private BpmnXMLConverter bpmnXMLConverter;
    @Resource
    private BpmnJsonConverter bpmnJsonConverter;
    @Resource
    private FlowModelApiService flowModelApiService;
    @Resource
    private FlowProcessApiService flowProcessApiService;

    private static final String MODEL_KEY = "TestDemo";

    @PostConstruct
    public String createModel() throws Exception{
        // 获取bpmn2.0规范的xml
        InputStream bpmnStream = new ClassPathResource("bpmn/demo测试.bpmn20.xml").getInputStream();
        XMLInputFactory xif = XMLInputFactory.newInstance();
        InputStreamReader in = new InputStreamReader(bpmnStream, "UTF-8");
        XMLStreamReader xtr = xif.createXMLStreamReader(in);
        // 然后转为bpmnModel
        BpmnModel bpmnModel = bpmnXMLConverter.convertToBpmnModel(xtr);
        // bpmnModel转json
        ObjectNode editorJsonNode = bpmnJsonConverter.convertToJson(bpmnModel);
        SaveModelReq req = new SaveModelReq();
        GlobalExt globalExt = new GlobalExt();
        globalExt.setUserTaskExtMap(new HashMap<String, UserTaskExt>());
        UserTaskExt userTaskExt1 = UserTaskExt.builder()
                .activityId("userTask_111")
                .approvalMethod(ApprovalMethodEnum.SEQUENTIAL.getType())
                .approverType(UserDefineTypeEnum.START_USER.getType())
                .parallelApprovalMethed(ParallelApprovalMethedEnum.ONE.getType())
                .skipFirst(true)
                .build();
        globalExt.getUserTaskExtMap().put(userTaskExt1.getActivityId(), userTaskExt1);
        UserTaskExt userTaskExt2 = UserTaskExt.builder()
                .activityId("userTask_222")
                .approvalMethod(ApprovalMethodEnum.SEQUENTIAL.getType())
                .approverType(UserDefineTypeEnum.CUSTOM.getType())
                .parallelApprovalMethed(ParallelApprovalMethedEnum.ONE.getType())
                .build();
        globalExt.getUserTaskExtMap().put(userTaskExt2.getActivityId(), userTaskExt2);
        req.setEditorJson(editorJsonNode.toString());
        req.setGlobalExt(globalExt);
        String modelId = flowModelApiService.save(req);
        log.info("流程模型id:{}", modelId);
        //发布
        String deployId = flowModelApiService.deploy(modelId);
        log.info("发布id:{}", deployId);
        return deployId;
    }

    public String createProcess(){
        StartProcessReq req = new StartProcessReq();
        req.setModelKey(MODEL_KEY);
        req.setVariables(new HashMap<String, Object>(){{put("amount", 9000);}});
        req.setStartUserId("1");
        req.setBusinessKey("1");
        String processInstanceId = flowProcessApiService.start(req);
        return processInstanceId;
    }

    public void getProcessStatus(){

    }

}
