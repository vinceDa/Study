package com.ohyoung.leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 * 示例 1：
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 示例2：
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 提示：
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 *
 * 链接：<a href="https://leetcode.cn/problems/merge-intervals">...</a>
 * @author ouyb01
 * @date 2022/9/8 9:33
 */
public class Merge56 {

    public static void main(String[] args) {
        Merge56 example = new Merge56();
        System.out.println(Arrays.toString(example.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
        System.out.println(Arrays.toString(example.merge(new int[][]{{1, 4}, {4, 5}})));
    }

    /**
     * 将数组按照左端点排序, 然后顺序遍历数组, A右端点 >= B右端点  且 A右端点 >= B左端点 则可以合并
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            int L = interval[0], R = interval[1];
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

}
