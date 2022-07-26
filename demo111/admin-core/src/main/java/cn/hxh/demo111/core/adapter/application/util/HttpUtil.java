package cn.hxh.demo111.core.adapter.application.util;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * @author: xinhao.hu
 * @date: 2022/2/13 6:01 下午
 * @description: 封装的HTTP请求,IOException要在上层处理
 * @throws: IOException
 **/
@Component
public class HttpUtil {
    private static CloseableHttpClient httpClient;

    private Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    private static final String CHARSET = "utf-8";

    private static final Integer TIMEOUT = 30000;

    static {
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(500);
        connectionManager.setDefaultMaxPerRoute(100);
        httpClient = HttpClients.custom()
                .setConnectionManager(connectionManager)
                .build();
    }

    public String get(String url) throws IOException {
        CloseableHttpResponse response = null;
        try {
            BufferedReader in = null;
            HttpGet httpGet = new HttpGet(url);
            initConfig(httpGet);
            response = httpClient.execute(httpGet);
            String result = toString(response);
            logger.info("[HttpUtil-get-response:]url:{},response:{}", url,result);
            return result;
        }finally {
            if (response != null) {
                response.close();
            }
        }
    }

    public String post(String url, Object input) throws IOException{
        CloseableHttpResponse response = null;
        try {
            HttpPost httpPost = new HttpPost(url);
            initConfig(httpPost);
            HttpEntity entity = parseEntity(input);
            httpPost.setEntity(entity);
            response = httpClient.execute(httpPost);
            String result = toString(response);
            logger.info("[HttpUtil-post-response:]url:{},input:{},result:{}", url, input.toString(), result);
            return result;
        }finally {
            if (null != response) {
                response.close();
            }
        }
    }



    private void initConfig(HttpGet httpGet){
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(TIMEOUT)
                .setConnectionRequestTimeout(TIMEOUT)
                .setSocketTimeout(TIMEOUT)
                .build();
        httpGet.setConfig(requestConfig);
        httpGet.addHeader("Content-type", "application/json; CHARSET=utf-8");
        httpGet.setHeader("Accept", "application/json");
    }

    private void initConfig(HttpPost httpPost){
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(TIMEOUT)
                .setConnectionRequestTimeout(TIMEOUT)
                .setSocketTimeout(TIMEOUT)
                .build();
        httpPost.setConfig(requestConfig);
        httpPost.addHeader("Content-type", "application/json; CHARSET=utf-8");
        httpPost.setHeader("Accept", "application/json");
    }

    /**
     * 其他格式再用JSON转
     * @param response
     * @return
     * @throws IOException
     */
    private String toString(CloseableHttpResponse response) throws IOException {
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity, CHARSET);
        // 关闭输入流
        EntityUtils.consume(entity);
        return result;
    }

    private HttpEntity parseEntity(Object input) {
        // json
        if(input instanceof String){
            return new StringEntity((String)input,CHARSET);
        }
        // 表单
        if(input instanceof Map){
            MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create().setCharset(Charset.forName(CHARSET));
            ((Map) input).forEach((key, value) -> {
                if(value instanceof String){
                    entityBuilder.addTextBody((String)key,(String)value);
                } else if(value instanceof File){
                    entityBuilder.addBinaryBody((String) key,(File)value);
                } else if(value instanceof InputStream){
                    entityBuilder.addBinaryBody((String)key,(InputStream)value);
                } else {
                }
            });
            return entityBuilder.build();
        }
        return null;
    }

    public static void main(String[] args) {
        String url = "http://127.0.0.1:8088/testFileAccept";
        HttpUtil util = new HttpUtil();
        Map inputMap = new HashMap();
        inputMap.put("id","202108");
        inputMap.put("file",new File("/Users/huxinhao/Downloads/2354.99.pdf"));
        try{
            String jsonString = "{\"month\":\"202109\"}";
            String result = util.post(url,inputMap);
            System.out.println(result);
        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
