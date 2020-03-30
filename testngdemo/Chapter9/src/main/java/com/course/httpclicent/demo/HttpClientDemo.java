package com.course.httpclicent.demo;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class HttpClientDemo {
    @Test
    public void test() throws IOException {
        String result;
        HttpGet get = new HttpGet("https://www.baidu.com");
        //用来执行get方法的
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //执行
        CloseableHttpResponse response = httpClient.execute(get);
        //获取结果
        result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);

    }
}
