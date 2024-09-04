package io.netty.qxlxi;

import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.concurrent.FastThreadLocalThread;

/**
 * 1.存
 * 2.取
 * @author qxlx
 * @date 2024/8/21 21:28
 */
public class FastThreadLocalTest {

    public static void main(String[] args) {
        final FastThreadLocal fastThreadLocal = new FastThreadLocal();
        final FastThreadLocal fastThreadLocal2 = new FastThreadLocal();
        final FastThreadLocal fastThreadLocal3 = new FastThreadLocal();
        FastThreadLocalThread fastThreadLocalThread = new FastThreadLocalThread(()-> {
            fastThreadLocal.set("1");
            fastThreadLocal.get();

            fastThreadLocal2.set("2");
            fastThreadLocal2.get();

            fastThreadLocal3.set("3");
            fastThreadLocal3.get();

            Thread thread = Thread.currentThread();
            System.out.println(thread);

            fastThreadLocal.remove();
        },"T1");


        fastThreadLocalThread.start();

    }

}
