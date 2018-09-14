package com.sfu.cloud.resttemplatetest;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
public class MyAutoConfiguration {

    @Autowired(required = false)
    @MyLoadBalanced
    private List<RestTemplate> myTemplates = Collections.emptyList();

    @Bean
    public SmartInitializingSingleton myLoadBalancedRestTemplateInitializer(){
        System.out.println("=================这个Bean将在容器初始化的时候创建=======================");
        return new SmartInitializingSingleton() {
            @Override
            public void afterSingletonsInstantiated() {
                for(RestTemplate tpl :myTemplates){
                    MyInterceptor mi = new MyInterceptor();
                    List list = new ArrayList(tpl.getInterceptors());
                    list.add(mi);
                    tpl.setInterceptors(list);
                }
            }
        };

    }
}
