package com.ohyoung.core.programming.nio.reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

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
        try {
            while (!Thread.interrupted()) {
                // 限时阻塞查询
                selector.select(1000);
                Set<SelectionKey> selected = selector.selectedKeys();
                if (Objects.isNull(selected) || selected.isEmpty()) {
                    continue;
                }
                Iterator<SelectionKey> it = selected.iterator();
                while (it.hasNext()) {
                    // Reactor负责dispatch收到的事件
                    SelectionKey sk = it.next();
                    // 避免下次重复处理
                    it.remove();
                    dispatch(sk);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    void dispatch(SelectionKey sk) {
        Runnable handler = (Runnable) sk.attachment();
        // 调用之前attach绑定到选择键的handler处理对象
        if (Objects.nonNull(handler)) {
            handler.run();
        }
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

    public static void main(String[] args) throws IOException {
        new Thread(new EchoServerReactor()).start();
    }
}
