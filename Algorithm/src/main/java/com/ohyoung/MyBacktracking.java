package com.ohyoung;

/**
 * 回溯算法：八皇后
 * @author ouyb01
 * @date 2021/12/2 9:43
 */
public class MyBacktracking {

    // 下标表示行, 值表示queen存储在哪一列
    int[] result = new int[8];

    public void cal8queens(int row) {
        // 8个棋子都放好了, 直接打印结果
        if (row == 8) {
            printQueens(result);
            return;
        }
        for (int column = 0; column < 8; column++) {
            if (isOk(row, column)) {
                // 符合要求, 将棋子放入对应位置, 开始下一轮的放置
                result[row] = column;
                cal8queens(row + 1);
            }
        }
    }

    /**
     * 判断row行column列放置是否合适
     */
    private boolean isOk(int row, int column) {
        int leftUp = column - 1, rightUp = column + 1;
        for (int i = row - 1; i >= 0; i--) {
            // 判断第i行的column列是否有棋子
            if (result[i] == column) {
                return false;
            }
            // result数组范围为0-7, 所以判断条件是>=0, <8
            // 判断第i行的左对角线是否有棋子
            if (leftUp >= 0 && result[i] == leftUp) {
                return false;
            }
            // 判断第i行的右对角线是否有棋子
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
        for (int row = 0; row < result.length; row++) {
            for (int column = 0; column < 8; column++) {
                if (result[row] == column) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        // 每次递归都会打印, 每次打印结果换行展示
        System.out.println();
    }

    public static void main(String[] args) {
        MyBacktracking example = new MyBacktracking();
        example.cal8queens(0);
    }
}
