package com.ohyoung.sort;

import java.util.Arrays;

/**
 * @description 自己实现的一个通用的高性能的排序函数
 * @author ohYoung
 * @date 2021/1/6 17:40
 **/
public class OhYoungSort {

    /**
     *  小于等于这个值就使用插入排序
     */
    private static final int INSERT_SORT_LENGTH = 48;
    /**
     *  小于等于这个值就使用归并排序
     */
    private static final int MERGE_SORT_LENGTH = 96;
    /**
     *  小于等于这个值就使用快速排序
     */
    private static final int QUICK_SORT_LENGTH = 128;


    public static void sort(int[] a) {
        if (a == null || a.length == 0) {
            return;
        }
        int length = a.length;
        if (length <= INSERT_SORT_LENGTH) {
            insertSort(a);
        } else if (length <= MERGE_SORT_LENGTH) {
            mergeSortRecursion(a, 0, length - 1);
        } else {
            quickSortRecursion(a, 0 , length - 1);
        }
    }
    
    // 1. 小于某个长度用插入排序
    private static void insertSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    int tmp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = tmp;
                }
            }
        }
    }
    // 2. 归并排序
    private static void mergeSortRecursion(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        // 取中间位置, 反例: (end - start) / 2
        int mid = (start + end) / 2;
        mergeSortRecursion(a, start, mid);
        mergeSortRecursion(a, mid + 1, end);
        mergeSort(a, start, mid, end);
    }

    // 3. 快速排序
    private static void quickSortRecursion(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        int partition = quickPartition(a, start, end);
        quickSortRecursion(a, start, partition - 1);
        quickSortRecursion(a, partition + 1, end);
    }

    /**
     *  声明一个临时数组去临时存储所有的排序数据, 根据mid将数组切割为两个, 然后对比两个数组进行排序
     */
    private static void mergeSort(int[] total, int start, int mid, int end) {
        int leftStart = start;
        int rightStart = mid + 1;
        int index = 0;
        int length = end - start + 1;
        int[] tmp = new int[length];
        while (leftStart <= mid && rightStart <= end) {
            if (total[leftStart] <= total[rightStart]) {
                tmp[index++] = total[leftStart++];
            } else {
                tmp[index++] = total[rightStart++];
            }
        }
        // 将剩余数据存入tmp数组
        int restStart = leftStart;
        int restEnd = mid;
        if (rightStart <= end) {
            restStart = rightStart;
            restEnd = end;
        }
        while (restStart <= restEnd) {
            tmp[index++] = total[restStart++];
        }
        // 将tmp数组数据拷贝回原数组
        for (int i = 0; i < length; i++) {
            total[start + i] = tmp[i];
        }
    }

    /**
     *  获取分区点, 根据分区点排序, 小于分区点往左排, 大于则往右
     *  获取分区点的三种方式:
     *         1. 选定某个点, 比如数组的最后一个数为分区点, 优点: 实现简单; 缺点: 极端情况效率会变慢
     *         2. 根据数组长度选择三/五/十...数取中(取几个数的中间值为分区点, 比如1、3、5的中间点为3)
     *         3. 随机取一个值为中间点
     */
    private static int quickPartition(int[] total, int start, int end) {
        handlePartitionIndex(total, start, end);
        int p = total[end];
        int index = start;
        for (int i = start; i <= end; i++) {
            if (total[i] < p) {
                int tmp = total[i];
                total[i] = total[index];
                total[index] = tmp;
                index++;
            }
        }
        int tmp = total[index];
        total[index] = total[end];
        total[end] = tmp;
        return index;

    }

    /**
     *  将分区点放在数组的最后一位
     */
    private static void handlePartitionIndex(int[] total, int start, int end) {
        if (end - start >= 3) {
            int mid = (start + end) / 2;
            if ((total[start] >= total[mid] && total[start] <= total[end]) || (total[start] <= total[mid] && total[start] >= total[end])) {
                int tmp = total[start];
                total[start] = total[end];
                total[end] = tmp;
            } else if ((total[mid] >= total[start] && total[mid] <= total[end]) || (total[mid] <= total[start] && total[mid] >= total[end])) {
                int tmp = total[mid];
                total[mid] = total[end];
                total[end] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 5, 4, 8, 9, 8, 3, 2, 7, 6};
        quickSortRecursion(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

}
