package com.ohyoung.core.programming.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * 向服务端传输文件
 *
 * @author ouyb01
 * @date 2022/8/17 17:35
 */
public class SendFileClient {

    private Charset charset = Charset.forName("UTF-8");

    public static void main(String[] args) {
        SendFileClient client = new SendFileClient();
        client.sendFile();
    }

    public void sendFile() {
        try {
            String srcPath = "C:\\Users\\ouyb01\\Desktop\\kht.json";
            File file = new File(srcPath);
            if (!file.exists()) {
                System.out.println("file is not exist");
                return;
            }
            FileChannel fileChannel = new FileInputStream(file).getChannel();
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.socket().connect(new InetSocketAddress("127.0.0.1", 18899));
            // 设置为非阻塞
            socketChannel.configureBlocking(false);
            while (!socketChannel.finishConnect()) {
                // 不断自旋、等待或做其它一些事情
            }
            ByteBuffer buffer = sendFileNameAndLength(file, socketChannel);
            // 发送文件内容
            int length = sendContent(file, fileChannel, socketChannel, buffer);
            if (length == -1) {
                fileChannel.close();
                socketChannel.shutdownOutput();
                socketChannel.close();
            }
            System.out.println("=============文件传输成功=============");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int sendContent(File file, FileChannel fileChannel, SocketChannel socketChannel, ByteBuffer buffer) throws IOException {
        int length = 0;
        long progress = 0;
        buffer.clear();
        while ((length = fileChannel.read(buffer)) > 0) {
            buffer.flip();
            socketChannel.write(buffer);
            progress += length;
            System.out.println("| " + (100 * progress / file.length()) + "%|");
            buffer.clear();
        }
        return length;
    }

    /**
     * 发送文件名称和长度
     */
    public ByteBuffer sendFileNameAndLength(File file, SocketChannel socketChannel) throws IOException {
        ByteBuffer fileNameByteBuffer = charset.encode(file.getName());
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // 发送文件名称长度
        int fileNameLength = fileNameByteBuffer.capacity();
        buffer.putInt(fileNameLength);
        buffer.flip();
        socketChannel.write(buffer);
        System.out.println("Client 文件名称长度发送完成: " + fileNameLength);
        // 发送文件名称
        socketChannel.write(fileNameByteBuffer);
        System.out.println("Client 文件名称发送完成: " + file.getName());
        buffer.clear();
        // 发送文件长度
        buffer.putInt((int) file.length());
        buffer.flip();
        socketChannel.write(buffer);
        buffer.clear();
        System.out.println("Client 文件长度发送完成: " + file.length());
        return buffer;
    }

}
