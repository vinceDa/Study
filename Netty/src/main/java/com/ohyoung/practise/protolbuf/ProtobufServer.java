package com.ohyoung.practise.protolbuf;

import com.ohyoung.Logger;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;

/**
 * @author ouyb01
 * @date 2022/9/21 10:33
 */
public class ProtobufServer {

    private int serverPort;

    private ServerBootstrap b = new ServerBootstrap();

    public ProtobufServer(int serverPort) {
        this.serverPort = serverPort;
    }

    public void runServer() {
        NioEventLoopGroup boosLoopGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup workerLoopGroup = new NioEventLoopGroup();
        b.group(boosLoopGroup, workerLoopGroup);
        b.channel(NioServerSocketChannel.class);
        b.localAddress(serverPort);
        b.option(ChannelOption.SO_KEEPALIVE, true);
        b.option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);
        b.childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);
        try {
            b.childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new ProtobufVarint32FrameDecoder());
                    // 需要解码的目标类
                    ch.pipeline().addLast(new ProtobufDecoder(MsgProtos.Msg.getDefaultInstance()));
                    ch.pipeline().addLast(new ProtobufBusinessHandler());
                }
            });
            ChannelFuture channelFuture = b.bind().sync();
            Logger.info(" 服务器启动成功，监听端口: " +
                    channelFuture.channel().localAddress());
            ChannelFuture closeFuture = channelFuture.channel().closeFuture();
            closeFuture.sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            workerLoopGroup.shutdownGracefully();
            boosLoopGroup.shutdownGracefully();
        }
    }

    static class ProtobufBusinessHandler extends ChannelInboundHandlerAdapter {

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            MsgProtos.Msg protoMsg = (MsgProtos.Msg) msg;
            //经过pipeline的各个decoder，到此Person类型已经可以断定
            Logger.info("收到一个 MsgProtos.Msg 数据包 -> ");
            Logger.info("protoMsg.getId():=" + protoMsg.getId());
            Logger.info("protoMsg.getContent():=" + protoMsg.getContent());
        }
    }

    public static void main(String[] args) {
        new ProtobufServer(18899).runServer();
    }
}
