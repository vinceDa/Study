package com.ohyoung.sort;

import java.util.Arrays;

/**
 *  冒泡排序
 * @author ohYoung
 * @date 2020/12/1 10:26
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] a = new int[]{ 1,5,4,8,7,9,3 };
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }


    public static void sort(int[] a) {
        int length = a.length;
        for (int i = 0; i < length; ++i) {
            // 提前退出冒泡排序的标志位
            boolean flag = true;
            for (int j = 0; j < length - i - 1; ++j) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = tmp;
                }
                // 发生了数据交换
                flag = false;
            }
            if (flag) {
                break;
            }
        }
    }

}
