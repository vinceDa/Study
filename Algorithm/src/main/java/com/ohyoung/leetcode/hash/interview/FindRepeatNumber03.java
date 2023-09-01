package com.ohyoung.leetcode.hash.interview;

/**
 * 剑指 Offer 03. 数组中重复的数字
 * <p>
 * 找出数组中重复的数字。
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * <p>
 * 限制：
 * 2 <= n <= 100000
 *
 * <a href="https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/"></a>
 *
 * @author vince 2023/8/21 10:12
 */
public class FindRepeatNumber03 {

    public static void main(String[] args) {
        FindRepeatNumber03 findRepeatNumber03 = new FindRepeatNumber03();
        int[] nums = new int[]{2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber03.findRepeatNumber(nums));
        nums = new int[]{3, 4, 2, 1, 1, 0};
        System.out.println(findRepeatNumber03.findRepeatNumber(nums));
    }

    /**
     * 数组大小和元素大小在一个范围，可以通过在遍历过程中交换元素来判断是否存在重复
     */
    public int findRepeatNumber(int[] nums) {
        int i = 0;
        // 注意这里不能用fori, 因为只有nums[i] == i时才能往下走(确认当前索引没有重复值)
        while (i < nums.length) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[nums[i]] == nums[i]) {
                return nums[i];
            }
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }

}
