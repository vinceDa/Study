package com.ohyoung.core.programming.nio.netty.start;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

import java.nio.ByteBuffer;

/**
 * @author ouyb01
 * @date 2022/8/29 16:36
 */
public class NettyDiscardHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf in = (ByteBuf) msg;
        try {
            System.out.println("收到消息, 丢弃如下");
            while (in.isReadable()) {
                System.out.print((char)in.readByte());
            }
            System.out.println();
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }
}
