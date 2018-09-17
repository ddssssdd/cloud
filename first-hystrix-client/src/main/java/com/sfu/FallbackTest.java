package com.sfu;


import com.netflix.config.ConfigurationManager;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class FallbackTest {

    public static void main(String[] args){
        ConfigurationManager.getConfigInstance().setProperty("hystrix.command.default.circuitBreaker.forceOpen","true");
        FallbackCommand command = new FallbackCommand();
        command.execute();

        ConfigurationManager.getConfigInstance().setProperty("hystrix.command.default.circuitBreaker.forceOpen","false");
        FallbackCommand command1 = new FallbackCommand();
        command1.execute();

    }

    static class FallbackCommand extends HystrixCommand<String>{

        public FallbackCommand(){
            super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        }

        protected String run() throws Exception {
            System.out.println("命令执行");
            return "";
        }

        @Override
        protected String getFallback() {
            System.out.println("执行回退方法");
            return "fallback";
        }
    }
}
