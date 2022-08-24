package com.ohyoung.core.programming.nio.channel;

import java.io.IOException;
import java.nio.channels.SocketChannel;

/**
 * @author ouyb01
 * @date 2022/8/17 15:51
 */
public class MySocketChannel {

    public static void main(String[] args) throws IOException {
        // 获取套接字传输通道
        SocketChannel socketChannel = SocketChannel.open();
        // 设置为非阻塞模式

        // 对服务器的IP和端口发起连接

        // 检查当前是否连接到了主机
        while (!socketChannel.finishConnect()) {

        }
    }

}
