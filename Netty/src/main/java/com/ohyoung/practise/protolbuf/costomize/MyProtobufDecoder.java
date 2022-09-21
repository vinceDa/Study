package com.ohyoung.practise.protolbuf.costomize;

import com.ohyoung.practise.protolbuf.MsgProtos;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;
import java.util.Objects;

/**
 * @author ouyb01
 * @date 2022/9/21 12:36
 */
public class MyProtobufDecoder extends ByteToMessageDecoder {


    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        // 标记当前读指针的位置
        in.markReaderIndex();
        // 读取长度，如果长度位数不够，就终止读取
        if (in.readableBytes() < 2) {
            return;
        }

        // 按照净长度读取内容。如果内容的字节数不够，则恢复到之前的起始位置（也就是长度的位置），然后终止读取
        int length = in.readShort();
        // 非法数据, 关闭连接
        if (length < 0) {
            ctx.close();
            // 可读字节少于预期消息长度
        } else if (length > in.readableBytes()) {
            // 充值读取位置
            in.resetReaderIndex();
            return;
        }
        // 读取魔数、版本号等其他字段


        byte[] array;
        // 堆缓冲
        if (in.hasArray()) {
            ByteBuf slice = in.slice();
            array = slice.array();
        } else {
            // 直接缓冲
            array = new byte[length];
            in.readBytes(array, 0, length);
        }
        // 字节转成Protobuf的pojo对象
        MsgProtos.Msg outMsg = MsgProtos.Msg.parseFrom(array);
        if (Objects.nonNull(outMsg)) {
            out.add(outMsg);
        }
    }
}
