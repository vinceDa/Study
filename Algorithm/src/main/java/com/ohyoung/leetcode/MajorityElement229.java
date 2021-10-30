package com.ohyoung.leetcode;

import java.util.*;

/**
 * 给定一个大小为n的整数数组，找出其中所有出现超过[ n/3 ]次的元素。
 *
 * 示例1：
 *
 * 输入：[3,2,3]
 * 输出：[3]
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：[1]
 * 示例 3：
 *
 * 输入：[1,1,1,3,3,2,2,2]
 * 输出：[1,2]
 * 
 *
 * 提示：
 *  1 <= nums.length <= 5 * 10^4
 *  -109 <= nums[i] <= 109
 *
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题
 */
public class MajorityElement229 {

    public static void main(String[] args) {
        MajorityElement229 example = new MajorityElement229();
        int[] nums = new int[]{3,2,3};
        System.out.println(example.majorityElement(nums).toString());
        nums = new int[]{1};
        System.out.println(example.majorityElement(nums).toString());
        nums = new int[]{1,1,1,3,3,2,2,2};
        System.out.println(example.majorityElement(nums).toString());
    }

    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> storage = new HashMap<>();
        for (int num : nums) {
            if (storage.containsKey(num)) {
                storage.put(num, storage.get(num) + 1);
            } else {
                storage.put(num, 1);
            }
        }
        List<Integer> res = new ArrayList<>();
        Set<Integer> keys = storage.keySet();
        for (Integer key : keys) {
            if (storage.get(key) * 3 > nums.length) {
                res.add(key);
            }
        }
        return res;
    }
}
