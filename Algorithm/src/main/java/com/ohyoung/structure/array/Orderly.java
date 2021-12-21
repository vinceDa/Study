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
        if (size == 0) {
            element[size++] = value;
            return;
        }
        // 从头部插入
        if (value <= element[0]) {
            System.arraycopy(element, 0, element, 1, size);
            element[0] = value;
            return ;
        }
        // 从尾部新增
        if (value >= element[size - 1]) {
            element[size++] = value;
            return ;
        }
        int index = binarySearch(element, value);
        int move = size - index;
        System.arraycopy(element, index, element, index + 1, move);
        element[index] = value;
        size++;
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

    public void update(int index, int value) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        // 先将index处的元素删除, 在调用add方法排序
        remove(index);
        add(value);
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

    public static void main(String[] args) {
        Orderly orderly = new Orderly();
        orderly.add(1);
        orderly.add(5);
        orderly.add(4);
        orderly.add(3);
        orderly.add(11);
        orderly.add(9);
        orderly.add(8);
        for (int i = 0; i < orderly.size; i++) {
            System.out.print(orderly.get(i) + " ");
        }
        System.out.println();
        orderly.update(2, 7);
        for (int i = 0; i < orderly.size; i++) {
            System.out.print(orderly.get(i) + " ");
        }
        System.out.println();
        orderly.remove(1);
        orderly.remove(1);
        orderly.remove(1);
        for (int i = 0; i < orderly.size; i++) {
            System.out.print(orderly.get(i) + " ");
        }
    }

}
