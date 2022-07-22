package com.ohyoung.leetcode.regularity;

/**
 * 给定一个非负整数数组nums ，你最初位于数组的 第一个下标。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * <p>
 * 示例1：
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * <p>
 * 示例2：
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 * <p>
 * 提示：
 * 1 <= nums.length <= 3 * 104
 * 0 <= nums[i] <= 105
 *
 * @author ouyb01
 * @date 2022/6/1 14:52
 */
public class CanJump55 {

    public static void main(String[] args) {
        CanJump55 example = new CanJump55();
        int[] nums = new int[]{2, 3, 1, 1, 4};
        System.out.println(example.canJump(nums));
        nums = new int[]{3, 2, 1, 0, 4};
        System.out.println(example.canJump(nums));
    }

    public boolean canJump(int[] nums) {
        // 记录可达的最远位置
        int fast = 0;
        for (int i = 0; i < nums.length; i++) {
            // 最远位置内的所有下标都可到达, 循环范围内的下标, 获取当前下标可达的最远位置i + nums[i], 如果大于fast则替换
            if (fast >= i && i + nums[i] > fast) {
                fast = i + nums[i];
            }
            // 末尾可达
            if (fast >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
