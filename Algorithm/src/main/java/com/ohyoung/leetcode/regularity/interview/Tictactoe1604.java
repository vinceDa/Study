package com.ohyoung.leetcode.regularity.interview;

/**
 * 设计一个算法，判断玩家是否赢了井字游戏。输入是一个 N x N 的数组棋盘，由字符" "，"X"和"O"组成，其中字符" "代表一个空位。
 *
 * 以下是井字游戏的规则：
 *
 * 玩家轮流将字符放入空位（" "）中。
 * 第一个玩家总是放字符"O"，且第二个玩家总是放字符"X"。
 * "X"和"O"只允许放置在空位中，不允许对已放有字符的位置进行填充。
 * 当有N个相同（且非空）的字符填充任何行、列或对角线时，游戏结束，对应该字符的玩家获胜。
 * 当所有位置非空时，也算为游戏结束。
 * 如果游戏结束，玩家不允许再放置字符。
 * 如果游戏存在获胜者，就返回该游戏的获胜者使用的字符（"X"或"O"）；如果游戏以平局结束，则返回 "Draw"；如果仍会有行动（游戏未结束），则返回 "Pending"。
 *
 * 示例 1：
 * 输入： board = ["O X"," XO","X O"]
 * 输出： "X"
 *
 * 示例 2：
 * 输入： board = ["OOX","XXO","OXO"]
 * 输出： "Draw"
 * 解释： 没有玩家获胜且不存在空位
 *
 * 示例 3：
 * 输入： board = ["OOX","XXO","OX "]
 * 输出： "Pending"
 * 解释： 没有玩家获胜且仍存在空位
 * 提示：
 * 1 <= board.length == board[i].length <= 100
 * 输入一定遵循井字棋规则
 * @author ouyb01
 * @date 2022/6/1 14:50
 */
public class Tictactoe1604 {

    public static void main(String[] args) {
        Tictactoe1604 example = new Tictactoe1604();
        String[] board = new String[]{"O X", " XO", "X O"};
        System.out.println(example.tictactoe(board));
        board = new String[]{"OOX","XXO","OXO"};
        System.out.println(example.tictactoe(board));
        board = new String[]{"OOX","XXO","OX "};
        System.out.println(example.tictactoe(board));
    }


    public String tictactoe(String[] board) {
        int length = board.length;
        int horizontal;
        int vertical;
        int leftSlash = 0;
        int rightSlash = 0;
        boolean flag = false;
        for (int i = 0; i < board.length; i++) {
            // 存在三横三纵, 所以每次判断前要清空
            horizontal = 0;
            vertical = 0;
            for (int j = 0; j < board[i].length(); j++) {
                horizontal += board[i].charAt(j);
                vertical += board[j].charAt(i);
                if (board[i].charAt(j) == ' ') {
                    flag = true;
                }
            }
            if (horizontal == 'X' * length || vertical == 'X' * length) {
                return "X";
            }
            if (horizontal == 'O' * length || vertical == 'O' * length) {
                return "O";
            }
            leftSlash += board[i].charAt(i);
            rightSlash += board[i].charAt(length - i - 1);
        }
        if (leftSlash == 'X' * length || rightSlash == 'X' * length) {
            return "X";
        }
        if (leftSlash == 'O' * length || rightSlash == 'O' * length) {
            return "O";
        }
        if (flag) {
            return "Pending";
        }
        return "Draw";
    }


}
