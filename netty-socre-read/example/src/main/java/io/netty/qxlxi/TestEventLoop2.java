package io.netty.qxlxi;

import io.netty.channel.EventLoop;
import io.netty.channel.nio.NioEventLoopGroup;

/**
 * @author qxlx
 * @date 2024/7/31 21:41
 */
public class TestEventLoop2 {

    public static void main(String[] args) {
        EventLoop eventLoop = new NioEventLoopGroup().next();

        eventLoop.execute(() -> {
            System.out.println("hello workd");
        });
    }

}
