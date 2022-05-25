package com.ohyoung.leetcode.programming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 * <p>
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 *
 * @author ohYoung
 * @date 2021/9/25 11:09
 */
public class TwoSum1 {

    public static void main(String[] args) {
        TwoSum1 example = new TwoSum1();
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println("twoSum: " + Arrays.toString(example.twoSum(nums, target)));
        System.out.println("twoSum2: " + Arrays.toString(example.twoSum2(nums, target)));
        nums = new int[]{3, 2, 4};
        target = 6;
        System.out.println("twoSum: " + Arrays.toString(example.twoSum(nums, target)));
        System.out.println("twoSum2: " + Arrays.toString(example.twoSum2(nums, target)));
        nums = new int[]{3, 3};
        System.out.println("twoSum: " + Arrays.toString(example.twoSum(nums, target)));
        System.out.println("twoSum2: " + Arrays.toString(example.twoSum2(nums, target)));
    }

    /**
     * 以值为key, 下标为value使用哈希表存储, 如果存在target-nums[i]的key则说明该key和当前for循环的下标i可以组成符合题意的结果
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashTable = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashTable.containsKey(target - nums[i])) {
                return new int[]{hashTable.get(target - nums[i]), i};
            }
            hashTable.put(nums[i], i);
        }
        return new int[0];
    }


    /**
     * 2022/05/25: 暴力枚举编程
     */
    public int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }


}
