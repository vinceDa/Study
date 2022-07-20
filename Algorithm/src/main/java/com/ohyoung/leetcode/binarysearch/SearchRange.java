package com.ohyoung.leetcode.binarysearch;

import java.util.Arrays;

/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 *
 * 你必须设计并实现时间复杂度为O(log n)的算法解决此问题。
 *
 * 示例 1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 *
 * 示例2：
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 *
 * 示例 3：
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *
 * 提示：
 * 0 <= nums.length <= 105
 * -109<= nums[i]<= 109
 * nums是一个非递减数组
 * -109<= target<= 109
 *
 * 链接：<a href="https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array">...</a>
 * @author ouyb01
 * @date 2022/6/16 9:58
 */
public class SearchRange {

    public static void main(String[] args) {
        SearchRange example = new SearchRange();
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(example.searchRange(nums, 8)));
        nums = new int[]{5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(example.searchRange(nums, 6)));
        nums = new int[0];
        System.out.println(Arrays.toString(example.searchRange(nums, 0)));
        nums = new int[]{1};
        System.out.println(Arrays.toString(example.searchRange(nums, 1)));
    }

    /**
     * 二分法 + 左右探测法
     */
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[] { -1, -1 };
        int low = 0;
        int high = nums.length - 1;
        // 找相等的最小下标
        while (low <= high) {
            int mid = high - (high - low) / 2;
            if (nums[mid] == target) {
                // 向左探测一步, 如果和target不同则说明mid是最小下标
                if (mid == 0 || nums[mid - 1] != target) {
                    res[0] = mid;
                    break;
                } else {
                    high = mid - 1;
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        low = 0;
        high = nums.length - 1;
        // 找相等的最大下标
        while (low <= high) {
            int mid = high - (high - low) / 2;
            if (nums[mid] == target) {
                // 向右探测一步, 如果和target不同则说明mid是最大下标
                if (mid == nums.length - 1 || nums[mid + 1] != target) {
                    res[1] = mid;
                    break;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }
    

}
