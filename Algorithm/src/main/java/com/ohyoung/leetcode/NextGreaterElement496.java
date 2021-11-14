package com.ohyoung.leetcode;

import java.util.Arrays;

/**
 * 给你两个 没有重复元素 的数组nums1 和nums2，其中nums1是nums2的子集。
 *
 * 请你找出 nums1中每个元素在nums2中的下一个比其大的值。
 *
 * nums1中数字x的下一个更大元素是指x在nums2中对应位置的右边的第一个比x大的元素。如果不存在，对应位置输出 -1 。
 *
 * 
 *
 * 示例 1:
 *
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 *     对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
 *     对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
 *     对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 * 示例 2:
 *
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出: [3,-1]
 * 解释:
 *    对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
 *     对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 * 
 *
 * 提示：
 *
 * 1 <= nums1.length <= nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 104
 * nums1和nums2中所有整数 互不相同
 * nums1 中的所有整数同样出现在 nums2 中
 *
 * @author ohYoung
 * @date 2021/10/12 22:30
 */
public class NextGreaterElement496 {

    public static void main(String[] args) {
        NextGreaterElement496 example = new NextGreaterElement496();
        int[] nums1 = new int[]{ 4, 1, 2 };
        int[] nums2 = new int[]{ 1,3,4,2 };
        System.out.println(Arrays.toString(example.nextGreaterElement(nums1, nums2)));
        nums1 = new int[]{ 2, 4 };
        nums2 = new int[]{ 1,2,3,4 };
        System.out.println(Arrays.toString(example.nextGreaterElement(nums1, nums2)));


    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        int max = Arrays.stream(nums2).max().getAsInt();
        int[] index = new int[max + 1];
        for (int i = 0; i < nums2.length; i++) {
            index[nums2[i]] = i;
        }
        for (int i = 0; i < nums1.length; i++) {
            for (int j = index[nums1[i]]; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    res[i] = nums2[j];
                    break;
                }
            }
        }
        return res;
    }

}
