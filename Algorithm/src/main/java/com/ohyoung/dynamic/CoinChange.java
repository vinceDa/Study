package com.ohyoung.dynamic;

/**
 * 硬币找零。
 * 假设我们有几种不同币值的硬币 v1，v2，……，vn（单位是元）。
 * 如果我们要支付 w 元，求最少需要多少个硬币。
 * 比如，我们有 3 种不同的硬币，1 元、3 元、5 元，我们要支付 9 元，
 * 最少需要 3 个硬币（3 个 3 元的硬币）
 *
 * @author ohYoung
 * @date 2021/12/8 23:44
 */
public class CoinChange {

    /**
     * 状态转移表解法
     * @param money 需要支付的金额
     * @param types 不同的硬币
     */
    public int coinChange(int money, int[] types) {
        // 第一个参数表示第几个, 第二个参数表示需要支付的金额
        boolean[][] states = new boolean[money][money + 1];
        // 初始化states
        for (int type : types) {
            if (type == money) {
                return 1;
            }
            if (money >= type) {
                states[0][type] = true;
            }
        }
        for (int i = 1; i < money; i++) {
            for (int j = 1; j <= money; j++) {
                if (states[i - 1][j]) {
                    for (int type : types) {
                        if (j + type <= money) {
                            states[i][j + type] = true;
                        }
                    }
                    if (states[i][money]) {
                        return i + 1;
                    }
                }
            }
        }
        return money;
    }

    /**
     * 状态转移方程法
     * 可以看做爬阶梯问题，分别可以走1.3.5步，
     * 怎么最少走到9步，动态转移方程为f(9)=1+min(f(8),f(6),f(4))
     */
    public void coinChange2() {

    }

    public static void main(String[] args) {
        CoinChange example = new CoinChange();
        System.out.println(example.coinChange(9, new int[] {1, 3, 4, 5, 9}));;
    }

}
