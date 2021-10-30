package com.ohyoung.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个整数数组nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 * <p>
 * 进阶：你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,1,3,2,5]
 * 输出：[3,5]
 * 解释：[5, 3] 也是有效的答案。
 * 示例 2：
 * <p>
 * 输入：nums = [-1,0]
 * 输出：[-1,0]
 * 示例 3：
 * <p>
 * 输入：nums = [0,1]
 * 输出：[1,0]
 * 提示：
 * <p>
 * 2 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * 除两个只出现一次的整数外，nums 中的其他数字都出现两次
 */
public class SingleNumber260 {
    public static void main(String[] args) {
        SingleNumber260 example = new SingleNumber260();
        int[] nums = new int[]{1,2,1,3,2,5};
        System.out.println(Arrays.toString(example.singleNumber(nums)));
        nums = new int[]{-1,0};
        System.out.println(Arrays.toString(example.singleNumber(nums)));
        nums = new int[]{0,1};
        System.out.println(Arrays.toString(example.singleNumber(nums)));
    }

    public int[] singleNumber(int[] nums) {
        int[] res = new int[]{-1, -1};
        Map<Integer, Integer> storage = new HashMap<>();
        for (int num : nums) {
            if (storage.containsKey(num)) {
                storage.put(num, storage.get(num) + 1);
            } else {
                storage.put(num, 1);
            }
        }
        Set<Integer> keys = storage.keySet();
        for (Integer key : keys) {
            if (storage.get(key) == 1) {
                if (res[0] == -1) {
                    res[0] = key;
                    continue;
                }
                if (res[1] == -1) {
                    res[1] = key;
                    break;
                }
            }
        }
        return res;
    }
}
