package com.ohyoung.match;

/**
 * BM算法
 * @author vince
 */
public class BoyerMoore {

    private static final int SIZE = 256;

    /**
     * 将模式串的每个字符存在散列表中
     * @param b 模式串
     * @param n 模式串的长度
     * @param bc 散列表
     */
    private void generateBC(char[] b, int n, int[] bc) {
        for (int i = 0; i < SIZE; i++) {
            bc[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            int ascii = b[i];
            bc[ascii] = i;
        }
    }

    /**
     *
     * @param a 主串
     * @param m 主串长度
     * @param b 模式串
     * @param n 模式串长度
     * @return 第一次匹配上的位置
     */
    public int bm(char[] a, int m, char[] b, int n) {
        // 记录模式串中每个字符最后出现的位置
        int[] bc = new int[SIZE];
        // 构建坏字符哈希表
        generateBC(b, n, bc);
        // i表示主串与模式串对齐的第一个字符
        int i = 0;
        while (i <= n - m) {
            int j;
            // 模式串从后往前匹配
            for (j = m - 1; j >= 0; --j) {
                // 坏字符对应模式串中的下标是j
                if (a[i + j] != b[j]) {
                    break;
                }
            }
            if (j < 0) {
                // 匹配成功，返回主串与模式串第一个匹配的字符的位置
                return i;
            }
            // 这里等同于将模式串向后滑动j-bc[a[i + j]]位
            i = i + (j - bc[a[i + j]]);
        }
        return -1;
    }

}
