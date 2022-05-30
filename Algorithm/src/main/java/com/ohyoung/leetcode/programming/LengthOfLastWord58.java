package com.ohyoung.leetcode.programming;

/**
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 *
 * 示例 1：
 * 输入：s = "Hello World"
 * 输出：5
 * 解释：最后一个单词是“World”，长度为5。
 *
 * 示例 2：
 * 输入：s = "   fly me   to   the moon  "
 * 输出：4
 * 解释：最后一个单词是“moon”，长度为4。
 *
 * 示例 3：
 * 输入：s = "luffy is still joyboy"
 * 输出：6
 * 解释：最后一个单词是长度为6的“joyboy”。
 *
 * 提示：
 * 1 <= s.length <= 104
 * s 仅有英文字母和空格 ' ' 组成
 * s 中至少存在一个单词
 * @author ohYoung
 * @date 2022/5/30 23:06
 */
public class LengthOfLastWord58 {

    public static void main(String[] args) {
        LengthOfLastWord58 example = new LengthOfLastWord58();
        System.out.println("LengthOfLastWord58 Hello World: " + example.lengthOfLastWord("Hello World"));
        System.out.println("LengthOfLastWord58    fly me   to   the moon  : " + example.lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println("LengthOfLastWord58 luffy is still joyboy: " + example.lengthOfLastWord("luffy is still joyboy"));
    }

    public int lengthOfLastWord(String s) {
        return 0;
    }

}
