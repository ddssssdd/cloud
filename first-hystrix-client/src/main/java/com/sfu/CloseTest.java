package com.sfu;

import com.netflix.config.ConfigurationManager;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandMetrics;
import com.netflix.hystrix.HystrixCommandProperties;


public class CloseTest {
    public static void main(String[] args) throws InterruptedException {
        ConfigurationManager.getConfigInstance().setProperty("hystrix.command.default.metrics.rollingStats.timeInMilliseconds", "10000");

        ConfigurationManager.getConfigInstance().setProperty("hystrix.command.default.circuitBreaker.requestVolumeThreshold", 10);

        ConfigurationManager.getConfigInstance().setProperty("hystrix.command.default.circuitBreaker.errorThresholdPercentage", 50);

        ConfigurationManager.getConfigInstance().setProperty("hystrix.command.default.circuitBreaker.sleepWindowInMilliseconds", 3000);


        boolean isTimeout = true;

        for(int i=0;i<10;i++){

            MyCloseCommand command = new MyCloseCommand(isTimeout);
            command.execute();

            HystrixCommandMetrics.HealthCounts hc = command.getMetrics().getHealthCounts();
            System.out.println("断路器状态："+command.isCircuitBreakerOpen()+", 请求总数："+hc.getTotalRequests());

            if (command.isCircuitBreakerOpen()){
                isTimeout = false;
                System.out.println("断路器被打开，执行第"+(i+1)+"个命令,等待休眠期结束");
                Thread.sleep(4000);

            }
        }


    }

    static class MyCloseCommand extends HystrixCommand<String> {
        private boolean isTimeout;

        public MyCloseCommand(boolean isTimeout) {

            super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
                    .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                            .withExecutionTimeoutInMilliseconds(500)));

            this.isTimeout = isTimeout;
        }

        protected String run() throws Exception {
            System.out.println("命令执行");
            if (isTimeout){
                Thread.sleep(800);
            }else{
                Thread.sleep(200);
            }

            return "";
        }

        @Override
        protected String getFallback() {
            System.out.println("执行回退方法");
            return "fallback";
        }
    }
}
