package com.ohyoung.leetcode.binarysearch;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为[4,5,6,7,0,1,2] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回-1。
 * <p>
 * 示例 1：
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * <p>
 * 示例2：
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * <p>
 * 示例 3：
 * 输入：nums = [1], target = 0
 * 输出：-1
 * <p>
 * 提示：
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * nums 中的每个值都 独一无二
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -10^4 <= target <= 10^4
 * <p>
 * 链接：<a href="https://leetcode.cn/problems/search-in-rotated-sorted-array">...</a>
 *
 * @author ouyb01
 * @date 2022/6/14 9:27
 */
public class Search33 {

    public static void main(String[] args) {
        Search33 example = new Search33();
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(example.search(nums, 0));
        nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(example.search(nums, 3));
        nums = new int[]{1};
        System.out.println(example.search(nums, 0));
        nums = new int[]{3, 5, 1};
        System.out.println(example.search(nums, 3));
    }

    /**
     * 二分法+左右探测
     */
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (mid == 0) {

            }
            if (nums[mid] < target) {
                // 说明数组在递增
                if ((mid != 0 && nums[mid] > nums[mid - 1]) || (mid != nums.length - 1 && nums[mid + 1] > nums[mid])) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                // 递减
                if ((mid != 0 && nums[mid] < nums[mid - 1]) || (mid != nums.length - 1 && nums[mid + 1] < nums[mid])) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

}
