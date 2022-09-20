package com.ohyoung.practise.protolbuf;

/**
 * @author ouyb01
 * @date 2022/9/20 18:00
 */
public class ProtobufDemo {

    public static MsgProtos.Msg buildMsg() {
        MsgProtos.Msg.Builder personBuilder =
                MsgProtos.Msg.newBuilder();
        personBuilder.setId(1000);
        personBuilder.setContent("ouYoung!");
        MsgProtos.Msg message = personBuilder.build();
        return message;
    }

}
