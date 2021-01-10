package com.ohyoung.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * 给定一个无重复元素的有序整数数组 nums 。
 *
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 *
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 *
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 *  示例1:
 *      输入：nums = [0,1,2,4,5,7]
 *      输出：["0->2","4->5","7"]
 *      解释：区间范围是：
 *          [0,2] --> "0->2"
 *          [4,5] --> "4->5"
 *          [7,7] --> "7"
 *
 *  示例 2：
 *      输入：nums = [0,2,3,4,6,8,9]
 *      输出：["0","2->4","6","8->9"]
 *      解释：区间范围是：
 *          [0,0] --> "0"
 *          [2,4] --> "2->4"
 *          [6,6] --> "6"
 *          [8,9] --> "8->9"
 * @author ohYoung
 * @date 2021/1/10 23:18
 */
public class SummaryRanges228 {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,4,5,7};
        System.out.println(summaryRanges(nums).toString());;
    }

    private static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int start = 0;
        int end = 0;
        while (end < nums.length) {
            if (end != nums.length - 1 && nums[end] + 1 == nums[end + 1]) {
                end++;
            } else {
                if (start == end) {
                    res.add(String.valueOf(nums[start]));
                } else {
                    res.add(nums[start] + "->" + nums[end]);
                }
                start = ++end;
            }
        }
        return res;
    }

}
