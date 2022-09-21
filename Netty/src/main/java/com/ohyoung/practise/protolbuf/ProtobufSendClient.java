package com.ohyoung.practise.protolbuf;

import com.ohyoung.Logger;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

/**
 * @author ouyb01
 * @date 2022/9/21 10:48
 */
public class ProtobufSendClient {

    static String content = "oh, Young!";

    private String ip;

    private Integer port;

    public ProtobufSendClient(String ip, Integer port) {
        this.ip = ip;
        this.port = port;
    }

    private Bootstrap b = new Bootstrap();

    public void runClient() {
        NioEventLoopGroup workerLoopGroup = new NioEventLoopGroup();
        b.group(workerLoopGroup);
        b.channel(NioSocketChannel.class);
        b.remoteAddress(ip, port);
        b.option(ChannelOption.SO_KEEPALIVE, true);
        b.option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);

        try {
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new ProtobufVarint32LengthFieldPrepender());
                    ch.pipeline().addLast(new ProtobufEncoder());
                }
            });

            ChannelFuture f = b.connect();
            f.addListener((ChannelFuture futureListener) -> {
                if (futureListener.isSuccess()) {
                    Logger.info("EchoClient客户端连接成功!");
                } else {
                    Logger.info("EchoClient客户端连接失败!");
                }
            });
            f.sync();
            Channel channel = f.channel();

            for (int i = 0; i < 100; i++) {
                MsgProtos.Msg msg = build(i, i + "-> oh, Young!");
                channel.writeAndFlush(msg);
                Logger.info("发送报文数：" + i);
            }
            channel.flush();

            ChannelFuture closeFuture = channel.closeFuture();
            closeFuture.sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            workerLoopGroup.shutdownGracefully();
        }
    }


    //构建ProtoBuf对象
    public MsgProtos.Msg build(int id, String content) {

        MsgProtos.Msg.Builder builder = MsgProtos.Msg.newBuilder();

        builder.setId(id);
        builder.setContent(content);

        return builder.build();
    }

    public static void main(String[] args) {
        new ProtobufSendClient("127.0.0.1", 18899).runClient();
    }
}
