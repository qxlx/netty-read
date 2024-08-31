package io.netty.qxlxi;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.logging.LoggingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyNettyServer1 {


    private static final Logger log = LoggerFactory.getLogger(MyNettyServer1.class);

    public static void main(String[] args) {

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.channel(NioServerSocketChannel.class);
        serverBootstrap.group(new NioEventLoopGroup());
        //接受socket缓冲区大小 等同于 滑动窗口的初始值 65535
        //serverBootstrap.option(ChannelOption.SO_RCVBUF, 100);
        //netty创建ByteBuf时 执行大小 默认1024 child ScoketChannel相关
        //serverBootstrap.childOption(ChannelOption.RCVBUF_ALLOCATOR,new AdaptiveRecvByteBufAllocator(16,16,16));
        serverBootstrap.childHandler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            //
            protected void initChannel(NioSocketChannel ch) throws Exception {
                ChannelPipeline pipeline = ch.pipeline();
                //sunshuai\ni love you\n
                //xxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n
                //最大长度 指的是 如果超过最大长度，还没有发现分隔符，不处理。
                pipeline.addLast(new LineBasedFrameDecoder(1024));
                pipeline.addLast(new LoggingHandler());

            }
        });
        //
        serverBootstrap.bind(8000);
    }
}
