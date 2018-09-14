package com.sfu.cloud.resttemplatetest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;

import java.net.URI;


public class MyHttpRequest implements HttpRequest {
    private static final Logger LOGGER=LoggerFactory.getLogger(MyHttpRequest.class);
    private HttpRequest httpRequest;
    public MyHttpRequest(HttpRequest httpRequest){
        this.httpRequest = httpRequest;
    }

    @Override
    public HttpMethod getMethod() {
        return this.httpRequest.getMethod();
    }

    @Override
    public URI getURI() {
        try{
            String oldUri = this.httpRequest.getURI().toString();
            URI newUri = new URI("http://localhost:8080/hello");
            return newUri;

        }catch (Exception e){
            LOGGER.error("create new URI error");
        }
        return this.httpRequest.getURI();
    }

    @Override
    public HttpHeaders getHeaders() {
        return this.httpRequest.getHeaders();
    }
}
