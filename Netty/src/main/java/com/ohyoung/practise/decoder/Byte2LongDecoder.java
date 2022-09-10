package com.ohyoung.practise.decoder;

import com.ohyoung.Logger;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author ouyb01
 * @date 2022/9/9 15:22
 */
public class Byte2LongDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        while (in.readableBytes() >= 8) {
            long l = in.readLong();
            Logger.info("解码出一个Long型数字：" + l);
            out.add(l);
        }
    }
}
