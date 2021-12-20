package com.ohyoung.structure.array;

/**
 * 实现一个有序数组, 支持动态增删改
 * @author ohYoung
 * @date 2021/12/20 22:20
 */
public class Orderly {

    /**
     * 默认容量为10, 可传入size自定义
     */
    private static final int DEFAULT_CAPACITY = 10;

    private Object[] element;

    private int size;

    public Orderly() {
        this.element = new Object[DEFAULT_CAPACITY];
    }

    public Orderly(int size) {
        this.element = new Object[size];
    }

    public void add(Integer i) {
        if (element.length == size) {
            throw new IndexOutOfBoundsException();
        }

    }

    private int binarySearch(Integer i) {
        int index = 0;
        int mid = 0;
        return 0;
    }

    // 添加元素时使用二分法找到位置, 然后将后面的元素全部后移一位

    // 更新元素先用二分法找到插入的位置j, 再将更新位置i和j之间的元素覆盖到i及之后, 然后空白的位置j插入新元素

}
