package com.sfu;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HelloCommand extends HystrixCommand<String> {
    private String url;
    CloseableHttpClient httpClient;

    public HelloCommand(String url){
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));

        /*super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
        .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
        .withExecutionTimeoutInMilliseconds(11000)));
        */

        this.httpClient = HttpClients.createDefault();
        this.url = url;
    }
    protected String run() throws Exception {
        try{
            HttpGet httpGet = new HttpGet(url);
            HttpResponse response =httpClient.execute(httpGet);
            return EntityUtils.toString(response.getEntity());
        }catch (Exception ex){
            System.out.println(ex);
        }
        return "";
    }

    protected String getFallback(){
        System.out.println("执行HelloCommand的退回方法");
        return "error";
    }
}
