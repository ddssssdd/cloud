package com.sfu.cloud;

import com.netflix.client.ClientFactory;
import com.netflix.client.http.HttpRequest;
import com.netflix.client.http.HttpResponse;
import com.netflix.config.ConfigurationManager;
import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.niws.client.http.RestClient;


public class TestRestClient {
    public static void main(String[] args) throws Exception{
        // 设置请求的服务器
        ConfigurationManager.getConfigInstance().setProperty(
                "my-client.ribbon.listOfServers",
                "localhost:8080,localhost:8081");
    }
}
