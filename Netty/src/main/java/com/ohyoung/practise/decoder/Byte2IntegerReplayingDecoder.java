package com.ohyoung.practise.decoder;

import com.ohyoung.Logger;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * @author ouyb01
 * @date 2022/9/9 15:39
 */
public class Byte2IntegerReplayingDecoder extends ReplayingDecoder<Integer> {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        int i = in.readInt();
        Logger.info("解码出一个整数：" + i);
        out.add(i);
    }
}
