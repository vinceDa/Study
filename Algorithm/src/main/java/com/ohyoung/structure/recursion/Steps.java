package com.ohyoung.structure.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 *  假如这里有 n 个台阶，每次你可以跨 1 个台阶或者 2 个台阶，请问走这 n 个台阶有多少种走法？
 *  如果有 7 个台阶，你可以 2，2，2，1 这样子上去，也可以 1，2，1，1，2 这样子上去，总之走法有很多，那如何用编程求得总共有多少种走法呢？
 *
 * @author ohYoung
 * @date 2020/11/27 16:50
 */
public class Steps {
    /**
     * 表示递归深度
     *  注：最大允许的递归深度跟当前线程剩余的栈空间大小有关，事先无法计算。如果实时计算，代码过于复杂，就会影响代码的可读性。
     */
    int depth = 0;
    Map<Integer, Integer> exist = new HashMap<>();

    private int calMethodCount(int steps) {
        ++depth;
        // 避免出现堆栈溢出问题(最大深度较小时可以采用这个方法)
        if (depth >= 1000) {
            // throw new Exception();
            return -1;
        }
        // 如果map中存在则表示之前计算过直接返回, 避免重复计算
        if (exist.containsKey(steps)) {
            return exist.get(steps);
        }
        if (steps == 1) {
            return 1;
        }
        if (steps == 2) {
            return 2;
        }
        int ret = calMethodCount(steps - 1) + calMethodCount(steps - 2);
        exist.put(steps, ret);
        return ret;
    }

    public void main(String[] args) {
        System.out.println(calMethodCount(3));
    }
}
