package com.ohyoung.match;

/**
 * BM算法：根据自己的理解实现一边
 * @author vince
 */
public class MyBMPractice {

    public static void main(String[] args) {
        MyBMPractice practice = new MyBMPractice();
        char[] a = new char[]{'a', 'b', 'd', 'c', 'a'};
        char[] b = new char[]{'d', 'c', 'a'};
        System.out.println(practice.bm(a, 5, b, 3));
    }

    private static final int SIZE = 256;

    /**
     * 记录模式串的每个字符在模式串中所处的位置
     * @param b 模式串
     * @param m 模式串的长度
     * @param bc 散列表
     */
    private void generateBC(char[] b, int m, int[] bc) {
        // 初始化bc数组
        for (int i = 0; i < SIZE; i++) {
            bc[i] = -1;
        }
        // 以每个字符的ascii码为key, 在模式串中的位置为值存储
        for (int i = 0; i < m; i++) {
            int ascii = b[i];
            // 如果存在相同字符, 总是用靠后的字符覆盖之前的, 保证移动位数不会过多, 避免错过可匹配的情况
            bc[ascii] = i;
        }
    }

    /**
     * @param b 模式串
     * @param m 模式串长度
     * @param suffix suffix[后缀长度] = 相匹配模式字串的起始下标
     * @param prefix prefix[后缀长度] = 是否和前缀匹配(true / false)
     */
    private void generateGS(char[] b, int m, int[] suffix, boolean[] prefix) {
        // 初始化
        for (int i = 0; i < m; i++) {
            suffix[i] = -1;
            prefix[i] = false;
        }
        for (int i = 0; i < m - 1; i++) {
            int j = i;
            // 公共后缀子串长度
            int k = 0;
            // 与b[0, m - 1]求公共后缀字串
            while (j >= 0 && b[j] == b[m-1-k]) {
                --j;
                ++k;
                // j+1 表示公共后缀子串在b[0, i]中的起始下标
                suffix[k] = j + 1;
            }
            // 如果公共后缀子串也是模式串的前缀子串
            if (j == -1) {
                prefix[k] = true;
            }
        }
    }

    /**
     *
     * @param a 主串
     * @param n 主串长度
     * @param b 模式串
     * @param m 模式串长度
     * @return 第一次匹配上的位置
     */
    public int bm(char[] a, int n, char[] b, int m) {
        // 存储模式串中每个字符的位置
        int[] bc = new int[SIZE];
        generateBC(b, m, bc);
        // 循环比对, 直到i + m = n
        int i = 0;
        while (i <= n - m) {
            // 模式串倒序匹配
            int j;
            for (j = m - 1; j >= 0; j--) {
                // 坏字符在模式串中的位置为j
                if (a[i + j] != b[j]) {
                    break;
                }

            }
            // 匹配成功, 返回主串中和模式串相匹配的第一个字符的下标
            if (j < 0) {
                return i;
            }
            i = i + j - bc[a[i + j]];
        }
        return -1;
    }

    /**
     *
     * @param j 坏字符对应的模式串中的字符下标
     * @param m 模式串长度
     */
    private int moveByGS(int j, int m, int[] suffix, boolean[] prefix) {
        // 好后缀长度(好后缀起始位置的前一位一定是坏字符)
        int k = m - 1 - j;
        // 如果存在多个, 这个好后缀肯定是靠后的位置的下标(查看generateGS代码得出)
        if (suffix[k] != -1) {
            return j - suffix[k] + 1;
        }
        // j+1是好后缀，j+2是好后缀的后缀子串的起始(避免出现过渡移动导致错失匹配的情况)
        for (int r = j+2; r <= m - 1 ; r++) {
            if (prefix[m - r]) {
                return r;
            }
        }
        return m;
    }

}
