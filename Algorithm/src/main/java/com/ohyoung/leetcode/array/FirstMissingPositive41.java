package com.ohyoung.leetcode.array;

/**
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * 
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,0]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 示例 3：
 *
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 * @author ouyb01
 * @date 2021/12/27 13:00
 */
public class FirstMissingPositive41 {

    public int firstMissingPositive(int[] nums) {
        // 极端情况N位数的数组[1,...N], 这时候未出现的正整数是N+1
        // 遍历数组, 得到的数设为x, 如果x∈[1,N], 那么将数组下标为x的值做个标记, 如果都有标记, 则是上述说的极端情况, 否则是没有标记的值所在的下标+1
        // 用负号当标记, 已标记的不重复标记

        // 1. 数组中的负数赋值为N+1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = nums.length + 1;
            }
        }
        // 2. 判断x∈[1,N], 是则添加标记
        for (int i = 0; i < nums.length; i++) {
            // 有可能当前值已经被标记, 所以此处取绝对值
            int index = Math.abs(nums[i]);
            if (index >= 1 && index <= nums.length) {
                // 已经被标记不能被重复标记, 所以取绝对值
                nums[index-1] = -Math.abs(nums[index-1]);
            }
        }
        // 3. 如果全有标记则最小值为N+1, 否则为第一个没有标记的下标+1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i+1;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        FirstMissingPositive41 example = new FirstMissingPositive41();

    }

}
