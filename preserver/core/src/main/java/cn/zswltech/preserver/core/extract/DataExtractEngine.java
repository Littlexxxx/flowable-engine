package cn.zswltech.preserver.core.extract;

import cn.zswltech.preserver.core.extract.action.ExtractActionCall;
import cn.zswltech.preserver.core.extract.constant.ExtractSelectConstant;
import cn.zswltech.preserver.core.extract.context.ExtractContext;
import cn.zswltech.preserver.core.extract.context.ExtractResponse;
import cn.zswltech.preserver.core.extract.factory.DataExtractFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author: xinhao.hu
 * @date: 2022/5/25 4:23 下午
 * @description:
 * 数据拉取引擎
 * 调用拉取实现，获取拉取数据并调用action
 **/
@Component
public class DataExtractEngine {

    @Autowired
    private DataExtractFactory dataExtractFactory;

    public void extract(ExtractContext extractContext, ExtractResponse extractResponse, ExtractActionCall extractActionCall){
        String extractSelect = extractContext.getExtractSelect();
        String extractType = extractContext.getExtractType();
        DataExtract dataExtract = dataExtractFactory.getDataExtract(extractSelect);
        List<Map<String,Object>> extractDatas;
        switch(extractType){
            case ExtractSelectConstant.ENTIRE:
                extractDatas = dataExtract.entireExtract(extractContext);
                break;
            case ExtractSelectConstant.INCREMENT:
                extractDatas = dataExtract.incrementExtract(extractContext);
                break;
            default:
                throw new RuntimeException("do not have this extract select");
        }

        extractContext.setExtractDatas(extractDatas);
        extractResponse.setExtractDatas(extractDatas);
        extractActionCall.call(extractContext,extractResponse);
    }

}
