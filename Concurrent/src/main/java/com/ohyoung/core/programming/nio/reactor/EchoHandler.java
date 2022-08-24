package com.ohyoung.core.programming.nio.reactor;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * @author ouyb01
 * @date 2022/8/24 16:59
 */
public class EchoHandler implements Runnable{

    final SocketChannel channel;

    final SelectionKey selectionKey;

    final ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

    static final int RECEIVING = 0, SENDING = 1;

    int state = RECEIVING;

    public EchoHandler(Selector selector, SocketChannel c) throws IOException {
        this.channel = c;
        c.configureBlocking(false);
        // 取得选择键绑定事件处理器
        selectionKey = channel.register(selector, 0);
        selectionKey.attach(this);

        // 注册Read就绪事件
        selectionKey.interestOps(SelectionKey.OP_READ);
        // 唤醒事件查询线程, 在单线程模式下没啥意义
        selector.wakeup();
    }

    @Override
    public void run() {
        try {
            // 发送状态
            if (state == SENDING) {
                // 写入通道
                channel.write(byteBuffer);
                // 写完后准备读, 切换模式
                byteBuffer.clear();
                // 写完后注册read就绪事件
                selectionKey.interestOps(SelectionKey.OP_READ);
                state = RECEIVING;
            } else if (state == RECEIVING) {
                // 从通道读
                int length;
                while ((length = channel.read(byteBuffer)) > 0) {
                    System.out.println("read: " + new String(byteBuffer.array(), 0, length));
                }
                // 读完后准备写, 切换模式
                byteBuffer.flip();
                // 读完后注册write就绪事件
                selectionKey.interestOps(SelectionKey.OP_WRITE);
                state = RECEIVING;
            }
            // select key需要重复使用, 不能通过selectionKey.cancel();来关闭
        } catch (IOException e) {
            e.printStackTrace();
            selectionKey.cancel();
            try {
                channel.finishConnect();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }
}
