package com.ohyoung.leetcode.regularity;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 *
 * @author ouyb01
 * @date 2022/6/1 14:55
 */
public class SpiralOrder54_ {

    public static void main(String[] args) {
        SpiralOrder54_ example = new SpiralOrder54_();
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
        System.out.println(example.spiralOrder(matrix).toString());
        matrix = new int[4][3];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[0][3] = 4;
        matrix[1][0] = 5;
        matrix[1][1] = 6;
        matrix[1][2] = 7;
        matrix[1][3] = 8;
        matrix[2][0] = 9;
        matrix[2][1] = 10;
        matrix[2][2] = 11;
        matrix[2][3] = 12;
        System.out.println(example.spiralOrder(matrix).toString());
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null) {
            return new ArrayList<>();
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (rows == 0 || cols == 0) {
            return new ArrayList<>();
        }
        int total = rows * cols;
        List<Integer> res = new ArrayList<>(total);
        int row = 0;
        int col = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directIndex = 0;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < total; i++) {
            res.add(matrix[row][col]);
            visited[row][col] = true;
            int nextRow = row + directions[directIndex][0];
            int nextCol = col + directions[directIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextCol >= cols || visited[nextRow][nextCol]) {
                directIndex = (directIndex + 1) % 4;
            }
            row += directions[directIndex][0];
            col += directions[directIndex][1];
        }
        return res;
    }

}
