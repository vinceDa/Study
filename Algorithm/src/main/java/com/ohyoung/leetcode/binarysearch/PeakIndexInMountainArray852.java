package com.ohyoung.leetcode.binarysearch;

/**
 * 符合下列属性的数组 arr 称为 山脉数组 ：
 * arr.length >= 3
 * 存在 i（0 < i< arr.length - 1）使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * 给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i 。
 *
 * 示例 1：
 * 输入：arr = [0,1,0]
 * 输出：1
 *
 * 示例 2：
 * 输入：arr = [0,2,1,0]
 * 输出：1
 *
 * 示例 3：
 * 输入：arr = [0,10,5,2]
 * 输出：1
 *
 * 示例 4：
 * 输入：arr = [3,4,5,1]
 * 输出：2
 *
 * 示例 5：
 * 输入：arr = [24,69,100,99,79,78,67,36,26,19]
 * 输出：2
 *
 * 提示：
 * 3 <= arr.length <= 104
 * 0 <= arr[i] <= 106
 * 题目数据保证 arr 是一个山脉数组
 *
 * 进阶：很容易想到时间复杂度 O(n) 的解决方案，你可以设计一个 O(log(n)) 的解决方案吗？
 *
 * 链接：<a href="https://leetcode.cn/problems/peak-index-in-a-mountain-array">...</a>
 * @author ouyb01
 * @date 2022/6/14 9:29
 */
public class PeakIndexInMountainArray852 {

    public static void main(String[] args) {
        PeakIndexInMountainArray852 demo = new PeakIndexInMountainArray852();
        System.out.println(demo.peakIndexInMountainArray(new int[]{0, 1, 0}));
        System.out.println(demo.peakIndexInMountainArray(new int[]{0, 2, 1, 0}));
        System.out.println(demo.peakIndexInMountainArray(new int[]{0, 10, 5, 2}));
        System.out.println(demo.peakIndexInMountainArray(new int[]{3, 4, 5, 1}));
        System.out.println(demo.peakIndexInMountainArray(new int[]{3, 5, 3, 2, 0}));
        System.out.println(demo.peakIndexInMountainArray(new int[]{24, 69, 100, 99, 79, 78, 67, 36, 26, 19}));
    }

    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            // 处理特殊情况, 山脉数组的峰值一定不会出现在两端
            if (end == 1) {
                return end;
            }
            if (start == arr.length - 2) {
                return start;
            }

            // 防止溢出
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
                return mid;
            } else if (arr[mid] > arr[mid + 1] && arr[mid] < arr[mid - 1]) {
                end = mid - 1;
            } else if (arr[mid] < arr[mid + 1] && arr[mid] > arr[mid - 1]) {
                start = mid + 1;
            }
        }

        return -1;
    }

}
