package com.ohyoung.sort;

import java.util.Arrays;

/**
 *  归并排序
 * @author ohYoung
 * @date 2020/12/1 11:41
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] a = new int[]{1,5,6,3,2,65,543,24,231,443,24,3,432,32,4,23,432,4,323,42,1,2321,434,5,6,6,7,78};
        System.out.println(Arrays.toString(a));
        group(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }


    public static void group(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        group(a, start, mid);
        group(a, mid + 1, end);

        merge(a, start, mid, end);
    }

    private static void merge(int[] a, int start, int mid, int end) {
        int tmpLength = end - start + 1;
        // 存储归并后的结果
        int[] tmp = new int[tmpLength];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }
        // 将剩余的数据存入tmp
        int restStartIndex = i, restEndIndex = mid;
        if (j <= end) {
            restStartIndex = j;
            restEndIndex = end;
        }
        while (restStartIndex <= restEndIndex) {
            tmp[k++] = a[restStartIndex++];
        }
        // 将tmp中的数据拷回原数组a
        for (int l = 0; l < tmpLength; l++) {
            a[start + l] = tmp[l];
        }
    }

    // TODO 未完成
    private static void mergeWithSentinel(int[] a, int start, int mid, int end) {
        int tmpLength = end - start + 1;
        // 存储归并后的结果
        int[] tmp = new int[tmpLength];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }
        // 将剩余的数据存入tmp
        int restStartIndex = i, restEndIndex = mid;
        if (j <= end) {
            restStartIndex = j;
            restEndIndex = end;
        }
        while (restStartIndex <= restEndIndex) {
            tmp[k++] = a[restStartIndex++];
        }
        // 将tmp中的数据拷回原数组a
        for (int l = 0; l < tmpLength; l++) {
            a[start + l] = tmp[l];
        }
    }

}
