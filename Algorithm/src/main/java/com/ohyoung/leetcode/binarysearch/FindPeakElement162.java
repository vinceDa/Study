package com.ohyoung.leetcode.binarysearch;

/**
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * <p>
 * 给你一个整数数组nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * <p>
 * 你可以假设nums[-1] = nums[n] = -∞ 。
 * <p>
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3,1]
 * 输出：2
 * 解释：3 是峰值元素，你的函数应该返回其索引 2。
 * <p>
 * 示例2：
 * 输入：nums = [1,2,1,3,5,6,4]
 * 输出：1 或 5
 * 解释：你的函数可以返回索引 1，其峰值元素为 2；
 * 或者返回索引 5， 其峰值元素为 6。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * -231 <= nums[i] <= 231 - 1
 * 对于所有有效的 i 都有 nums[i] != nums[i + 1]
 * <p>
 * 链接：<a href="https://leetcode.cn/problems/find-peak-element">...</a>
 *
 * @author ouyb01
 * @date 2022/6/14 9:31
 */
public class FindPeakElement162 {

    public static void main(String[] args) {
        FindPeakElement162 demo = new FindPeakElement162();
        System.out.println(demo.findPeakElement(new int[]{1, 2, 3, 1}));
        System.out.println(demo.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
        System.out.println(demo.findPeakElement(new int[]{1}));
        System.out.println(demo.findPeakElement(new int[]{1, 2}));
        System.out.println(demo.findPeakElement(new int[]{1, 2, 3}));
        System.out.println(demo.findPeakElement(new int[]{3, 2, 1}));
    }

    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            // 临界数据处理
            if (mid == 0) {
                if (nums[mid] > nums[mid + 1]) {
                    return mid;
                } else {
                    start = mid + 1;
                    continue;
                }
            }

            if (mid == nums.length - 1) {
                if (nums[mid] > nums[mid - 1]) {
                    return mid;
                } else {
                    end = mid - 1;
                    continue;
                }
            }

            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            // 上坡必有坡顶, 所以如果num[mid + 1] > nums[mid], 则向右查找, 否则向左查找
            if (nums[mid + 1] > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return 0;
    }

}
