package com.ohyoung.leetcode;

import java.util.Arrays;

/**
 * 给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。
 *
 * 子数组 定义为原数组中的一个连续子序列。
 *
 * 请你返回 arr 中 所有奇数长度子数组的和 。
 *
 * 示例 1：
 *
 * 输入：arr = [1,4,2,5,3]
 * 输出：58
 * 解释：所有奇数长度子数组和它们的和为：
 * [1] = 1
 * [4] = 4
 * [2] = 2
 * [5] = 5
 * [3] = 3
 * [1,4,2] = 7
 * [4,2,5] = 11
 * [2,5,3] = 10
 * [1,4,2,5,3] = 15
 * 我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 *
 * 示例 2：
 *
 * 输入：arr = [1,2]
 * 输出：3
 * 解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。
 *
 * @author ohYoung
 * @date 2021/8/29 9:37
 */
public class SumOddLengthSubarrays1588 {

    public static void main(String[] args) {
        SumOddLengthSubarrays1588 example = new SumOddLengthSubarrays1588();
        int[] arr = new int[]{1, 4, 2, 5, 3};
        System.out.println(example.sumOddLengthSubarrays(arr));
        arr = new int[]{3};
        System.out.println(example.sumOddLengthSubarrays(arr));
        arr = new int[]{1, 2};
        System.out.println(example.sumOddLengthSubarrays(arr));
        arr = new int[]{10, 11, 12};
        System.out.println(example.sumOddLengthSubarrays(arr));

        System.out.println("=========================");

        arr = new int[]{1, 4, 2, 5, 3};
        System.out.println(example.sumOddLengthSubarrays_2(arr));
        arr = new int[]{3};
        System.out.println(example.sumOddLengthSubarrays_2(arr));
        arr = new int[]{1, 2};
        System.out.println(example.sumOddLengthSubarrays_2(arr));
        arr = new int[]{10, 11, 12};
        System.out.println(example.sumOddLengthSubarrays_2(arr));
    }

    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        for (int i = 1; i <= arr.length; i++) {
            // i表示当前奇数子数组的长度
            if (i % 2 == 0) {
                continue;
            }
            for (int j = 0; j < arr.length - i + 1; j++) {
                int m = j;
                int count = 0;
                while (count < i) {
                    sum += arr[m];
                    m++;
                    count++;
                }
            }
        }
        return sum;
    }

    /**
     * 利用前缀和将每个长度的前缀的和先存储起来，相较于第一种方式时间复杂度降低到O(n^2)
     */
    public int sumOddLengthSubarrays_2(int[] arr) {
        int[] sum = new int[arr.length + 1];
        for (int i = 1; i <= arr.length; i++) {
            sum[i] = sum[i - 1] + arr[i - 1];
        }
        int res = 0;
        for (int i = 1; i <= arr.length; i = i + 2) {
            for (int l = 0; l < arr.length - i + 1; l++) {
                res += sum[i+l] - sum[l];
            }
        }
        return res;
    }

}
