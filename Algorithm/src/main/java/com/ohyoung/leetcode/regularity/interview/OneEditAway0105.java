package com.ohyoung.leetcode.regularity.interview;

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
        System.out.println(example.oneEditAway("pal", "aal"));
        System.out.println(example.oneEditAway("teacher", "attacher"));
    }

    public boolean oneEditAway(String first, String second) {
        if (first == null || second == null) {
            return false;
        }
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }
        int diff = 0;
        if (first.length() == second.length()) {
            for (int i = 0; i < first.length(); i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    diff++;
                }
                if (diff > 1) {
                    return false;
                }
            }
            return true;
        }
        if (first.length() > second.length()) {
            String tmp = first;
            first = second;
            second = tmp;
        }
        int i = 0;
        int j = 0;
        while (i < first.length()) {
            if (first.charAt(i) != second.charAt(j)) {
                diff++;
            } else {
                i++;
            }
            j++;
            if (diff > 1) {
                return false;
            }
        }
        return true;
    }

}
