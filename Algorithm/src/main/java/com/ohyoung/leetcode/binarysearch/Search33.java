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
        nums = new int[]{3, 1};
        System.out.println(example.search(nums, 1));
        nums = new int[]{5, 1, 3};
        System.out.println(example.search(nums, 5));
        nums = new int[]{3, 4, 5, 6, 1, 2};
        System.out.println(example.search(nums, 2));
        nums = new int[]{4, 5, 6, 7, 8, 1, 2, 3};
        System.out.println(example.search(nums, 8));
    }


    public int search(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return -1;
        }

        if (length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int low = 0;
        int high = length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 判断mid的位置是处于翻转前还是翻转后
            if (nums[0] <= nums[mid]) {
                // mid处于翻转前
                if (nums[0] <= target && target < nums[mid]) {
                    // target在mid左侧
                    high = mid - 1;
                } else {
                    // target在mid右侧
                    low = mid + 1;
                }
            } else {
                // mid处于翻转后
                if (nums[mid] < target && target <= nums[length - 1]) {
                    // target在mid右侧
                    low = mid + 1;
                } else {
                    // target在mid左侧
                    high = mid - 1;
                }
            }

        }
        return -1;
    }

}
