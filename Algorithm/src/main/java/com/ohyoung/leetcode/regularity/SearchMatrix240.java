package com.ohyoung.leetcode.regularity;

import java.util.List;

/**
 * 编写一个高效的算法来搜索mxn矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 * 示例 1：
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 *
 * 示例 2：
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * 输出：false
 *
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -109<= matrix[i][j] <= 109
 * 每行的所有元素从左到右升序排列
 * 每列的所有元素从上到下升序排列
 * -109<= target <= 109
 *
 * @author ouyb01
 * @date 2022/6/1 14:55
 */
public class SearchMatrix240 {

    public static void main(String[] args) {
        SearchMatrix240 example = new SearchMatrix240();
        int[][] matrix = new int[5][5];
        matrix[0][0] = 1;
        matrix[0][1] = 4;
        matrix[0][2] = 7;
        matrix[0][3] = 11;
        matrix[0][4] = 15;
        matrix[1][0] = 2;
        matrix[1][1] = 5;
        matrix[1][2] = 8;
        matrix[1][3] = 12;
        matrix[1][4] = 19;
        matrix[2][0] = 3;
        matrix[2][1] = 6;
        matrix[2][2] = 9;
        matrix[2][3] = 16;
        matrix[2][4] = 22;
        matrix[3][0] = 10;
        matrix[3][1] = 13;
        matrix[3][2] = 14;
        matrix[3][3] = 17;
        matrix[3][4] = 24;
        matrix[4][0] = 18;
        matrix[4][1] = 21;
        matrix[4][2] = 23;
        matrix[4][3] = 26;
        matrix[4][4] = 30;
        System.out.println(example.searchMatrix(matrix, 5));
        System.out.println(example.searchMatrix(matrix, 20));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        return true;
    }


}
