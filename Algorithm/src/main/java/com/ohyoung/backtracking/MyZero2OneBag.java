package com.ohyoung.backtracking;

/**
 * 0-1背包问题
 * 我们有一个背包，背包总的承载重量是 Wkg。现在我们有 n 个物品，每个物品的重量不等，并且不可分割。
 * 我们现在期望选择几件物品，装载到背包中。在不超过背包所能装载重量的前提下，如何让背包中物品的总重量最大？
 *
 * 0-1背包问题理解：
 * 假设三个物品，每个物品在考虑时有两种选择，1-放进包，0-不放
 * 11行代码表示不放进包里。13行代码表示放进包里。
 * 三个物品遍历过程如下：
 * 0 0 0 update maxW
 * 0 0 1 update maxW
 * 0 1 0 update maxW
 * 0 1 1 update maxW
 * 1 0 0 update maxW
 * 1 0 1 update maxW
 * 1 1 0 update maxW
 * 1 1 1 update maxW
 * @author ohYoung
 * @date 2021/12/2 23:03
 */
public class MyZero2OneBag {

    /**
     * 存储背包中物品总量的最大值
     */
    public int maxWeight = Integer.MIN_VALUE;

    /**
     * 每个物品都有两种选择, 放和不放
     * @param currentIndex 当前物品个数
     * @param currentWeight 当前的总重量
     * @param items 所有物品
     * @param totalCount 物品总个数
     * @param totalWeight 总重量
     */
    public void place (int currentIndex, int currentWeight, int[] items, int totalCount, int totalWeight) {
        // 当前重量和总重量相等或者当前物品全部放到背包中
        if (currentIndex == totalCount || currentWeight == totalWeight) {
            if (currentWeight > maxWeight) {
                maxWeight = currentWeight;
            }
            return;
        }
        // 不放当前物品
        place(currentIndex + 1, currentWeight, items, items.length, totalWeight);
        // 放置当前物品
        currentWeight += items[currentIndex];
        if (currentWeight <= totalWeight) {
            place(currentIndex + 1, currentWeight, items, items.length, totalWeight);
        }
    }

    public static void main(String[] args) {
        MyZero2OneBag example = new MyZero2OneBag();
        int[] items = new int[]{1, 4, 7};
        example.place(0, 0, items, items.length, 10);
        System.out.println(example.maxWeight);
    }
}
