package com.ohyoung.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 136. 只出现一次的数字
 * <p>
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 * <p>
 * 示例 1 ：
 * 输入：nums = [2,2,1]
 * 输出：1
 * <p>
 * 示例 2 ：
 * 输入：nums = [4,1,2,1,2]
 * 输出：4
 * <p>
 * 示例 3 ：
 * 输入：nums = [1]
 * 输出：1
 * <p>
 * 提示：
 * 1 <= nums.length <= 3 * 10^4
 * -3 * 10^4 <= nums[i] <= 3 * 10^4
 * 除了某个元素只出现一次以外，其余每个元素均出现两次。
 *
 * <a href="https://leetcode-cn.com/problems/single-number/"></a>
 *
 * @author vince 2023/8/21 11:46
 */
public class SingleNumber136 {

    public static void main(String[] args) {
        SingleNumber136 singleNumber136 = new SingleNumber136();
        System.out.println(singleNumber136.singleNumber(new int[]{2, 2, 1}));
        System.out.println(singleNumber136.singleNumber(new int[]{4, 1, 2, 1, 2}));
        System.out.println(singleNumber136.singleNumber(new int[]{1}));
    }

    /**
     * 做异或运算, 由于数据两两成对, 只存在一个单独的数字, a^a=0且异或运算满足交换律和结合律
     * 所以这题=a^a+b^b+...+z=z
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

}
