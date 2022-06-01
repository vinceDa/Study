package com.ohyoung.leetcode.regularity;

import java.util.Arrays;

/**
 * 给定一个 n×n 的二维矩阵matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 * 
 * 示例 2：
 * 输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 *
 * @author ouyb01
 * @date 2022/6/1 14:55
 */
public class Rotate48 {

    public static void main(String[] args) {
        Rotate48 example = new Rotate48();
        int[][] matrix = new int[3][3];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[1][0] = 4;
        matrix[1][1] = 5;
        matrix[1][2] = 6;
        matrix[2][0] = 7;
        matrix[2][1] = 8;
        matrix[2][2] = 9;
        example.rotate(matrix);
        matrix = new int[4][4];
        matrix[0][0] = 5;
        matrix[0][1] = 1;
        matrix[0][2] = 9;
        matrix[0][3] = 11;
        matrix[1][0] = 2;
        matrix[1][1] = 4;
        matrix[1][2] = 8;
        matrix[1][3] = 10;
        matrix[2][0] = 13;
        matrix[2][1] = 3;
        matrix[2][2] = 6;
        matrix[2][3] = 7;
        matrix[3][0] = 15;
        matrix[3][1] = 12;
        matrix[3][2] = 14;
        matrix[3][3] = 16;
        example.rotate(matrix);
    }

    public void rotate(int[][] matrix) {

    }

}
