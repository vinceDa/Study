package com.ohyoung.leetcode.sort.offer;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 * <p>
 * 示例：
 * 输入：nums =[1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 * <p>
 * 提示：
 * 0 <= nums.length <= 50000
 * 0 <= nums[i] <= 10000
 * <p>
 * 链接：<a href="https://leetcode.cn/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof">...</a>
 *
 * @author ouyb01
 * @date 2022/9/8 9:34
 */
public class Exchange21 {

    public static void main(String[] args) {
        Exchange21 example = new Exchange21();
        System.out.println(Arrays.toString(example.exchange(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(example.exchange(new int[]{1, 2, 3, 7})));
        System.out.println(Arrays.toString(example.exchange(new int[]{1, 3, 12, 7, 8})));
        System.out.println(Arrays.toString(example.exchange(new int[]{1, 3, 5})));
    }

    public int[] exchange(int[] nums) {
        if (nums.length == 0) {
            return new int[]{};
        }
        int index = 0;
        int start = 0;
        int end = nums.length - 1;
        for (int i = start; i <= end; i++) {
            if (nums[i] % 2 != 0) {
                int tmp = nums[i];
                nums[i] = nums[index];
                nums[index++] = tmp;
            }
        }
        if (index < nums.length) {
            int tmp = nums[end];
            nums[end] = nums[index];
            nums[index] = tmp;
        }
        return nums;
    }

}
