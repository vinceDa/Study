package com.ohyoung.practise.protolbuf;

import com.ohyoung.Logger;
import junit.framework.TestCase;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author ouyb01
 * @date 2022/9/20 18:00
 */
public class ProtobufDemoTest extends TestCase {

    public void testSerAndDesc1() throws IOException {
        MsgProtos.Msg msg = ProtobufDemo.buildMsg();
        byte[] data = msg.toByteArray();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStream.write(data);
        data = outputStream.toByteArray();
        // 反序列化
        MsgProtos.Msg parse = MsgProtos.Msg.parseFrom(data);
        Logger.info("id:=" + msg.getId());
        Logger.info("content:=" + msg.getContent());
    }



    public void testSerAndDesc2() throws IOException {
        MsgProtos.Msg msg = ProtobufDemo.buildMsg();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        msg.writeTo(outputStream);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        // 反序列化
        MsgProtos.Msg from = MsgProtos.Msg.parseFrom(inputStream);
        Logger.info("id:=" + from.getId());
        Logger.info("content:=" + from.getContent());
    }

    /**
     * 带字节长度：[字节长度][字节数据]，用于解决粘包/半包问题
     */
    public void testSerAndDesc3() throws IOException {
        MsgProtos.Msg msg = ProtobufDemo.buildMsg();
        // 序列化到二进制码流
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        msg.writeDelimitedTo(outputStream);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        MsgProtos.Msg from = MsgProtos.Msg.parseDelimitedFrom(inputStream);
        Logger.info("id:=" + from.getId());
        Logger.info("content:=" + from.getContent());
    }

}