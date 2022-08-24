package com.ohyoung.core.programming.nio.discard;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author ouyb01
 * @date 2022/8/23 11:12
 */
public class DiscardServer {

    public static void startServer() throws IOException {
        // 1. 获取选择器
        Selector selector = Selector.open();
        // 2. 获取通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 3. 设置为非阻塞
        serverSocketChannel.configureBlocking(false);
        // 4. 绑定链接
        serverSocketChannel.bind(new InetSocketAddress(18899));
        // 5. 将通道注册到选择器
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        // 6. 轮询感兴趣的IO就绪事件
        while (selector.select() > 0) {
            // 7. 获取选择键集合
            Iterator<SelectionKey> selectedKeys = selector.selectedKeys().iterator();
            while (selectedKeys.hasNext()) {
                // 8. 获取单个的选择键并处理
                SelectionKey selectionKey = selectedKeys.next();
                // 9. 判断选择键具体是什么事件
                if (selectionKey.isAcceptable()) {
                    System.out.println("============新连接============");
                    // 11. 将新连接切换为非阻塞模式
                    // 10. 如果是连接就绪事件, 就获取客户端连接
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    // 12. 将新连接注册到选择器上
                    socketChannel.register(selector, SelectionKey.OP_READ);
                    // 13. 如果选择键是可读事件, 则读取数据
                } else if (selectionKey.isReadable()) {
                    SocketChannel readableChannel = (SocketChannel) selectionKey.channel();
                    // 14. 读取数据并丢弃
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int length = 0;
                    while ((length = readableChannel.read(buffer)) > 0) {
                        buffer.flip();
                        System.out.println(new String(buffer.array(), 0, length));
                    }
                }
                // 15. 移除选择键
                selectedKeys.remove();
            }
            // 16. 关闭连接
            serverSocketChannel.close();
        }
    }


    public static void main(String[] args) throws IOException {
        startServer();
    }
}
