package com.ohyoung.leetcode.sort.interview;

import java.util.Arrays;

/**
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 * 初始化A 和 B 的元素数量分别为m 和 n。
 *
 * 示例:
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 *
 * 输出:[1,2,2,3,5,6]
 * 说明:
 * A.length == n + m
 *
 * 链接：<a href="https://leetcode.cn/problems/sorted-merge-lcci">...</a>
 * @author ouyb01
 * @date 2022/9/8 9:31
 */
public class Merge1001 {

    public static void main(String[] args) {
        Merge1001 example = new Merge1001();
        int[] A = new int[]{1, 2, 3, 0, 0, 0};
        int[] B = new int[]{2, 5, 6};
        example.merge(A, 3, B, 3);
        System.out.println(Arrays.toString(A));
    }

    /**
     * 逆向双指针(A的后半部分是空的可以直接插入不用考虑被覆盖的问题)
     */
    public void merge(int[] A, int m, int[] B, int n) {
        int pa = m -1;
        int pb = n - 1;
        int cur;
        int tail = m + n - 1;
        while (pa != -1 || pb != -1) {
            if (pa == -1) {
                cur = B[pb--];
            } else if (pb == -1) {
                cur = A[pa--];
            } else if (A[pa] > B[pb]) {
                cur = A[pa--];
            } else {
                cur = B[pb--];
            }
            A[tail--] = cur;
        }
    }

    public void merge01(int[] A, int m, int[] B, int n) {
        for (int i = 0; i < n; i++) {
            A[m + i] = B[i];
        }
        bubbleSort(A);
    }

    /**
     * 冒泡排序
     */
    private void bubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            // 是否直接退出排序的标志位
            boolean flag = true;
            // 每次都将最大的数字放到末尾, 所以排好序的末尾数字可以不比较(a.length - 1 - i)
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = false;
                }
            }
            if (flag) {
                return;
            }
        }
    }

}
