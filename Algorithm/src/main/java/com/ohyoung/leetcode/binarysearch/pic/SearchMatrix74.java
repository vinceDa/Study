package com.ohyoung.leetcode.binarysearch.pic;

/**
 * 编写一个高效的算法来判断m x n矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * <p>
 * 示例 1：
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 * <p>
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 * <p>
 * 链接：<a href="https://leetcode.cn/problems/search-a-2d-matrix">...</a>
 *
 * @author ouyb01
 * @date 2022/6/14 9:35
 */
public class SearchMatrix74 {

    public static void main(String[] args) {
        SearchMatrix74 demo = new SearchMatrix74();
        int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(demo.searchMatrix(matrix, 3));
        matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(demo.searchMatrix(matrix, 13));

        System.err.println("================================");

        matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(demo.searchMatrix2(matrix, 3));
        matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(demo.searchMatrix2(matrix, 13));
        matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(demo.searchMatrix2(matrix, 11));
        matrix = new int[][]{{1}, {3}, {5}};
        System.out.println(demo.searchMatrix2(matrix, 5));
        matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(demo.searchMatrix2(matrix, 30));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] sub : matrix) {
            int length = sub.length;
            int low = 0;
            int high = length - 1;
            while (low <= high) {
                int mid = high - (high - low) / 2;
                if (sub[mid] == target) {
                    return true;
                } else if (sub[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return false;
    }

    /**
     * 第一种方式最坏的结果是每一行数组都进行二分查找直到最后才找到,
     * 当前方式通过利用特性二先二分查找找到target在哪一行, 然后在具体的行进行二分查找找到target
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        int[] range = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            range[i] = matrix[i][0];
        }

        int length = range.length;
        int low = 0;
        int high = length - 1;
        // 开始位置
        int start = 0;
        while (low <= high) {
            int mid = high - (high - low) / 2;
            if (range[mid] == target) {
                return true;
            }

            if (range[mid] > target) {
                if (low != high) {
                    start = low;
                }
                high = mid - 1;
            } else {
                start = mid;
                low = mid + 1;
            }
        }

        return binarySearch(matrix[start], target);
    }

    private boolean binarySearch(int[] nums, int target) {
        int length = nums.length;
        int low = 0;
        int high = length - 1;
        while (low <= high) {
            int mid = high - (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

}
