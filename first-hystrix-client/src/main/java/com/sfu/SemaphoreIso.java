package com.sfu;

import com.netflix.config.ConfigurationManager;
import com.netflix.hystrix.HystrixCommandProperties;

public class SemaphoreIso {
    public static void main(String[] args) throws Exception{
        ConfigurationManager.getConfigInstance().setProperty("hystrix.command.default.execution.isolation.strategy",HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE);
        ConfigurationManager.getConfigInstance().setProperty("hystrix.command.default.execution.isolation.semaphore.maxConcurrentRequests",2);
        ConfigurationManager.getConfigInstance().setProperty("hystrix.command.default.fallback.isolation.semaphore.maxConcurrentRequests",20);
        for(int i=0;i<6;i++){
            final int index = i;
            Thread t = new Thread(){
                public void run(){
                    ThreadIso.MyCommand c = new ThreadIso.MyCommand(index);
                    c.execute();
                }
            };
            t.start();
        }
        Thread.sleep(5000);
    }
}
