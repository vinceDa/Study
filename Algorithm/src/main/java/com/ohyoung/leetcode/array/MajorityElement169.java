package com.ohyoung.leetcode.array;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 示例1：
 * 输入：[3,2,3]
 * 输出：3
 *
 * 示例2：
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 * @author ouyb01
 * @date 2021/12/27 12:59
 */
public class MajorityElement169 {

    /**
     * 如果数 a 是数组 nums 的众数，如果我们将 nums 分成两部分，那么 a 必定是至少一部分的众数
     */
    public int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }


    private int majorityElementRec(int[] nums, int s, int e) {
        // 如果开始和结束下标重合, 直接返回
        if (s == e) {
            return nums[s];
        }
        int mid = (e - s) / 2 + s;
        int left = majorityElementRec(nums, s, mid);
        int right = majorityElementRec(nums, mid + 1, e);

        if (left == right) {
            return left;
        }
        // 如果不相等则计算看那边的数量多
        int leftCount = countInRange(nums, left, s, e);
        int rightCount = countInRange(nums, right, s, e);
        return leftCount > rightCount ? left : right;
    }

    private int countInRange(int[] nums, int num, int s, int e) {
        int count = 0;
        for (int i = s; i <= e; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MajorityElement169 example = new MajorityElement169();
        int[] nums = new int[]{3, 2, 3};
        System.out.println(example.majorityElement(nums));
        nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println(example.majorityElement(nums));
    }

}
