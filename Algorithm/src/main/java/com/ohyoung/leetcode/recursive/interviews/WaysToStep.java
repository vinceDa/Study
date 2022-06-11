package com.ohyoung.leetcode.recursive.interviews;

/**
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。
 * 结果可能很大，你需要对结果模1000000007。
 *
 * 示例1:
 *  输入：n = 3
 *  输出：4
 *  说明: 有四种走法
 *
 * 示例2:
 *  输入：n = 5
 *  输出：13
 *
 * 提示:
 * n范围在[1, 1000000]之间
 *
 * 链接：<a href="https://leetcode.cn/problems/three-steps-problem-lcci">...</a>
 *
 * 设n阶有f(n)种跳法, 在最后一步中只存在以下几种情况
 * 只剩1阶, 之前有n-1阶, 对应有f(n-1)种跳法
 * 只剩2阶, 之前有剩下n-2阶, 对应有f(n-2)种跳法
 * 只剩3阶, 之前有剩下n-3阶, 对应有f(n-3)种跳法
 * f(n)是以上三种情况之和, f(n) = f(n-1) + f(n-2) + f(n-3)
 * f(0)不管, f(1) = 1, f(2) = 2, f(3) = 4
 * @author ouyb01
 * @date 2022/6/9 9:27
 */
public class WaysToStep {

    public static void main(String[] args) {
        WaysToStep example = new WaysToStep();
        System.out.println(example.waysToStep(3));
        System.out.println(example.waysToStep(5));
        System.out.println(example.waysToStep(61));
    }

    int[] mem = new int[1000000];
    int mod = 1000000007;

    public int waysToStep(int n) {
        if (mem[n] != 0) {
            return mem[n] % mod;
        }
        if (n == 1) {
            mem[n] = 1;
            return mem[n];
        } else  if (n == 2) {
            mem[n] = 2;
            return mem[n];
        } else  if (n == 3) {
            mem[n] = 4;
            return mem[n];
        }
        // 这里先对前两数取余, 因为三数相加可能会超限
        mem[n] = ((waysToStep(n - 1) + waysToStep(n - 2)) % mod + waysToStep(n - 3)) % mod;
        return mem[n];
    }

}
