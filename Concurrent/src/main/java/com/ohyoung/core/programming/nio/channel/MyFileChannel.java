package com.ohyoung.core.programming.nio.channel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;

/**
 * @author ouyb01
 * @date 2022/8/17 11:12
 */
public class MyFileChannel {

    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            // 获取FileChannel
            fis = new FileInputStream("C:\\Users\\ouyb01\\Desktop\\kht.json");
            inChannel = fis.getChannel();
            fos = new FileOutputStream("C:\\Users\\ouyb01\\Desktop\\bak\\kht.json");
            outChannel = fos.getChannel();
            // 新建buf, 处于写模式
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            // inChannel将数据写入byteBuffer, 所以此时需要写模式
            while (inChannel.read(byteBuffer) != -1) {
                // 切换成读模式, outChannel将数据从byteBuffer读出来
                byteBuffer.flip();
                int outLength;
                while ((outLength = outChannel.write(byteBuffer)) != 0) {
                    System.out.println("写入的字节数为: " + outLength);
                }
                // outChannel读取完毕后, 清除buffer
                byteBuffer.clear();
            }
            // 强制刷入磁盘
            outChannel.force(true);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭所有可关闭的对象
            try {
                outChannel.close();
                fos.close();
                inChannel.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


}
