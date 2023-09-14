package com.ohyoung.leetcode.hash.interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 面试题 16.21. 交换和
 * <p>
 * 给定两个整数数组，请交换一对数值（每个数组中取一个数值），使得两个数组所有元素的和相等。
 * <p>
 * 返回一个数组，第一个元素是第一个数组中要交换的元素，第二个元素是第二个数组中要交换的元素。若有多个答案，返回任意一个均可。若无满足条件的数值，返回空数组。
 * <p>
 * 示例:
 * 输入: array1 = [4, 1, 2, 1, 1, 2], array2 = [3, 6, 3, 3]
 * 输出: [1, 3]
 * <p>
 * 示例:
 * 输入: array1 = [1, 2, 3], array2 = [4, 5, 6]
 * 输出: []
 * <p>
 * 提示：
 * 1 <= array1.length, array2.length <= 100000
 *
 * <a href="https://leetcode-cn.com/problems/sum-swap-lcci/"></a>
 *
 * @author vince 2023/8/21 11:51
 */
public class FindSwapValues1621 {

    public static void main(String[] args) {
        FindSwapValues1621 findSwapValues = new FindSwapValues1621();
        int[] array1 = new int[]{4, 1, 2, 1, 1, 2};
        int[] array2 = new int[]{3, 6, 3, 3};
        System.out.println(Arrays.toString(findSwapValues.findSwapValues(array1, array2)));

        array1 = new int[]{1, 2, 3};
        array2 = new int[]{4, 5, 6};
        System.out.println(Arrays.toString(findSwapValues.findSwapValues(array1, array2)));
    }

    /**
     * sumA - x + y = sumB - y + x  --> sumA - sumB = 2 * (x - y)
     * gap = sumA - sumB
     * y = x - (gap / 2)
     */
    public int[] findSwapValues(int[] array1, int[] array2) {
        int min = Math.min(array1.length, array2.length);
        Set<Integer> ed = new HashSet<>();
        int gap = 0;
        for (int i = 0; i < min; i++) {
            gap += (array1[i] - array2[i]);
            ed.add(array2[i]);
        }
        while (min < array1.length) {
            gap += array1[min++];
        }
        while (min < array2.length) {
            int i = array2[min++];
            gap += i;
            ed.add(i);
        }
        // 如果gap为奇数直接返回空
        if (gap % 2 != 0) {
            return new int[0];
        }

        for (int i : array1) {
            int o = i - gap / 2;
            if (ed.contains(o)) {
                return new int[]{i, o};
            }
        }
        return new int[0];
    }

}
