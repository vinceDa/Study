package com.ohyoung.structure.array;

import java.util.Arrays;

/**
 * 动态扩容的数组
 * @author ouyb01
 * @date 2021/12/15 10:30
 */
public class DynamicExpansionList<E> {

    /**
     * 数组默认容量为10
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 数组大小
     */
    private int size;

    /**
     * 数组
     */
    private Object[] element;

    public DynamicExpansionList() {
        element = new Object[DEFAULT_CAPACITY];
    }

    public DynamicExpansionList(int size) {
        if (size <= 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        element = new Object[size];
    }

    public DynamicExpansionList(int size, Object[] element) {
        if (size <= 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        element = new Object[size];
        this.element = element;
    }

    /**
     * 数组元素添加删除更新数组容量大小
     */
    public void add(E e) {
        if (element.length == size) {
            expansion();
        }
        element[size++] = e;
    }

    /**
     * 数组元素删除时更新数组容量大小
     */
    public E remove(int i) {
        if (i >= size || i < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        E e = get(i);
        // 将i后的元素向前移一位
        int move = size - i - 1;
        // 非末节点
        if (move != 0) {
            System.arraycopy(element, i + 1, element, i, move);
        }
        element[--size] = null;
        return e;
    }

    public E get(int i) {
        if (i >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (E)element[i];
    }

    /**
     * 扩容
     */
    private void expansion() {
        element = Arrays.copyOf(element, size + (size / 2));
    }

    public static void main(String[] args) {
        DynamicExpansionList<Integer> list = new DynamicExpansionList<>(2);
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("size: " + list.size);
        System.out.println("index_1: " + list.get(1));
        System.out.println("index_2: " + list.get(2));
        System.out.println("remove_index_1: " + list.remove(1));
        System.out.println("remove_index_0: " + list.remove(0));
        System.out.println("index_0: " + list.get(0));
    }

}
