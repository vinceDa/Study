package com.ohyoung.leetcode.array;

import java.util.List;

/**
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[]
 * @author ouyb01
 * @date 2021/12/27 12:49
 */
public class ThreeSum15 {

    public List<List<Integer>> threeSum(int[] nums) {
        return null;
    }

    public static void main(String[] args) {
        ThreeSum15 example = new ThreeSum15();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(example.threeSum(nums).toString());
        nums = new int[]{};
        System.out.println(example.threeSum(nums).toString());
        nums = new int[]{0};
        System.out.println(example.threeSum(nums).toString());
    }

}