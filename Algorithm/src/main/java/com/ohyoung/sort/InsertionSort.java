package com.ohyoung.sort;

import java.util.Arrays;

/**
 * 插入排序
 *  为了要给插入的元素提供空间, 其他元素再插入之前都向后移一位的算法叫做插入排序
 * @author ohYoung
 * @date 2020/11/5 15:56
 */
public class InsertionSort {

    public static void main(String[] args) {
        String [] a = new String[]{"a","s","s","b"};
        sort(a);
        // sortWithSentinel(a);
        System.out.println(Arrays.toString(a));
    }


    /**
     *  目标元素和左边的元素比对完后可以看作索引+1, 索引左侧的元素都是排好序的, 当索引走到数组的右端时, 排序结束
     * @param a 将要被排序的数组
     */
    private static void sort(Comparable[] a) {
        // i可以看作是索引
        for (int i = 0; i < a.length; i++) {

            // TODO 这里有个问题, 如果类似 a,s,s,b 的时候, 这里执行的是 a,s,b,s --> a,b,s,s; 多出了一次插入操作, 如果能直接插入到第一个相同元素(s,s)的前面更好
            for (int j = i; j > 0 && CompareUtil.less(a[j], a[j-1]); j--) {
                CompareUtil.exchange(a, j, j-1);
            }
        }
    }

    /**
     *  当数组长度过大时, j>0的判断需要进行多次, 所以我们可以先将最小元素找出来并且放在最左边,
     *  这样我们就可以从1开始循环数组并且删除j>0的判断, 这个最小元素就是这个样例中的哨兵
     *  插入排序哨兵模式
     */
    private static void sortWithSentinel(Comparable[] a) {
        // 找到数组中最小的元素并放在第一位
        int min = 0;
        for (int i = 0; i < a.length; i++) {
            if (CompareUtil.less(a[i], a[min])) {
                min = i;
            }
        }
        CompareUtil.exchange(a, 0, min);
        for (int i = 1; i < a.length; i++) {
            for (int j = i; CompareUtil.less(a[j], a[j-1]); j--) {
                CompareUtil.exchange(a, j, j-1);
            }
        }
    }

}
