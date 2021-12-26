package com.ohyoung.structure.array;

/**
 * 两个有序数组合并
 * @author ohYoung
 * @date 2021/12/20 22:20
 */
public class OrderlyMerge {

    public static void main(String[] args) {
        int[] a = new int[]{1, 5, 8, 9, 32, 45, 80};
        int[] b = new int[]{2, 7, 11, 33, 60, 79, 90, 100, 110, 120};
        int m = a.length;
        int n = b.length;
        int[] c = new int[m + n];
        int a1 = 0;
        int a2 = 0;
        int cur;
        while (a1 < m || a2 < n) {
            // a数组循环完了
            if (a1 == m) {
                cur = b[a2++];
                // b数组循环完了
            } else if (a2 == n) {
                cur = a[a1++];
            } else if (a[a1] <= b[a2]) {
                cur = a[a1++];
            } else {
                cur = b[a2++];
            }
            c[a1 + a2 - 1] = cur;
        }
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i] + " ");
        }
    }

}
