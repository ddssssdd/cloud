package com.sfu;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import rx.Observable;
import rx.Observer;

public class RunTest {
    public static void  main(String[] args) throws InterruptedException {
        RunCommand cl =new RunCommand("使用execute方法执行命令");
        cl.execute();

        RunCommand c2 = new RunCommand("使用queue方式执行命令");
        c2.queue();

        RunCommand c3 = new RunCommand("使用observe方法执行命令");
        c3.observe();

        RunCommand c4 = new RunCommand("使用toObservable方法执行命令");
        Observable<String> ob = c4.toObservable();
        ob.subscribe(new Observer<String>(){

            public void onCompleted() {
                System.out.println(" 命令执行完成");
            }

            public void onError(Throwable throwable) {

            }

            public void onNext(String s) {
                System.out.println(" 命令执行结果："+s);
            }
        });
        Thread.sleep(100);


    }

    static class RunCommand extends HystrixCommand<String>{
        String msg;
        public RunCommand(String msg){
            super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
            this.msg = msg;
        }

        @Override
        protected String run() throws Exception {
            System.out.println(msg);
            return "success";
        }
    }

}
