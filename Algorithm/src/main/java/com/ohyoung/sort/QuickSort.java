package com.ohyoung.sort;

import java.util.Arrays;

/**
 *  快速排序
 * @author ohYoung
 * @date 2020/12/1 17:27
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = new int[]{1,5,6,3,2,65,543,24,231,443,24,3,432,32,4,23,432,4,323,42,1,2321,434,5,6,6,7,78};
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
        int partition = a[end];
        for (int i = start; i < end; i++) {
            if (a[i] < partition) {
                int tmp = a[i];
                a[i] = a[index];
                a[index] = tmp;
                index++;
            }
        }
        int tmp = a[end];
        a[end] = a[index];
        a[index] = tmp;
        return index;
    }

}
