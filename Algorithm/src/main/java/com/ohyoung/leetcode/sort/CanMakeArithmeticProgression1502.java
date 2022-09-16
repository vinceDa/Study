package com.ohyoung.leetcode.sort;

/**
 * 给你一个数字数组 arr 。
 * 如果一个数列中，任意相邻两项的差总等于同一个常数，那么这个数列就称为 等差数列 。
 * 如果可以重新排列数组形成等差数列，请返回 true ；否则，返回 false 。
 *
 * 示例 1：
 * 输入：arr = [3,5,1]
 * 输出：true
 * 解释：对数组重新排序得到 [1,3,5] 或者 [5,3,1] ，任意相邻两项的差分别为 2 或 -2 ，可以形成等差数列。
 *
 * 示例 2：
 * 输入：arr = [1,2,4]
 * 输出：false
 * 解释：无法通过重新排序得到等差数列。
 *
 * 提示：
 * 2 <= arr.length <= 1000
 * -10^6 <= arr[i] <= 10^6
 *
 * 链接：<a href="https://leetcode.cn/problems/can-make-arithmetic-progression-from-sequence">...</a>
 * @author ouyb01
 * @date 2022/9/8 9:32
 */
public class CanMakeArithmeticProgression1502 {

    public static void main(String[] args) {
        CanMakeArithmeticProgression1502 example = new CanMakeArithmeticProgression1502();
        System.out.println(example.canMakeArithmeticProgression(new int[]{3, 5, 1}));
        System.out.println(example.canMakeArithmeticProgression(new int[]{1, 2, 4}));
        System.out.println(example.canMakeArithmeticProgression(new int[]{1, 9, 13, 5, 21, 17}));

    }

    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length == 0) {
            return false;
        }
        if (arr.length <= 2) {
            return true;
        }
        quickSort(0, arr.length - 1, arr);
        int gap = arr[1] - arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] + gap != arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = false;
                }
            }
            if (flag) {
                return;
            }
        }
    }


    private void quickSort(int start, int end, int[] arr) {
        if (start >= end) {
            return;
        }
        int partition = partition(start, end, arr);
        quickSort(start, partition - 1, arr);
        quickSort(partition + 1, end, arr);
    }

    private int partition(int start, int end, int[] a) {
        int index = start;
        int partition = a[end];
        for (int i = start; i < end; i++) {
            if (a[i] < partition) {
                int tmp = a[i];
                a[i] = a[index];
                a[index++] = tmp;
            }
        }
        a[end] = a[index];
        a[index] = partition;
        return index;
    }

}
