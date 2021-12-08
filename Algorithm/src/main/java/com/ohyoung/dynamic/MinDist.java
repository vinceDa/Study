package com.ohyoung.dynamic;

/**
 * 假设我们有一个 n 乘以 n 的矩阵 w[n][n]。矩阵存储的都是正整数。
 * 棋子起始位置在左上角, 终止位置在右下角。我们将棋子从左上角移动到右下角。
 * 每次只能向右或者向下移动一位。从左上角到右下角, 会有很多不同的路径可以走。
 * 我们把每条路径经过的数字加起来看作路径的长度。
 * 那从左上角移动到右下角的最短路径长度是多少呢？
 *
 * @author ohYoung
 * @date 2021/12/8 22:53
 */
public class MinDist {

    /**
     * 状态转移表法
     */
    public int minDist(int[][] matrix, int n) {
        int[][] states = new int[n][n];
        int sum = 0;
        // 初始化states第一行的数据
        for (int i = 0; i < n; i++) {
            sum += matrix[0][i];
            states[0][i] = sum;
        }
        sum = 0;
        // 初始化states第一列的数据
        for (int i = 0; i < n; i++) {
            sum += matrix[i][0];
            states[i][0] = sum;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                // 当前states的状态由上一个states的状态决定
                states[i][j] = matrix[i][j] + Math.min(states[i][j - 1], matrix[i - 1][j]);
            }
        }
        return states[n - 1][n - 1];
    }


    private final int[][] matrix =
            {{1, 3, 5, 9}, {2, 1, 3, 4}, {5, 2, 6, 7}, {6, 8, 4, 3}};
    private final int n = 4;
    private final int[][] mem = new int[4][4];

    /**
     * 状态转移方程法: 递归+备忘录
     * 调用minDist(n-1, n-1);
     * @param i 第i行
     * @param j 第j列
     */
    public int minDist(int i, int j) {
        if (i == 0 && j == 0) {
            return matrix[0][0];
        }
        if (mem[i][j] > 0) {
            return mem[i][j];
        }
        int minLeft = Integer.MAX_VALUE;
        if (j - 1 >= 0) {
            minLeft = minDist(i, j - 1);
        }
        int minUp = Integer.MAX_VALUE;
        if (i - 1 >= 0) {
            minUp = minDist(i - 1, j);
        }
        int currMinDist = matrix[i][j] + Math.min(minLeft, minUp);
        mem[i][j] = currMinDist;
        return currMinDist;
    }

}
