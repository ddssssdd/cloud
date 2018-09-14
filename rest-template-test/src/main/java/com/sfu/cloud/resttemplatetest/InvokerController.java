package com.sfu.cloud.resttemplatetest;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Configuration
public class InvokerController {
    @Bean
    @MyLoadBalanced
    public RestTemplate getMyRestTemplate(){
        return new RestTemplate();
    }


    @RequestMapping("/router")
    public String router(){
        RestTemplate restTemplate = getMyRestTemplate();
        String json = restTemplate.getForObject("http://my-server/hello",String.class);
        return json;
    }


    @RequestMapping("/hello")
    public String hello(){
        return "hello, world";
    }
}
