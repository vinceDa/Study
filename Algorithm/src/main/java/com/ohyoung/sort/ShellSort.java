package com.ohyoung.sort;


import java.util.Arrays;

/**
 * 希尔排序
 * 希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序
 *
 * @author ohYoung
 * @date 2020/12/14 17:17
 */
public class ShellSort {

    public static void main(String[] args) {
        String[] a = new String[]{"a", "s", "s", "b"};
        sort(a);
        // sortWithSentinel(a);
        System.out.println(Arrays.toString(a));
    }


    private static void sort(Comparable[] a) {
        int gap = a.length / 2;
        while (gap > 1) {
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for (int i = gap; i < a.length; i+=gap) {
                int j = i;
                Comparable temp = a[j];
                if (CompareUtil.less(a[j], a[j - gap])) {
                    while (j - gap >= 0 && CompareUtil.less(temp, a[j-gap])) {
                        a[j] = a[j - gap];
                        j -= gap;
                    }
                    // 移动法找到排序后temp的位置j
                    a[j] = temp;
                }
            }
            gap = gap / 2;
        }
    }

}
