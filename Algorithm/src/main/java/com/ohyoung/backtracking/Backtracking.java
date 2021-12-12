package com.ohyoung.backtracking;

/**
 * 回溯算法：八皇后
 * @author ouyb01
 * @date 2021/12/2 9:43
 */
public class Backtracking {

    // 下标表示行, 值表示queen存储在哪一列
    int[] result = new int[8];

    public void cal8queens(int row) {
        // 8个棋子都放置好了, 打印结果
        if (row == 8) {
            printQueens(result);
            return;
        }
        // 每一行都有8种放法
        for (int column = 0; column < 8; column++) {
            // 如果放法符合要求
            if (isOk(row, column)) {
                result[row] = column;
                cal8queens(row+1);
            }
        }
    }

    /**
     * 判断row行column列放置是否合适
     */
    private boolean isOk(int row, int column) {
        int leftUp = column - 1, rightUp = column + 1;
        // 逐行往上考察每一行
        for (int i = row - 1; i >= 0; i--) {
            // 第i行的column列是否有棋子
            if (result[i] == column) {
                return false;
            }
            // 第i行的leftUp列(左上角对角线)是否有棋子
            if (leftUp >= 0 && result[i] == leftUp) {
                return false;
            }
            // 第i行的rightUp列(右上角对角线)是否有棋子
            if (rightUp < 8 && result[i] == rightUp) {
                return false;
            }
            leftUp--;
            rightUp++;
        }
        return true;
    }


    /**
     * 打印一个二维矩阵
     */
    private void printQueens(int[] result) {
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                if (result[row] == column) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Backtracking example = new Backtracking();
        example.cal8queens(0);
    }
}
