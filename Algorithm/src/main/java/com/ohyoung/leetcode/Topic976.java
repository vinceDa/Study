package com.ohyoung.leetcode;

/**
 *
 * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 * 如果不能形成任何面积不为零的三角形，返回 0。
 *
 * 示例 1：
 *      输入：[2,1,2]      输出：5
 * 示例 2：
 *      输入：[1,2,1]      输出：0
 * 示例 3：
 *      输入：[3,2,3,4]    输出：10
 * 示例 4：
 *      输入：[3,6,2,3]    输出：8
 *
 * 提示：
 *      3 <= A.length <= 10000
 *      1 <= A[i] <= 10^6
 *
 * @author ohYoung
 * @date 2020/11/29 22:33
 */
// TODO 执行时间太长, 可优化
public class Topic976 {

    public static void main(String[] args) {
        System.out.println("[2,1,2]: " + cal(new int[]{2,1,2}));
        System.out.println("[1,2,1]: " + cal(new int[]{1,2,1}));
        System.out.println("[3,2,3,4]: " + cal(new int[]{3,2,3,4}));
        System.out.println("[3,6,2,3]: " + cal(new int[]{3,6,2,3}));
    }


    private static int cal(int[] param) {
        // 1. 将数组按升序排列
        for (int i = 0; i < param.length; i++) {
            for (int j = i; j > 0 && param[j] < param[j-1]; j--) {
                int tmp = param[j];
                param[j] = param[j-1];
                param[j-1] = tmp;
            }
        }
        // 2. 从左到右依次取出三位, 判断是否满足三角形的要求(两边之和大于第三边)
        int max = 0;
        for (int i = 0; i < param.length - 2; i++) {
            if (param[i] + param[i + 1] <= param[i + 2]) {
                continue;
            }
            // 3. 计算周长与max做比对
            int perimeter = param[i] + param[i+1] + param[i+2];
            if (perimeter > max) {
                max = perimeter;
            }
        }
        // 4. 返回max
        return max;
    }

}
