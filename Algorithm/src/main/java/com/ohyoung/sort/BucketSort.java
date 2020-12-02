package com.ohyoung.sort;

/**
 *  桶排序
 *  需要知道数据的范围并针对范围提前分配合适的桶存储数据, 例如根据订单金额排序, 金额在1~10w之间,
 *  那么可以分出100个桶, 每个桶的范围为(1, 1000)、(1001, 2000)...
 *  如果某个桶的数据过多, 可以将那个桶继续细分比如说10个桶, 以此类推
 * @author ohYoung
 * @date 2020/12/2 10:17
 */
public class BucketSort {

    public static void main(String[] args) {

    }

    private void bucketSort(int[] a) {
        int[] bucket = new int[100];
        for (int i = 0; i < a.length; i++) {

        }
    }

}
