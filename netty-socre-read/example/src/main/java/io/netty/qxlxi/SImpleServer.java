package io.netty.qxlxi;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author qxlx
 * @date 2024/7/28 20:52
 */
public class SImpleServer {

    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup bossGrpup = new NioEventLoopGroup(1);
        EventLoopGroup wrokerGrpup = new NioEventLoopGroup();

        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(bossGrpup,wrokerGrpup)
//                .option()
                // 反射执行
                .channel(NioServerSocketChannel.class)
                .handler(new SimpleServerHandler())
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {

                    }
                });

        ChannelFuture f = bootstrap.bind(8888).sync();

        f.channel().closeFuture().sync();
    }

    private static class SimpleServerHandler extends ChannelInboundHandlerAdapter {
        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            System.out.println("channelActive");
        }

        @Override
        public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
            System.out.println("channelRegistered");
        }

        @Override
        public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
            System.out.println("handlerAdded");
        }
    }

}
