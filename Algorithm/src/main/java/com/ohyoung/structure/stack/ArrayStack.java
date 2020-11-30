package com.ohyoung.structure.stack;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 用数组实现栈
 *
 * @author ohYoung
 * @date 2020/11/30 8:52
 */
public class ArrayStack {

    int index;
    Object[] arr;

    public ArrayStack(int length) {
        this.index = 0;
        arr = new Object[length];
    }

    public boolean push(Object data) {
        if (index != 0 && index >= arr.length) {
            return false;
        }
        arr[index] = data;
        index++;
        return true;
    }

    public Object pop() {
        if (index == 0) {
            return null;
        }
        Object res = arr[index - 1];
        index--;
        return res;
    }

    public String print() {
        return Arrays.toString(Arrays.copyOf(arr, index));
    }

}
