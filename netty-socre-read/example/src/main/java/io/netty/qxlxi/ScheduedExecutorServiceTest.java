package io.netty.qxlxi;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author qxlx
 * @date 2024/8/24 10:47
 */
public class ScheduedExecutorServiceTest {

    public static void main(String[] args) {
        ScheduledExecutorService exthreadPool = Executors.newScheduledThreadPool(5);
        exthreadPool.scheduleAtFixedRate(() ->
                System.out.println("HelloWorld"),
                1000, // 延迟1S后开始执行
                2000,  // 2S执行一次
                TimeUnit.MILLISECONDS);
    }

}
