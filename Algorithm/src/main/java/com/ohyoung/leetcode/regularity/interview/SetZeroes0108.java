package com.ohyoung.leetcode.regularity.interview;

import java.util.Arrays;

/**
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 *
 * 示例 1：
 * 输入：
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出：
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 *
 * 示例 2：
 * 输入：
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出：
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 * @author ouyb01
 * @date 2022/6/1 14:23
 */
public class SetZeroes0108 {

    public static void main(String[] args) {
        SetZeroes0108 example = new SetZeroes0108();
        int[][] matrix = new int[3][3];
        matrix[0][0] = 1;
        matrix[0][1] = 1;
        matrix[0][2] = 1;
        matrix[1][0] = 1;
        matrix[1][1] = 0;
        matrix[1][2] = 1;
        matrix[2][0] = 1;
        matrix[2][1] = 1;
        matrix[2][2] = 1;
        example.setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
        matrix = new int[3][4];
        matrix[0][0] = 0;
        matrix[0][1] = 1;
        matrix[0][2] = 2;
        matrix[0][3] = 0;
        matrix[1][0] = 3;
        matrix[1][1] = 4;
        matrix[1][2] = 5;
        matrix[1][3] = 2;
        matrix[2][0] = 1;
        matrix[2][1] = 3;
        matrix[2][2] = 1;
        matrix[2][3] = 5;
        example.setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] index = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!index[i][j] && matrix[i][j] == 0) {
                    int i1 = 0;
                    int j1 = 0;
                    while (i1 < m) {
                        // 本身是0的项需要再走一遍这个流程
                        if (matrix[i1][j] != 0) {
                            matrix[i1][j] = 0;
                            index[i1][j] = true;
                        }
                        i1++;
                    }
                    while (j1 < n) {
                        if (matrix[i][j1] != 0) {
                            matrix[i][j1] = 0;
                            index[i][j1] = true;
                        }
                        j1++;
                    }
                }
            }
        }
    }

}
