package io.netty.qxlxi;

import io.netty.util.Timer;

/**
 * @author qxlx
 * @date 2024/8/20 07:17
 */
public class ThreadLocalTest {

    public static void main(String[] args) {
        ThreadLocal threadLocal = new ThreadLocal();
        ThreadLocal threadLocal2 = new ThreadLocal();
        ThreadLocal threadLocal3 = new ThreadLocal();
        new Thread(()->{
            threadLocal.set("A");
            threadLocal2.set("C");
            threadLocal3.set("C");
            Thread thread = Thread.currentThread();
            System.out.println(thread+"\t"+threadLocal.get());
        },"T1").start();

        new Thread(()->{
            threadLocal.set("B");
            Thread thread = Thread.currentThread();
            System.out.println(thread+"\t"+threadLocal.get());
        },"T2").start();

        threadLocal.remove();

    }

}
