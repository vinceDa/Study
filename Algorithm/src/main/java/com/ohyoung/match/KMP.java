package com.ohyoung.match;

public class KMP {

    /**
     * kmp算法
     * @param a 主串
     * @param n 主串长度
     * @param b 模式串
     * @param m 模式串长度
     * @return 模式串和主串匹配时在主串的下标
     */
    public static int kmp(char[] a, int n, char[] b , int m) {
        int[] next = getNexts(b, m);
        int j = 0;
        for (int i = 0; i < n; i++) {
            // 一直找到a[i]和b[j]
            while (j > 0 && a[i] != b[j]) {
                j = next[j - 1] + 1;
            }
            if (a[i] == b[j]) {
                j++;
            }
            // 已匹配模式串
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

    /**
     * 生成next数组
     * @param b 模式串
     * @param m 模式串长度
     * @return next数组
     */
    private static int[] getNexts(char[] b, int m) {
        int[] next = new int[m];
        // 字串长度为1时, 不存在匹配项
        next[0] = -1;
        int k = -1;
        for (int i = 1; i < m; i++) {
            while (k != -1 && b[k + 1] != b[i]) {
                k = next[k];
            }
            if (b[k + 1] == b[i]) {
                k++;
            }
            next[i] = k;
        }
        return next;
    }

}
