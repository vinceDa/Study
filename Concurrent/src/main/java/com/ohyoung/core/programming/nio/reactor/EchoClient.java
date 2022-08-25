package com.ohyoung.core.programming.nio.reactor;

import lombok.Data;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author ouyb01
 * @date 2022/8/24 17:38
 */
public class EchoClient {

    public void start() throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 18899));
        socketChannel.configureBlocking(false);
        socketChannel.setOption(StandardSocketOptions.TCP_NODELAY, true);
        while (!socketChannel.finishConnect()) {

        }
        Processor processor = new Processor(socketChannel);
        Commander commander = new Commander(processor);
        new Thread(commander).start();
        new Thread(processor).start();

    }

    static class Commander implements Runnable {

        Processor processor;

        public Commander(Processor processor) {
            this.processor = processor;
        }

        @Override
        public void run() {
            while (!Thread.interrupted()) {

                ByteBuffer buffer = processor.getSendBuffer();

                Scanner scanner = new Scanner(System.in);
                try {
                    while (processor.hasData.get()) {
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("请输入发送内容: ");
                if (scanner.hasNext()) {

                    String next = scanner.next();
                    buffer.put((LocalDate.now() + " >>" + next).getBytes());
                    processor.hasData.set(true);
                }

            }
        }
    }

    @Data
    static class Processor implements Runnable {

        ByteBuffer sendBuffer = ByteBuffer.allocate(1024);

        ByteBuffer readBuffer = ByteBuffer.allocate(1024);


        protected AtomicBoolean hasData = new AtomicBoolean(false);

        final Selector selector;

        final SocketChannel socketChannel;

        public Processor(SocketChannel socketChannel) throws IOException{
            selector = Selector.open();
            this.socketChannel = socketChannel;
            socketChannel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
        }

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    selector.select();
                    Set<SelectionKey> selectedKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = selectedKeys.iterator();
                    while (iterator.hasNext()) {
                        SelectionKey sk = iterator.next();
                        if (sk.isWritable()) {
                            if (hasData.get()) {
                                SocketChannel channel = (SocketChannel) sk.channel();
                                sendBuffer.flip();
                                channel.write(sendBuffer);
                                sendBuffer.clear();
                                hasData.set(false);
                            }
                        } else if (sk.isReadable()) {
                            SocketChannel channel = (SocketChannel) sk.channel();
                            int length;
                            while ((length = channel.read(readBuffer)) > 0) {
                                readBuffer.flip();
                                readBuffer.clear();
                            }
                        }
                    }
                    selectedKeys.clear();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new EchoClient().start();
    }
}
