package com.hyy.Hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolProperties;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author hyy
 */
public class MyHystrixCommand extends HystrixCommand<String> {

    private final String name;
    public MyHystrixCommand(String name) {
        //super(HystrixCommandGroupKey.Factory.asKey("MyGroup"));
        // 信号量策略配置
//        super(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("MyGroup"))
//                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
//                        .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE
//                        )));
        // 线程隔离策略
        super(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("MyGroup"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD))
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(10)
                        .withMaxQueueSize(100).withMaximumSize(100)));
        this.name = name;
    }

    @Override
    protected String getFallback() {
        return "失败了 ";
    }

    @Override
    protected String run() throws Exception {
        return this.name + ":" + Thread.currentThread().getName();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        String result = new MyHystrixCommand("zhangsan").execute();
//        System.out.println(result);

        // 异步调用
        Future<String> future = new MyHystrixCommand("zhangsan").queue();
        System.out.println(future.get());
    }
}
