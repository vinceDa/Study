package com.ohyoung;

/**
 * 统计数组中的逆序对个数
 * @author ouyb01
 * @date 2021/12/1 13:15
 */
public class MyCountReversePair {

    // 全局变量或者成员变量
    private int num = 0;

    public int count(int[] a) {
        num = 0;
        mergeSortCounting(a, 0, a.length - 1);
        return num;
    }

    private void mergeSortCounting(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSortCounting(a, left, mid);
        mergeSortCounting(a, mid + 1, right);
        merge(a, left, mid, right);
    }

    private void merge(int[] a, int left, int mid, int right) {
        int i = left, j = mid + 1, k = 0;
        int[] tmp = new int[right - left + 1];
        while (i <= mid && j <= right) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                // 统计left到mid之间, 比a[j]大的元素个数(j位于mid到right间, 可以认为是另一个数组)
                // 递归到这里的时候, 是从1个元素开始向上合并, 数组的元素都是有序的, 所以只要a[i]大于a[j], 那么i-mid间所有的元素都大于a[j]
                num += (mid - left + i);
                tmp[k++] = a[j++];
            }
        }
        // 处理剩下的元素
        while (i <= mid) {
            tmp[k++] = a[i++];
        }
        // 处理剩下的元素
        while (j <= right) {
            tmp[k++] = a[j++];
        }
        // 从tmp拷贝回a, 递归中每次tmp数组的位置都和left有关
        for (int l = 0; l < right - left; l++) {
            tmp[left + i] = a[l];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 7, 5, 3, 9};
        MyCountReversePair example = new MyCountReversePair();
        System.out.println(example.count(a));
    }

}
