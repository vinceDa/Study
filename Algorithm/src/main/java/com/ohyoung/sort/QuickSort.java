package com.ohyoung.sort;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author ohYoung
 * @date 2020/12/1 17:27
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = new int[]{1, 5, 6, 3, 2, 65, 543, 24, 231, 443, 24, 3, 432, 32, 4, 23, 432, 4, 323, 42, 1, 2321, 434, 5, 6, 6, 7, 78};
        System.out.println(Arrays.toString(a));
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    public static void quickSort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        int partition = partition(a, start, end);
        quickSort(a, start, partition - 1);
        quickSort(a, partition + 1, end);
    }

    public static int partition(int[] a, int start, int end) {
        int index = start;
        // partition可以根据算法定义的更准确,使得partition两侧元素的数量更均衡, 这里简单点直接取end的位置
        int partition = a[end];
        for (int i = start; i < end; i++) {
            if (a[i] < partition) {
                int tmp = a[i];
                a[i] = a[index];
                a[index++] = tmp;
            }
        }
        // 将partition和中间位置元素调换位置, 使得左侧元素 < partition < 右侧元素
        a[end] = a[index];
        a[index] = partition;
        // 返回排序后partition所在的位置
        return index;
    }

}
