package com.ohyoung.leetcode.binarysearch;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 * 示例 1:
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * <p>
 * 示例2:
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * <p>
 * 示例 3:
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 * <p>
 * 提示:
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 为无重复元素的升序排列数组
 * -104 <= target <= 104
 * <p>
 * 链接：<a href="https://leetcode.cn/problems/search-insert-position">...</a>
 *
 * @author ouyb01
 * @date 2022/6/14 9:25
 */
public class SearchInsert {

    public static void main(String[] args) {
        SearchInsert example = new SearchInsert();
        int[] nums = new int[]{1, 3, 5, 6};
        System.out.println(example.searchInsert(nums, 5));
        nums = new int[]{1, 3, 5, 6};
        System.out.println(example.searchInsert(nums, 2));
        nums = new int[]{1, 3, 5, 6};
        System.out.println(example.searchInsert(nums, 7));
    }

    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = high - (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

}
