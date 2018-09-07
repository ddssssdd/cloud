package com.sfu.cloud.firstekserviceinvoker;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@Configuration
public class InvokerController {



    @Bean
    @LoadBalanced
    public RestTemplate getTemplate(){
        return new RestTemplate();
    }


    @RequestMapping("/router")
    public String router(){
        RestTemplate restTemplate = getTemplate();
        String json = restTemplate.getForObject("http://first-cloud-provider/person/100",String.class);
        return json;
    }
}
