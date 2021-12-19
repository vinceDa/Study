package com.ohyoung.structure.array;

/**
 * 动态扩容的数组
 * @author ouyb01
 * @date 2021/12/15 10:30
 */
public class DynamicExpansionArray {

    // 1. 初始化一个数组, 默认容量为10
    private final int DEFAULT_SIZE = 10;

    private final int size = DEFAULT_SIZE;

    private int[] arr = new int[DEFAULT_SIZE];
    // 2. 实现数组元素的添加、删除时更新数组容量大小
    public void add(int i) {

    }

    public void remove(int i) {

    }

    public int get(int i) {
        assert i < size;
        return arr[i];
    }
    // 3. 在新增元素时判断是否达到容量上限, 是则定义一个原来2倍大小的数组, 将原数组的元素copy到新数组然后再做新增

}
