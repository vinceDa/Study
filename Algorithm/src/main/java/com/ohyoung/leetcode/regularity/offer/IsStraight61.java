package com.ohyoung.leetcode.regularity.offer;

/**
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，
 * 而大、小王为0，可以看成任意数字。A 不能视为 14。
 *
 * 示例1:
 * 输入: [1,2,3,4,5]
 * 输出: True
 *
 * 示例2:
 * 输入: [0,0,1,2,5]
 * 输出: True
 *
 * @author ouyb01
 * @date 2022/6/1 14:40
 */
public class IsStraight61 {

    public static void main(String[] args) {
        IsStraight61 example = new IsStraight61();
        int[] nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(example.isStraight(nums));
        nums = new int[]{0, 0, 1, 2, 5};
        System.out.println(example.isStraight(nums));
    }

    public boolean isStraight(int[] nums) {
        return true;
    }

}
