package com.ohyoung.leetcode.binarysearch;

/**
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 * <p>
 * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 * <p>
 * 你必须设计一个时间复杂度为O(log n) 的算法解决此问题。
 * <p>
 * 示例 1：
 * 输入：nums = [3,4,5,1,2]
 * 输出：1
 * 解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。
 * <p>
 * 示例 2：
 * 输入：nums = [4,5,6,7,0,1,2]
 * 输出：0
 * 解释：原数组为 [0,1,2,4,5,6,7] ，旋转 4 次得到输入数组。
 * <p>
 * 示例 3：
 * 输入：nums = [11,13,15,17]
 * 输出：11
 * 解释：原数组为 [11,13,15,17] ，旋转 4 次得到输入数组。
 * <p>
 * 提示：
 * n == nums.length
 * 1 <= n <= 5000
 * -5000 <= nums[i] <= 5000
 * nums 中的所有整数 互不相同
 * nums 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
 * <p>
 * 链接：<a href="https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array">...</a>
 *
 * @author ouyb01
 * @date 2022/6/14 9:28
 */
public class FindMin153 {

    public static void main(String[] args) {
        FindMin153 demo = new FindMin153();
        int[] nums = new int[]{2, 1};
        System.out.println(demo.findMin(nums));
        nums = new int[]{3, 4, 5, 1, 2};
        System.out.println(demo.findMin(nums));
        nums = new int[]{2, 3, 4, 5, 1};
        System.out.println(demo.findMin(nums));
        nums = new int[]{5, 1, 2, 3, 4};
        System.out.println(demo.findMin(nums));
        nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(demo.findMin(nums));
        nums = new int[]{11, 13, 15, 17};
        System.out.println(demo.findMin(nums));
    }

    /**
     * 二分查找, 关键点在于最小值肯定位于翻转后的数组的第一个元素
     */
    public int findMin(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return -1;
        }

        if (length == 1) {
            return nums[0];
        }

        int low = 0;
        int high = length - 1;
        int min = nums[low];
        if (nums[high] < min) {
            min = nums[high];
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < min) {
                min = nums[mid];
            }

            // 判断mid的位置是处于翻转前还是翻转后
            // mid处于翻转前
            if (nums[0] <= nums[mid]) {
                low = mid + 1;
                // mid处于翻转后
            } else {
                high = mid - 1;
            }
        }
        return min;
    }

}
