package com.sfu.cloud.cloudinvoker;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.sfu.cloud.cloudinvoker.rule.MyPing;
import com.sfu.cloud.cloudinvoker.rule.MyRule;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


public class MyConfig {
    @Bean
    public IRule getRule(){
        return new MyRule();
    }

    @Bean
    public IPing getPing(){
        return new MyPing();
    }
}
