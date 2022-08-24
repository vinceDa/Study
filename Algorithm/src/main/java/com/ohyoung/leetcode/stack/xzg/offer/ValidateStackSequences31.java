package com.ohyoung.leetcode.stack.xzg.offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，
 * 但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 * <p>
 * 示例 1：
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * <p>
 * 示例 2：
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 * <p>
 * 提示：
 * 0 <= pushed.length == popped.length <= 1000
 * 0 <= pushed[i], popped[i] < 1000
 * pushed是popped的排列。
 * <p>
 * 链接：<a href="https://leetcode.cn/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof">...</a>
 *
 * @author ouyb01
 * @date 2022/6/2 17:43
 */
public class ValidateStackSequences31 {

    public static void main(String[] args) {
        ValidateStackSequences31 example = new ValidateStackSequences31();
        int[] pushed = new int[]{1, 2, 3, 4, 5};
        int[] popped = new int[]{4, 5, 3, 2, 1};
        System.out.println(example.validateStackSequences(pushed, popped));
        popped = new int[]{4, 3, 5, 1, 2};
        System.out.println(example.validateStackSequences(pushed, popped));
        pushed = new int[]{2, 1, 0};
        popped = new int[]{1, 2, 0};
        System.out.println(example.validateStackSequences(pushed, popped));
    }

    /**
     * 定义辅助栈nums,
     * 元素压入nums的时候, 将栈顶元素和popped比较, 相同则弹出,
     * 不同则继续往nums中添加元素, 继续比较, 如果最后nums为空, 则表示
     * popped符合弹出序列, 否则不符合
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) {
            return false;
        }
        Deque<Integer> nums = new ArrayDeque<>();
        int i = 0;
        int j = 0;
        for (; i < pushed.length; i++) {
            // 判断栈顶元素和popped元素是否相等
            while (!nums.isEmpty() && nums.peek() == popped[j]) {
                nums.pop();
                j++;
            }
            // 不相等或者nums为空则推入栈
            nums.push(pushed[i]);
        }
        // 剩余的元素和popped元素应该顺序和大小都相同
        for (; j < popped.length; j++) {
            if (!nums.isEmpty() && nums.peek() == popped[j]) {
                nums.pop();
            }
        }
        return nums.isEmpty();
    }

}
