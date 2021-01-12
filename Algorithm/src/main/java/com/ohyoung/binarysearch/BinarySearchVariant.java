package com.ohyoung.binarysearch;

/**
 * @author ohYoung
 * @description 二分法变种
 * @date 2021/1/12 16:20
 **/
public class BinarySearchVariant {

    public static void main(String[] args) {
        int[] a = new int[]{1, 3 ,4 ,5, 6, 8, 8, 8, 11, 18};
        System.out.println(binarySearchFirstEq(a, 8));
        System.out.println(binarySearchLastEq(a, 8));
        System.out.println(binarySearchFirstEqOrGe(a, 8));
        System.out.println(binarySearchLastEqOrLe(a, 8));
    }

    /**
     *  查找第一个值等于给定值的元素
     */
    private static int binarySearchFirstEq(int[] a, int value) {
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (a[mid] < value) {
                start = mid + 1;
            } else if (a[mid] > value) {
                end = mid - 1;
            } else {
                // 之前我的想法是: 找到这个相等值, 然后从mid往0做循环取第一个 != value 的下标, 但是假如mid足够大的话, 这个循环会很耗时, 所以舍弃了
                if (mid == 0 || a[mid - 1] != value) {
                    return mid;
                } else {
                    end = mid - 1;
                }

            }
        }
        return -1;
    }

    /**
     *  查找最后一个值等于给定值的元素
     */
    private static int binarySearchLastEq(int[] a, int value) {
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (a[mid] == value) {
                if (mid == end || a[mid + 1] != value) {
                    return mid;
                } else {
                    start = mid + 1;
                }
            }
            if (a[mid] < value) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    /**
     *  查找第一个值大于等于给定值的元素
     */
    private static int binarySearchFirstEqOrGe(int[] a, int value) {
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (a[mid] >= value) {
                if (mid == 0 || a[mid - 1] < value) {
                    return mid;
                }
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    /**
     *  查找最后一个值小于等于给定值的元素
     */
    private static int binarySearchLastEqOrLe(int[] a, int value) {
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (a[mid] <= value) {
                if (mid == end || a[mid + 1] > value) {
                    return mid;
                }
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

}
