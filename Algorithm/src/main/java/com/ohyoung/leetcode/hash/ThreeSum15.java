package com.ohyoung.leetcode.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * <p>
 * 示例 2：
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * <p>
 * 示例 3：
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 * <p>
 * <p>
 * 提示：
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 *
 * <a href="https://leetcode.cn/problems/3sum/"></a>
 *
 * @author vince 2023/8/21 10:00
 */
public class ThreeSum15 {

    public static void main(String[] args) {
        ThreeSum15 threeSum = new ThreeSum15();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4, -1, -1, -1, -1, -1, -1, -1, -1};
        System.out.println(threeSum.threeSum(nums));

        nums = new int[]{0, 1, 1};
        System.out.println(threeSum.threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 先对nums从小到大排序
        quickSort(nums, 0, nums.length - 1);
        // 从左到右遍历nums, 以当前元素为基准, 从当前元素的下一个元素开始, 从左到右遍历, 以当前元素为基准, 从当前元素的下一个元素开始, 从左到右遍历
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return res;
            }
            // 去除重复数据
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                // 如果三个元素之和为0, 则加入结果集
                if (nums[i] + nums[left] + nums[right] == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去除重复解
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right - 1] == nums[right]) {
                        right--;
                    }
                    left++;
                    right--;
                    // 如果三个元素之和大于0, 则右指针左移
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else {
                    // 如果三个元素之和小于0, 则左指针右移
                    left++;
                }
            }
        }
        return res;
    }

    /**
     * 使用快速排序将nums排序
     */
    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int partition = partition(nums, start, end);
        quickSort(nums, start, partition - 1);
        quickSort(nums, partition + 1, end);
    }

    private int partition(int[] nums, int start, int end) {
        int partition = nums[end];
        for (int i = start; i < end; i++) {
            if (nums[i] < partition) {
                int tmp = nums[i];
                nums[i] = nums[start];
                nums[start++] = tmp;
            }
        }
        // 将partition和中间位置元素调换位置, left < partition < right
        nums[end] = nums[start];
        nums[start] = partition;
        return start;
    }
}
