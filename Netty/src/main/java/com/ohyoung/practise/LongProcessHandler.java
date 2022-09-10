package com.ohyoung.practise;

import com.ohyoung.Logger;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author ouyb01
 * @date 2022/9/9 15:24
 */
public class LongProcessHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Long l = (Long) msg;
        Logger.info("打印出一个Long型数字：" + l);
    }
}
