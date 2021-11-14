package com.ohyoung.match;

/**
 * @author ohYoung
 * @date 2021/10/7 17:19
 */
public class KMP {


    /**
     *
     * @param a 主串
     * @param b 模式串
     * @return 模式串应该移动的位数
     */
    public static int kmp(char[] a, char[] b) {
        int n = a.length;
        int m = b.length;
        int[] next = getNexts(b);
        int j = 0;
        for (int i = 0; i < n; i++) {
            // 一直找到a[i]和b[j]
            while (j > 0 && a[i] != b[j]) {
                j =  next[j - 1] + 1;
            }
            if (a[i] == b[j]) {
                j++;
            }
            // 已找到匹配模式串
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

    private static int[] getNexts(char[] b) {
        int m = b.length;
        int[] next = new int[m];
        next[0] = -1;
        int k = -1;
        for (int i = 0; i < m; i++) {
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
