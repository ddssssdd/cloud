package com.sfu;

import com.netflix.config.ConfigurationManager;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class ThreadIso {



    public static void main(String[] args) throws InterruptedException {
        ConfigurationManager.getConfigInstance().setProperty("hystrix.threadpool.default.coreSize",3);
        for(int i=0;i<6;i++){
            MyCommand command = new MyCommand(i);
            command.queue();
        }
        Thread.sleep(5000);
    }

    static class MyCommand extends HystrixCommand<String>{

        private Integer index;
        public MyCommand(Integer index){

            super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup")));
            this.index = index;
        }
        protected String run() throws Exception {
            Thread.sleep(500);
            System.out.println("执行方法，当前索引: "+this.index);
            return "";
        }

        @Override
        protected String getFallback() {

            System.out.println("执行fallback，当前索引: "+this.index);
            return "";
        }
    }
}
