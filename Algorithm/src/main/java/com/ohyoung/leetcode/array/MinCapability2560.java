package com.ohyoung.leetcode.array;

import java.util.Arrays;

/**
 * 2560. 打家劫舍 IV
 *
 * 沿街有一排连续的房屋。每间房屋内都藏有一定的现金。现在有一位小偷计划从这些房屋中窃取现金。
 * 由于相邻的房屋装有相互连通的防盗系统，所以小偷 不会窃取相邻的房屋 。
 * 小偷的 窃取能力 定义为他在窃取过程中能从单间房屋中窃取的 最大金额 。
 * 给你一个整数数组 nums 表示每间房屋存放的现金金额。形式上，从左起第 i 间房屋中放有 nums[i] 美元。
 * 另给你一个整数 k ，表示窃贼将会窃取的 最少 房屋数。小偷总能窃取至少 k 间房屋。
 * 返回小偷的 最小 窃取能力。
 *
 * 示例 1：
 * 输入：nums = [2,3,5,9], k = 2
 * 输出：5
 * 解释：
 * 小偷窃取至少 2 间房屋，共有 3 种方式：
 * - 窃取下标 0 和 2 处的房屋，窃取能力为 max(nums[0], nums[2]) = 5 。
 * - 窃取下标 0 和 3 处的房屋，窃取能力为 max(nums[0], nums[3]) = 9 。
 * - 窃取下标 1 和 3 处的房屋，窃取能力为 max(nums[1], nums[3]) = 9 。
 * 因此，返回 min(5, 9, 9) = 5 。
 *
 * 示例 2：
 * 输入：nums = [2,7,9,3,1], k = 2
 * 输出：2
 * 解释：共有 7 种窃取方式。窃取能力最小的情况所对应的方式是窃取下标 0 和 4 处的房屋。返回 max(nums[0], nums[4]) = 2 。
 *
 *
 * 提示：
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 * 1 <= k <= (nums.length + 1)/2
 *
 * <a href="https://leetcode-cn.com/problems/house-robber-iv/">2560. 打家劫舍 IV</a>
 * @author vince 2023/9/19 09:08
 */
public class MinCapability2560 {

    public static void main(String[] args) {
        MinCapability2560 minCapability2560 = new MinCapability2560();
        int[] nums = new int[]{2, 3, 5, 9};
        int k = 2;
        System.out.println(minCapability2560.minCapability(nums, k));

        nums = new int[]{2, 7, 9, 3, 1};
        System.out.println(minCapability2560.minCapability(nums, k));
    }

    public int minCapability(int[] nums, int k) {
        int lower = Arrays.stream(nums).min().getAsInt();
        int upper = Arrays.stream(nums).max().getAsInt();
        while (lower <= upper) {
            int middle = (upper - lower) / 2 + lower;
            int count = 0;
            boolean visited = false;
            for (int num : nums) {
                if (num <= middle && !visited) {
                    count++;
                    visited = true;
                } else {
                    visited = false;
                }
            }

            if (count >= k) {
                upper = middle - 1;
            } else {
                lower = middle + 1;
            }
        }
        return lower;
    }

}
