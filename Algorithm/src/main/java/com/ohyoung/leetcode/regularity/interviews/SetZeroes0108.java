package com.ohyoung.leetcode.regularity.interviews;

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
        System.out.println(Arrays.toString(matrix));
        matrix = new int[4][3];
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
        System.out.println(Arrays.toString(matrix));
    }

    public void setZeroes(int[][] matrix) {

    }

}
