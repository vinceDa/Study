package com.ohyoung.geek.chapter26;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 通过Fork/Join实现斐波那契数列
 * @author ohYoung
 * @date 2020/12/19 16:11
 */
public class ForkJoinDemo {

    public static void main(String[] args) {
        // 创建分治任务线程池
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        // 创建分治任务
        Fibonacci forkJoinTask = new Fibonacci(10);
        // 启动分治任务
        Integer result = forkJoinPool.invoke(forkJoinTask);
        // 输出结果
        System.out.println(result);
    }


    static class Fibonacci extends RecursiveTask<Integer> {
        final int n;

        public Fibonacci(int n) {
            this.n = n;
        }

        protected Integer compute() {
            if (n <= 1) {
                return n;
            }
            Fibonacci f1 = new Fibonacci(n - 1);
            // 创建子任务
            f1.fork();
            Fibonacci f2 = new Fibonacci(n - 2);
            // 等待子任务结果并合并运算
            return f2.compute() + f1.join();
        }
    }


}
