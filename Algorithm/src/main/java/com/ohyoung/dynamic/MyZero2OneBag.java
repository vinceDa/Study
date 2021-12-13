package com.ohyoung.dynamic;

/**
 * 0-1背包问题
 * 我们有一个背包，背包总的承载重量是 Wkg。现在我们有 n 个物品，每个物品的重量不等，并且不可分割。
 * 我们现在期望选择几件物品，装载到背包中。在不超过背包所能装载重量的前提下，如何让背包中物品的总重量最大？
 *
 * 动态规划
 * @author ohYoung
 * @date 2021/12/2 23:03
 */
public class MyZero2OneBag {

    /**
     * 存储背包中物品总量的最大值
     */
    public int maxWeight = Integer.MIN_VALUE;

    /**
     * 动态规划的方式实现0-1背包问题
     * @param weight 物品重量
     * @param totalCount 物品个数
     * @param maxWeight 背包总承重
     * @return 能放入背包的最大总重量
     */
    public int knapsack(int[] weight, int totalCount, int maxWeight) {
        boolean[][] states = new boolean[totalCount][maxWeight + 1];
        // 第一行特殊处理
        // 第一个物品不加入背包
        states[0][0] = true;
        // 第一个物品加入背包
        if (weight[0] <= maxWeight) {
            states[0][weight[0]] = true;
        }
        // 动态规划转移, 第一行已处理, i从1开始
        for (int i = 1; i < totalCount; i++) {
            // 第i行不放入背包
            for (int j = 0; j <= maxWeight; j++) {
                if (states[i - 1][j]) {
                    states[i][j] = true;
                }
            }
            // 第i行放入背包
            for (int j = 0; j <= maxWeight - weight[i]; j++) {
                if (states[i - 1][j]) {
                    states[i][j + weight[i]] = true;
                }
            }
        }
        // 输出结果
        for (int i = maxWeight; i > 0; i--) {
            if (states[totalCount - 1][i]) {
                return i;
            }
        }
        return 0;
    }

    /**
     * knapsack方法需要一个totalCount*(maxWeight+1)大小的数组, 这个方法主要优化这个空间消耗
     */
    public int knapsack2(int[] weight, int totalCount, int maxWeight) {
        boolean[] states = new boolean[maxWeight + 1];
        states[0] = true;
        if (weight[0] < maxWeight) {
            states[weight[0]] = true;
        }
        // 动态规划
        for (int i = 0; i < totalCount; i++) {
            // 把第i个物品放入背包
            for (int j = maxWeight - weight[i]; j >= 0; j--) {
                if (states[i]) {
                    states[j + weight[i]] = true;
                }
            }
        }
        // 输出结果
        for (int i = maxWeight; i >= 0; i--) {
            if (states[i]) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        MyZero2OneBag example = new MyZero2OneBag();
        int[] items = new int[]{1, 4, 7};
        System.out.println(example.knapsack(items, items.length, 10));
    }
}
