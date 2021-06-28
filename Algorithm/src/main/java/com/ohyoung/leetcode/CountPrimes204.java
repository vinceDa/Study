package com.ohyoung.leetcode;

import java.util.Arrays;

/**
 *  统计所有小于非负整数 n 的质数的数量。
 *  示例 1：
 *      输入：n = 10
 *      输出：4
 *      解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * @author ohYoung
 * @date 2020/12/3 23:06
 */
public class CountPrimes204 {

    public static void main(String[] args) {

    }

    public static int countPrimes(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            // 2肯定是质数
            if (isPrime[i] == 1) {
                ans += 1;
                if ((long) i * i < n) {
                    // 假设i是质数, 那么2i、3i....肯定不是质数
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return ans;
    }

}
