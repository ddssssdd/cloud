package com.sfu.cloud;

import feign.Feign;

public class HelloMain {
    public static void main(String[] args){
        HelloClient hello = Feign.builder().target(HelloClient.class,"http://localhost:8080/");
        System.out.println(hello.sayHello());
    }
}
