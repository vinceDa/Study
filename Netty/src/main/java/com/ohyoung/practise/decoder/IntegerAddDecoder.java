package com.ohyoung.practise.decoder;

import com.ohyoung.Logger;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * @author ouyb01
 * @date 2022/9/9 16:02
 */
public class IntegerAddDecoder extends ReplayingDecoder<IntegerAddDecoder.PHASE> {

    private int first;

    private int second;

    public IntegerAddDecoder() {
        super(PHASE.PHASE_1);
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        switch (state()) {
            case PHASE_1:
                first = in.readInt();
                checkpoint(PHASE.PHASE_2);
                break;
            case PHASE_2:
                second = in.readInt();
                Integer sum = first + second;
                Logger.info("sum：" + sum);
                out.add(sum);
        }
    }

    enum PHASE {
        // 第一阶段, 提取第一个整数, 完成后进入第二个阶段
        PHASE_1,
        // 第二阶段, 提取第二个整数, 然后第一个整数相加, 将结果输出
        PHASE_2
    }

}
