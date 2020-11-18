package com.ohyoung.leetcode;

/**
 *  134. 加油站
 *          在一条环路上有N个加油站，其中第i个加油站有汽油gas[i]升。
 *          你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1个加油站需要消耗汽油cost[i]升。你从其中的一个加油站出发，开始时油箱为空。
 *          如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 *      说明:
 *          如果题目有解，该答案即为唯一答案。
 *          输入数组均为非空数组，且长度相同。
 *          输入数组中的元素均为非负数。
 *      示例1:
 *      输入:
 *          gas  = [1,2,3,4,5]
 *          cost = [3,4,5,1,2]
 *
 *      输出: 3
 *      解释:
 *          从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
 *          开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
 *          开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
 *          开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
 *          开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
 *          开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
 *
 * @author ohYoung
 * @date 2020/11/18 21:39
 */
public class Sort134 {

    public static void main(String[] args) {
        int[] gas = new int[]{5, 1, 2, 3, 4};
        int[] cost = new int[]{4, 4, 1, 5, 1};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        for (int startIndex = 0; startIndex < gas.length; startIndex++) {
            boolean isExist = true;
            int rest = gas[startIndex];
            if (rest < cost[startIndex]) {
                continue;
            }
            for (int j = startIndex + 1; j != startIndex; j++) {
                int current;
                if (j == gas.length) {
                    j = 0;
                    current = gas.length - 1;
                } else {
                    current = j - 1;
                }
                rest -= cost[current];
                if (rest < 0) {
                    isExist = false;
                    break;
                }
                rest += gas[j];
                if (j == startIndex) {
                    break;
                }
                int next = j + 1;
                // 最后一站就是余量减去到始发站的耗油量(始发站的油一开始就被用掉了, 所以这里不能加)
                if (next == startIndex) {
                    rest = rest - cost[j];
                    if (rest < 0) {
                        isExist = false;
                        break;
                    }
                }
            }
            if (isExist) {
                return startIndex;
            }
        }
        return -1;
    }
}
