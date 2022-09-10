package com.ohyoung.practise.decoder;

import com.ohyoung.Logger;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * 自定义整数解码器
 * @author ouyb01
 * @date 2022/9/9 14:51
 */
public class Byte2IntegerDecoder extends ByteToMessageDecoder {


    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        // 整数占4个字节(有没有办法不判断字节长度直接读取?)
        while (in.readableBytes() >= 4) {
            int i = in.readInt();
            Logger.info("解码出一个整数：" + i);
            out.add(i);
        }
    }
}
