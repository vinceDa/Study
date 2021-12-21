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

    private Integer[] element;

    private int size;

    public Orderly() {
        this.element = new Integer[DEFAULT_CAPACITY];
    }

    public Orderly(int size) {
        this.element = new Integer[size];
    }

    public void add(int value) {
        if (element.length == size) {
            throw new IndexOutOfBoundsException();
        }
        int index = binarySearch(element, value);
        int move = size - index - 1;
        System.arraycopy(element, index + 1, element, index + 2, move);
        element[index + 1] = value;
    }

    public Integer remove(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Integer i = get(index);
        int move = size - index - 1;
        // 非末级节点
        if (move != 0) {
            System.arraycopy(element, index + 1, element, index, move);
        }
        element[--size] = null;
        return i;
    }

    public void add(int index, int value) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        int targetIndex = binarySearch(element, value);
        int move = size - index - 1;
        System.arraycopy(element, index + 1, element, index + 2, move);
        element[index + 1] = value;
    }

    public Integer get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return element[index];
    }

    private int binarySearch(Integer[] arr, int value) {
        int start = 0;
        int end = size - 1;
        if (value <= arr[start]) {
            return 0;
        }
        if (value >= arr[end]) {
            return end;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > value) {
                end = mid - 1;
            } else if (arr[mid] < value) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        // 如果没有匹配, 则将新的元素插入start的位置
        return start;
    }

    // 添加元素时使用二分法找到位置, 然后将后面的元素全部后移一位

    // 更新元素先用二分法找到插入的位置j, 再将更新位置i和j之间的元素覆盖到i及之后, 然后空白的位置j插入新元素

}
