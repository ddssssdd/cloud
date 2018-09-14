package com.sfu.cloud.resttemplatetest;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class MyInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        System.out.println("==================================自定义拦截器开始==================================");
        System.out.println("   原来的URI"+httpRequest.getURI());
        MyHttpRequest myHttpRequest = new MyHttpRequest(httpRequest);
        System.out.println("   修改的URI"+myHttpRequest.getURI());
        return clientHttpRequestExecution.execute(myHttpRequest,bytes);
    }
}
