package com.ohyoung.core.programming.nio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/**
 * @author ouyb01
 * @date 2022/8/23 16:03
 */
public class ReceiveServer {

    // 接收文件路径
    private static final String RECEIVE_PATH = "D:\\tmp\\";

    private Charset charset = Charset.forName("UTF-8");

    private ByteBuffer buffer = ByteBuffer.allocate(1024);

    // 使用Map保存每个客户端传输, 当OP_READ通道可读时, 根据Channel找到对应的对象
    private Map<SelectableChannel, Client> clientMap = new HashMap<>();

    public void startServer() throws IOException {
        // 1. 获取选择器
        Selector selector = Selector.open();
        // 2. 获取通道
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        ServerSocket serverSocket = serverChannel.socket();
        // 3. 通道设置为非阻塞
        serverChannel.configureBlocking(false);
        // 4. 绑定连接
        serverSocket.bind(new InetSocketAddress(18899));
        // 5. 将通道注册到选择器且注册事件为新连接
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        // 6. 轮询感兴趣的I/O就绪事件, 在对应的事件中做对应的处理
        while (selector.select() > 0) {
            if (Objects.isNull(selector.selectedKeys())) {
                continue;
            }
            Iterator<SelectionKey> selectedKeys = selector.selectedKeys().iterator();
            while (selectedKeys.hasNext()) {
                SelectionKey key = selectedKeys.next();
                // 如果是连接就绪事件, 则获取客户端新连接
                if (key.isAcceptable()) {
                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    if (Objects.isNull(socketChannel)) {
                        continue;
                    }
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                    // 业务处理
                    Client client = new Client();
                    client.remoteAddress=(InetSocketAddress)socketChannel.getRemoteAddress();
                    clientMap.put(socketChannel, client);
                    System.out.println(socketChannel.getRemoteAddress() + ": 连接成功");
                } else if (key.isReadable()) {
                    processData(key);
                }
                selectedKeys.remove();
            }
        }
    }


    /**
     * 处理客户端传过来的数据
     */
    private void processData(SelectionKey key) throws IOException{
        SelectableChannel channel = key.channel();
        Client client = clientMap.get(channel);
        SocketChannel socketChannel = (SocketChannel) channel;
        int num;
        try {
            buffer.clear();
            while ((num = socketChannel.write(buffer)) > 0) {
                buffer.flip();
                // 客户端发送过来的, 首先处理文件名
                if (Objects.isNull(client.fileName)) {
                    if (buffer.capacity() < 4) {
                        continue;
                    }
                    int fileNameLen = buffer.getInt();
                    byte[] fileNameBytes = new byte[fileNameLen];
                    buffer.get(fileNameBytes);
                    // 文件名
                    String fileName = new String(fileNameBytes, charset);
                    File directory = new File(RECEIVE_PATH);
                    if (!directory.exists()) {
                        directory.mkdir();
                    }
                    System.out.println("NIO 传输目标dir：" + directory);
                    client.fileName = fileName;
                    String fullName = directory.getAbsolutePath() + File.separatorChar + fileName;
                    System.out.println("NIO 传输目标文件：" + fullName);
                    File file = new File(fullName.trim());
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    FileChannel fileChannel = new FileOutputStream(file).getChannel();
                    client.outChannel = fileChannel;
                    if (buffer.capacity() < 8) {
                        continue;
                    }
                    // 文件长度
                    long fileLength = buffer.getLong();
                    client.fileLength = fileLength;
                    client.startTime = System.currentTimeMillis();
                    System.out.println("===========NIO传输开始===========");
                    client.receiveLength += buffer.capacity();
                    if (buffer.capacity() > 0) {
                        // 写入文件
                        client.outChannel.write(buffer);
                    }
                    if (client.isFinished()) {
                        finished(key, client);
                    }
                    buffer.clear();
                } else {
                    // 客户端发送过来的, 最后是文件内容
                    client.receiveLength += buffer.capacity();
                    // 写入文件
                    client.outChannel.write(buffer);
                    if (client.isFinished()) {
                        finished(key, client);
                    }
                    buffer.clear();
                }
            }
            key.cancel();
        } catch (IOException e) {
            key.cancel();
            e.printStackTrace();
            return;
        }
        // 调用close为-1, 到达末尾
        if (num == -1) {
            finished(key, client);
            buffer.clear();
        }
    }

    private void finished(SelectionKey key, Client client) throws IOException {
        client.outChannel.close();
        System.out.println("============上传完毕============");
        key.cancel();
        System.out.println("文件接收成功,File Name：" + client.fileName);
        System.out.println(" Size：" + client.fileLength);
        System.out.println("NIO IO 传输毫秒数：：" + (System.currentTimeMillis() - client.startTime));

    }

    public static void main(String[] args) throws IOException {
        ReceiveServer server = new ReceiveServer();
        server.startServer();
    }


    /**
     * 服务端保存的客户端对象，对应一个客户端文件
     */
    static class Client {
        // 文件名称
        String fileName;
        // 长度
        long fileLength;
        // 开始传输的时间
        long startTime;
        // 客户端的地址
        InetSocketAddress remoteAddress;
        // 输出的文件通道
        FileChannel outChannel;
        // 接收长度
        long receiveLength;

        public boolean isFinished() {
            return receiveLength >= fileLength;
        }
    }

}
