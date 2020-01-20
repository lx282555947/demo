package com.lixin.fundamental.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import okhttp3.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Created by yangyandong on 2019/3/19.
 */
public class OkHttpUtil {

    //使用JSON数据格式请求
    private static final MediaType JSON_TYPE = MediaType.parse("application/json;charset=utf-8");
    //文件请求格式
    private static final MediaType FILE_TYPE = MediaType.parse("application/octet-stream;charset=utf-8");
    //设置连接超时时间 单位:s 在OkHttpClient中设置单位
    private static final int CONNECT_TIMEOUT = 60;
    //设置读取超时时间 单位:s 在OkHttpClient中设置单位
    private static final int READ_TIMEOUT = 60;
    //设置写入超时时间 单位:s 在OkHttpClient中设置单位
    private static final int WRITE_TIMEOUT = 60;

    private static OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(CONNECT_TIMEOUT,TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT,TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT,TimeUnit.SECONDS)
            .build();

    /**
     * @param url         请求路径
     * @param jsonParam  请求参数
     * @return            响应结果
     * */
    public static String doRequestBodyPost(String url,String jsonParam){
        RequestBody requestBody =  RequestBody.create(OkHttpUtil.JSON_TYPE ,jsonParam);
        Request request = new Request.Builder().post(requestBody).url(url).build();
        //响应结果
        return execute(client,request);
    }
    /**
     * @param  url         请求路径
     * @param  formMap    请求参数
     * @param  headerMap  请求头
     * @return             响应结果
     * */
    public static String doFormBodyPost(String url, Map<String, String> formMap, Map<String, String> headerMap) {
        //请求头
        Headers.Builder hBuilder = new Headers.Builder();
        if (headerMap != null) {
            headerMap = headerMap.entrySet().stream().filter(entry -> entry.getValue() != null).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
            headerMap.forEach(hBuilder::add);
        }
        //请求体
        FormBody.Builder fBuilder = new FormBody.Builder();
        if (formMap != null) {
            formMap = formMap.entrySet().stream().filter(entry -> entry.getValue() != null).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
            formMap.forEach(fBuilder::add);
        }
        Request request = new Request.Builder()
                .headers(hBuilder.build())
                .post(fBuilder.build())
                .url(url)
                .build();
        //响应结果
        return execute(client,request);
    }
    /**
     * @param  url         请求路径
     * @param  formMap    请求参数
     * @param  headerMap  请求头
     * @return             响应结果
     * */
    public static String doRequestBodyPost(String url, Map<String,Object> formMap, Map<String, String> headerMap) {
        //请求头
        Headers.Builder hBuilder = new Headers.Builder();
        if (headerMap != null) {
            headerMap = headerMap.entrySet().stream().filter(entry -> entry.getValue() != null).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
            headerMap.forEach(hBuilder::add);
        }
        StringJoiner joiner = new StringJoiner("&");
        if(formMap != null){
            formMap = formMap.entrySet().stream().filter(entry -> entry.getValue() != null).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
            formMap.forEach((k,v) ->{
                joiner.add(k + "=" + v);
            });
        }
        //请求体
        RequestBody requestBody = RequestBody.create(OkHttpUtil.JSON_TYPE ,joiner.toString());

        Request request = new Request.Builder()
                .headers(hBuilder.build())
                .post(requestBody)
                .url(url)
                .build();
        //响应结果
        return execute(client,request);
    }
    /**
     * @param url           请求路径
     * @param headerMap     请求头
     * @return               响应结果
     * */
    public static String doGet(String url, Map<String, String> headerMap) {
        Headers.Builder hBuilder = new Headers.Builder();
        //请求头
        if (headerMap != null) {
            headerMap = headerMap.entrySet().stream().filter(entry -> entry.getValue() != null).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
            headerMap.forEach(hBuilder::add);
        }
        Request request = new Request.Builder()
                .headers(hBuilder.build())
                .url(url)
                .get()
                .build();
        //响应结果
        return execute(client,request);
    }

    private static String execute(OkHttpClient client, Request request){
        Response res = null;
        try {
            res = client.newCall(request).execute();
            if (res.isSuccessful()) {
                return res.body().string();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Optional.ofNullable(res).ifPresent(response -> response.close());
        }
        return null;
    }

    public static void main(String[] args) {

        String url = "http://127.0.0.1:8080/api/user/register1";
        Map<String,Object> map = new HashMap<>();
        map.put("name","xiaohua");
        map.put("age",23);
        map.put("test",null);
        System.out.println(OkHttpUtil.doRequestBodyPost(url,map,new HashMap<>()));

        String url1 = "http://127.0.0.1:8080/api/user/register";
        JSONObject json = new JSONObject();
        json.put("name","xiaoming");
        json.put("age","23");
        json.put("test",null);
        System.out.println(OkHttpUtil.doRequestBodyPost(url1, JSON.toJSONString(json)));
    }
}
