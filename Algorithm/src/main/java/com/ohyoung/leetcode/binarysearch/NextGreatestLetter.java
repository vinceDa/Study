package com.ohyoung.leetcode.binarysearch;

/**
 * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母target，请你寻找在这一有序列表里比目标字母大的最小字母。
 *
 * 在比较时，字母是依序循环出现的。举个例子：
 * 如果目标字母 target = 'z' 并且字符列表为letters = ['a', 'b']，则答案返回'a'
 *
 * 示例 1：
 * 输入: letters = ["c", "f", "j"]，target = "a"
 * 输出: "c"
 *
 * 示例 2:
 * 输入: letters = ["c","f","j"], target = "c"
 * 输出: "f"
 *
 * 示例 3:
 * 输入: letters = ["c","f","j"], target = "d"
 * 输出: "f"
 *
 * 提示：
 * 2 <= letters.length <= 104
 * letters[i]是一个小写字母
 * letters 按非递减顺序排序
 * letters 最少包含两个不同的字母
 * target 是一个小写字母
 *
 * 链接：<a href="https://leetcode.cn/problems/find-smallest-letter-greater-than-target">...</a>
 * @author ouyb01
 * @date 2022/6/14 9:22
 */
public class NextGreatestLetter {

    public static void main(String[] args) {
        NextGreatestLetter example = new NextGreatestLetter();
        char[] letters = new char[]{'a', 'b'};
        System.out.println(example.nextGreatestLetter(letters, 'z'));
        letters = new char[]{'c', 'f', 'j'};
        System.out.println(example.nextGreatestLetter(letters, 'a'));
        letters = new char[]{'c', 'f', 'j'};
        System.out.println(example.nextGreatestLetter(letters, 'c'));
        letters = new char[]{'c', 'f', 'j'};
        System.out.println(example.nextGreatestLetter(letters, 'd'));
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0;
        int high = letters.length - 1;
        while (low <= high) {
            int mid = high - (high - low) / 2;
            if (letters[mid] > target) {
                // 往前找一位, 如果前一位小于等于target则说明mid是第一个大于target的下标
                if (mid != 0 && letters[mid - 1] <= target) {
                    return letters[mid];
                } else {
                    // 不符合条件则说明查找范围应该在(low ~ mid-1)
                    high = mid - 1;
                }
            } else {
                // 如果mid的值小于等于target则说明查找范围应该在(mid+1 ~ high)
                low = mid + 1;
            }
        }
        return letters[0];
    }
    

}
