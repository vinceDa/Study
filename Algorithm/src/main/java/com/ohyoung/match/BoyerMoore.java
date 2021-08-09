package com.ohyoung.match;

/**
 * BM算法
 */
public class BoyerMoore {

    private static final int SIZE = 256;

    /**
     * 将模式串的每个字符存在散列表中
     * @param b 模式串
     * @param m 模式串的长度
     * @param bc 散列表
     */
    private void generateBC(char[] b, int m, int[] bc) {
        for (int i = 0; i < SIZE; i++) {
            bc[i] = -1;
        }
        for (int i = 0; i < m; i++) {
            int ascii = b[i];
            bc[ascii] = i;
        }
    }

}
