package com.zlh.hello_spring_boot_starter.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池工具类
 * @author 70635
 */
public class ThreadPoolUtils {
    /**
     * 主线程拒绝策略
     */
    private static final ExecutorService THREAD_POOL_EXECUTOR
            = new ThreadPoolExecutor(2,
            4,
            60,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(20000),
            new ThreadPoolExecutor.CallerRunsPolicy());

    public static ExecutorService getThreadPoolConst(){
        return THREAD_POOL_EXECUTOR;
    }
}
