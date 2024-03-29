package com.ohyoung.leetcode.regularity.interview;

import java.util.Arrays;

/**
 * 珠玑妙算游戏（the game of master mind）的玩法如下。
 * 计算机有4个槽，每个槽放一个球，颜色可能是红色（R）、黄色（Y）、绿色（G）或蓝色（B）。例如，计算机可能有RGGB 4种（槽1为红色，槽2、3为绿色，槽4为蓝色）。
 * 作为用户，你试图猜出颜色组合。打个比方，你可能会猜YRGB。要是猜对某个槽的颜色，则算一次“猜中”；要是只猜对颜色但槽位猜错了，则算一次“伪猜中”。
 * 注意，“猜中”不能算入“伪猜中”。给定一种颜色组合solution和一个猜测guess，
 * 编写一个方法，返回猜中和伪猜中的次数answer，其中answer[0]为猜中的次数，answer[1]为伪猜中的次数。
 *
 * 示例：
 * 输入： solution="RGBY",guess="GGRR"
 * 输出： [1,1]
 * 解释： 猜中1次，伪猜中1次。
 *
 * 提示：
 * len(solution) = len(guess) = 4
 * solution和guess仅包含"R","G","B","Y"这4种字符
 *
 * @author ouyb01
 * @date 2022/6/1 14:46
 */
public class MasterMind1615 {

    public static void main(String[] args) {
        MasterMind1615 example = new MasterMind1615();
        System.out.println(Arrays.toString(example.masterMind("BRBB", "RBGY")));
        System.out.println(Arrays.toString(example.masterMind("BGBG", "RGBR")));
        System.out.println(Arrays.toString(example.masterMind("BRBB","RBGY")));
        System.out.println(Arrays.toString(example.masterMind("RGBY", "GGRR")));
        System.out.println(Arrays.toString(example.masterMind("RGRB", "BBBY")));
    }

    public int[] masterMind(String solution, String guess) {
        char[] solutions = solution.toCharArray();
        char[] guesses = guess.toCharArray();
        int[] answer = new int[2];
        for (int i = 0; i < solutions.length; i++) {
            if (solutions[i] == guesses[i]) {
                solutions[i] = ' ';
                guesses[i] = ' ';
                answer[0]++;
            }
        }
        for (int i = 0; i < guesses.length; i++) {
            if (guesses[i] != ' ') {
                for (int j = 0; j < solutions.length; j++) {
                    if (guesses[i] == solutions[j]) {
                        guesses[i] = ' ';
                        solutions[j] = ' ';
                        answer[1]++;
                        break;
                    }
                }
            }
        }
        return answer;
    }
}
