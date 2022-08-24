package com.ohyoung.core.programming.nio;

import javafx.geometry.VPos;

import java.nio.Buffer;
import java.nio.IntBuffer;

/**
 * @author ouyb01
 * @date 2022/8/16 16:47
 */
public class UseBuffer {

    static IntBuffer intBuffer = null;

    public static void main(String[] args) {
        // allocate
        allocate();
        // putTest
        putTest();
        // flip
        flip();
        // get
        get(2);
        get(3);
        // rewind
        rewind();
        // reRead: 再读一遍
        reRead();
        // mark and reset
        reset();
        // clear: 清空缓冲区，进入写模式
        clear();
    }

    private static void allocate() {
        intBuffer = IntBuffer.allocate(20);
        print(intBuffer, "allocate");
    }

    private static void putTest() {
        for (int i = 0; i < 5; i++) {
            intBuffer.put(i);
        }
        print(intBuffer, "putTest");
    }

    private static void flip() {
        intBuffer.flip();
        print(intBuffer, "flip");
    }

    private static void get(int total) {
        for (int i = 0; i < total; i++) {
            int j = intBuffer.get();
            System.out.println(j + " ");
        }
        print(intBuffer, "get");
    }

    private static void rewind() {
        intBuffer.rewind();
        print(intBuffer, "rewind");
    }

    private static void reRead() {
        System.out.println("---------after reRead---------");
        for (int i = 0; i < 5; i++) {
            if (i == 2) {
                intBuffer.mark();
            }
            System.out.print(intBuffer.get() + " ");
        }
        System.out.println();
    }

    private static void reset() {
        intBuffer.reset();
        print(intBuffer, "afterReset");
    }

    private static void clear() {
        intBuffer.clear();
        print(intBuffer, "clear");
    }

    private static void print(IntBuffer intBuffer, String method) {
        System.out.println("---------after " + method + "---------");
        System.out.println("position=" + intBuffer.position());
        System.out.println("limit=" + intBuffer.limit());
        System.out.println("capacity=" + intBuffer.capacity());
    }

}
