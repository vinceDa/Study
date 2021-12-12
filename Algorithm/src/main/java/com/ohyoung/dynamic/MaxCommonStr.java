package com.ohyoung.dynamic;

/**
 * 计算最长公共子串长度
 *思考过程
 * 	a[i]与 b[j]互相匹配
 * 		将最大公共子串长度加一，并且继续考察 a[i+1]和 b[j+1]
 * 	a[i]与 b[j]不匹配
 * 		删除 a[i]，或者在 b[j]前面加上一个字符 a[i]，然后继续考察 a[i+1]和 b[j]
 * 		删除 b[j]，或者在 a[i]前面加上一个字符 b[j]，然后继续考察 a[i]和 b[j+1]
 * 	穷举所有状态
 * 		(i-1, j-1, max_lcs)，其中 max_lcs 表示 a[0...i-1]和 b[0...j-1]的最长公共子串长度
 * 		(i-1, j, max_lcs)，其中 max_lcs 表示 a[0...i-1]和 b[0...j]的最长公共子串长度
 * 		(i, j-1, max_lcs)，其中 max_lcs 表示 a[0...i]和 b[0...j-1]的最长公共子串长度
 * @author ohYoung
 * @date 2021/12/8 22:53
 */
public class MaxCommonStr {

    /**
     * 状态转移表法
     * @param n 字符数组a的长度
     * @param m 字符数组b的长度
     */
    public int lcs(char[] a, int n, char[] b, int m) {
        int[][] maxlcs = new int[n][m];
        // 初始化第0行
        for (int i = 0; i < m; i++) {
            if (a[0] == b[i]) {
                maxlcs[0][i] = 1;
            } else if (i != 0) {
                maxlcs[0][i] = maxlcs[0][i - 1];
            } else {
                maxlcs[0][i] = 0;
            }
        }
        // 初始化第0列
        for (int i = 0; i < n; i++) {
            if (a[i] == b[0]) {
                maxlcs[i][0] = 1;
            } else if (i != 0) {
                maxlcs[i][0] = maxlcs[i - 1][0];
            } else {
                maxlcs[i][0] = 0;
            }
        }
        // 填表
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (a[i] == a[j]) {
                    // +1表示上一个状态和当前状态相等
                    maxlcs[i][j] = max(maxlcs[i - 1][j], maxlcs[i][j - 1], maxlcs[i - 1][j - 1] + 1);
                } else {
                    maxlcs[i][j] = max(maxlcs[i - 1][j], maxlcs[i][j - 1], maxlcs[i - 1][j - 1]);
                }
            }
        }
        return maxlcs[n - 1][m - 1];
    }

    private static int max(int x, int y, int z) {
        int max = Integer.MIN_VALUE;
        if (x > max) {
            max = x;
        }
        if (y > max) {
            max = y;
        }
        if (z > max) {
            max = z;
        }
        return max;
    }



}
