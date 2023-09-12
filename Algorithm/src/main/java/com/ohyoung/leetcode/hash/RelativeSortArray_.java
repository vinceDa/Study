package com.ohyoung.leetcode.hash;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 1122. 数组的相对排序
 * <p>
 * 给你两个数组，arr1 和 arr2，arr2 中的元素各不相同，arr2 中的每个元素都出现在 arr1 中。
 * <p>
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * <p>
 * 示例 1：
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 * <p>
 * 示例  2:
 * 输入：arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
 * 输出：[22,28,8,6,17,44]
 * <p>
 * 提示：
 * 1 <= arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i]  各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 *
 * <a href="https://leetcode-cn.com/problems/relative-sort-array/"></a>
 *
 * @author vince 2023/8/21 11:48
 */
public class RelativeSortArray_ {

    public static void main(String[] args) {
        RelativeSortArray_ relativeSortArray = new RelativeSortArray_();
        int[] arr1 = new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = new int[]{2, 1, 4, 3, 9, 6};
        int[] sortArray = relativeSortArray.relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(sortArray));
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        List<Integer> list = new ArrayList<>();
        for (int i : arr1) {
            list.add(i);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }

        list.sort((x, y) -> {
            if (map.containsKey(x) || map.containsKey(y)) {
                return map.getOrDefault(x, 1001) - map.getOrDefault(y, 1001);
            }
            return x - y;
        });

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = list.get(i);
        }
        return arr1;
    }

    public int[] relativeSortArray1(int[] arr1, int[] arr2) {
        Map<Integer, Integer> storage = new HashMap<>();
        for (int i : arr1) {
            storage.put(i, storage.getOrDefault(i, 0) + 1);
        }

        int[] res = new int[arr1.length];
        int index = 0;
        for (int j : arr2) {
            while (storage.get(j) != 0) {
                res[index++] = j;
                storage.put(j, storage.get(j) - 1);
            }
            storage.remove(j);
        }

        List<Integer> keys = storage.keySet().stream().sorted().collect(Collectors.toList());
        for (Integer key : keys) {
            while (storage.get(key) != 0) {
                res[index++] = key;
                storage.put(key, storage.get(key) - 1);
            }
        }
        return res;
    }

}
