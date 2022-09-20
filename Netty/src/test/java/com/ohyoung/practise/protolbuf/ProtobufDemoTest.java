package com.ohyoung.practise.protolbuf;

import com.ohyoung.Logger;
import junit.framework.TestCase;

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
}