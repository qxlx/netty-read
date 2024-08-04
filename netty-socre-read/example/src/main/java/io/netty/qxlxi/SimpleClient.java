package io.netty.qxlxi;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LoggingHandler;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * @author qxlx
 * @date 2024/8/4 11:24
 */
public class SimpleClient {

    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.channel(NioSocketChannel.class)
                .group(eventLoopGroup)
                .handler(new ChannelInitializer() {
                    @Override
                    protected void initChannel(Channel ch) throws Exception {
                        ch.pipeline().addLast(new LoggingHandler());
                        ch.pipeline().addLast(new ChannelInboundHandlerAdapter() {
                            @Override
                            public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                ByteBufAllocator allocator = ctx.alloc();
                                ByteBuf buffer = allocator.buffer();
                                buffer.writeCharSequence("xiaohei", Charset.defaultCharset());
                                ctx.writeAndFlush(buffer);
                            }
                        });
                    }
                });

        Channel channel = bootstrap.connect(new InetSocketAddress(8888)).sync().channel();
        channel.closeFuture().sync();
    }

}
