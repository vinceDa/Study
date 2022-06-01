package com.ohyoung.leetcode.regularity.interviews;

/**
 * 字符串有三种编辑操作:插入一个英文字符、删除一个英文字符或者替换一个英文字符。
 * 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 *
 * 示例1:
 * 输入: 
 * first = "pale"
 * second = "ple"
 * 输出: True
 *
 * 示例2:
 * 输入: 
 * first = "pales"
 * second = "pal"
 * 输出: False
 *
 * @author ouyb01
 * @date 2022/6/1 14:44
 */
public class OneEditAway0105 {

    public static void main(String[] args) {
        OneEditAway0105 example = new OneEditAway0105();
        System.out.println(example.oneEditAway("pale", "ple"));
        System.out.println(example.oneEditAway("pales", "pal"));
    }

    public boolean oneEditAway(String first, String second) {
        return true;
    }

}
