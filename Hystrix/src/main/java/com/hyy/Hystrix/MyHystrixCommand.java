package com.hyy.Hystrix;

import com.netflix.hystrix.*;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategyDefault;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author hyy
 */
public class MyHystrixCommand extends HystrixCommand<String> {

    private final String name;
    private static final HystrixCommandKey GETTER_KEY = HystrixCommandKey.Factory.asKey("MyKey");

    public MyHystrixCommand(String name) {
        super(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("MyGroup"))
                .andCommandKey(GETTER_KEY));
        // 信号量策略配置
//        super(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("MyGroup"))
//                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
//                        .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE
//                        )));
        // 线程隔离策略
//        super(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("MyGroup"))
//                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
//                        .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD))
//                        .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(10)
//                        .withMaxQueueSize(100).withMaximumSize(100)));
        this.name = name;
    }

    public static void flushCache(String name) {
        HystrixRequestCache.getInstance(GETTER_KEY, HystrixConcurrencyStrategyDefault.getInstance()).clear(name);
    }

    @Override
    protected String getFallback() {
        return "失败了 ";
    }

    @Override
    protected String run() throws Exception {
        System.err.println("get data");
        return this.name + ":" + Thread.currentThread().getName();
    }

    @Override
    protected String getCacheKey() {
        return String.valueOf(this.name);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        String result = new MyHystrixCommand("zhangsan").execute();
        System.out.println(result);
        MyHystrixCommand.flushCache("zhangsan");
        Future<String> future = new MyHystrixCommand("zhangsan").queue();
        System.out.println(future.get());
        context.shutdown();

        // 异步调用
//        Future<String> future = new MyHystrixCommand("zhangsan").queue();
//        System.out.println(future.get());
    }
}
