package com.ohyoung;

/**
 * @author ohYoung
 * @description 实现二分查找法
 * @date 2021/1/8 16:56
 **/
public class BinarySearch {

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 4};
        System.out.println(binarySearchByCycle(a, 4));
        System.out.println(binarySearchByRecursion(a, 4));
    }

    /**
     *  二分查找法的java实现
     * @param a 数组
     * @param value 要被查找的值
     * @return value所在下标
     */
    private static int binarySearchByCycle(int[] a, int value) {
        int low = 0;
        int length = a.length;
        int high = length - 1;
        // 不在数组范围内直接返回
        if (value > a[high] || value < a[low]) {
            return -1;
        }
        while (low <= high) {
            // mid = (low + high) / 2, 严格来说是有问题的, 当low和high足够大的时候两者之和会溢出; 改进: mid = low + (high - low) / 2 ; 改进: mid = low + ((high - low) >> 1)
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                // 此处如果直接用mid替换的话, 可能导致死循环; 例: low = high = 3, a[3] != value
                high = mid - 1;
            } else if (a[mid] < value) {
                // 同上
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     *  二分查找法的java实现(递归)
     * @param a 数组
     * @param value 要被查找的值
     * @return value在数组中的下标
     */
    private static int binarySearchByRecursion(int[] a, int value) {
        return binarySearchRecursion(a, 0, a.length - 1, value);
    }

    private static int binarySearchRecursion(int[] a, int low, int high, int value) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) >> 1);
        if (a[mid] > value) {
            return binarySearchRecursion(a, low, mid - 1, value);
        } else if (a[mid] < value) {
            return binarySearchRecursion(a, mid + 1, high, value);
        } else {
            return mid;
        }
    }

    /**
     *  课后题: 如何编程实现"求一个数的平方根"? 要求精确到小数点后 6 位.
     */


    /**
     * 如果数据使用链表存储, 二分查找的时间复杂就会变得很高, 那查找的时间复杂度究竟是多少呢?
     * 如果你自己推导一下, 你就会深刻地认识到, 为何我们会选择用数组而不是链表来实现二分查找了.
     */

}
