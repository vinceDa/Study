package com.ohyoung.practise.protolbuf.costomize;

import com.ohyoung.practise.protolbuf.MsgProtos;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author ouyb01
 * @date 2022/9/21 12:33
 */
public class MyProtobufEncoder extends MessageToByteEncoder<MsgProtos.Msg> {


    @Override
    protected void encode(ChannelHandlerContext ctx, MsgProtos.Msg msg, ByteBuf out) throws Exception {
        // 写入待发送的Protobuf POJO实例的二进制字节长度
        byte[] bytes = msg.toByteArray();
        int length = bytes.length;
        // 将消息长度写入, 这里只用两个字节, 直达为32767
        out.writeShort(length);
        // 写入其他的字段，如魔数、版本号

        // 写入Protobuf POJO实例的二进制字节码内容
        out.writeBytes(bytes);
    }
}
