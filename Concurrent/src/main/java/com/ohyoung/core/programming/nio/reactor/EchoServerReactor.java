package com.ohyoung.core.programming.nio.reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Objects;

/**
 * @author ouyb01
 * @date 2022/8/24 16:52
 */
public class EchoServerReactor implements Runnable{

    Selector selector;

    ServerSocketChannel serverSocketChannel;

    public EchoServerReactor() throws IOException {
        selector = Selector.open();
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        // 接收accept事件
        SelectionKey selectionKey = serverSocketChannel.register(selector, 0, new AcceptorHandler());
        serverSocketChannel.socket().bind(new InetSocketAddress("127.0.0.1", 18899));
        selectionKey.interestOps(SelectionKey.OP_ACCEPT);
    }

    @Override
    public void run() {

    }

    class AcceptorHandler implements Runnable {

        @Override
        public void run() {
            try {
                SocketChannel channel = serverSocketChannel.accept();
                System.out.println("=============接到一个连接=============");
                if (Objects.nonNull(channel)) {
                    new EchoHandler(selector, channel);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
