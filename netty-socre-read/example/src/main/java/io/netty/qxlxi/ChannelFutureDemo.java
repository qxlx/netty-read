package io.netty.qxlxi;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

/**
 * @author qxlx
 * @date 2024/9/7 14:55
 */
public class ChannelFutureDemo {

    public static void main(String[] args) {
        ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer(10);

        Thread thread = Thread.currentThread();
        System.out.println(thread);
    }

}
