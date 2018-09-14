package com.sfu.cloud;

import feign.RequestLine;

public interface HelloClient {

    @RequestLine("GET /hello")
    String sayHello();
}
