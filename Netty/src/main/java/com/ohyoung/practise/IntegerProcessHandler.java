package com.ohyoung.practise;

import com.ohyoung.Logger;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 处理Byte2IntegerDecoder解码后的整数
 * @author ouyb01
 * @date 2022/9/9 14:59
 */
public class IntegerProcessHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Integer integer = (Integer) msg;
        Logger.info("打印出一个整数：" + integer);
    }
}
