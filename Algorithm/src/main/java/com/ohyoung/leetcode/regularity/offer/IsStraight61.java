package com.ohyoung.leetcode.regularity.offer;

/**
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，
 * 而大、小王为0，可以看成任意数字。A 不能视为 14。
 * <p>
 * 示例1:
 * 输入: [1,2,3,4,5]
 * 输出: True
 * <p>
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
        nums = new int[]{0, 0, 8, 5, 4};
        System.out.println(example.isStraight(nums));
        nums = new int[]{1, 2, 3, 2, 1};
        System.out.println(example.isStraight(nums));
        nums = new int[]{8, 7, 11, 0, 9};
        System.out.println(example.isStraight(nums));
    }

    public boolean isStraight(int[] nums) {
        int zeroNum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // 升序排序
                if (nums[i] > nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                zeroNum++;
                continue;
            }
            if (nums[i] == nums[i+1]) {
                return false;
            }
            if (nums[i] + 1 != nums[i + 1]) {
                zeroNum = zeroNum - (nums[i + 1] - nums[i] - 1);
            }
        }
        return zeroNum >= 0;
    }

}
