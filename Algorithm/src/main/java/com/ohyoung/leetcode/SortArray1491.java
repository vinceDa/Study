package com.ohyoung.leetcode;

/**
 *  给你一个整数数组 salary，数组里每个数都是唯一的，其中salary[i]是第 i 个员工的工资。
 *  请你返回去掉最低工资和最高工资以后，剩下员工工资的平均值。
 *  提示：
 *      3 <= salary.length <= 100
 *      10^3 <= salary[i] <= 10^6
 *      salary[i]是唯一的。
 *      与真实值误差在 10^-5 以内的结果都将视为正确答案。
 * @author ohYoung
 * @date 2020/11/6 14:51
 */
public class SortArray1491 {

    public static void main(String[] args) {
        System.out.println(Math.pow(10, 6));
        System.out.println(Math.pow(10, 6) > 2147483647);
        int[] salary = new int[]{48000,59000,99000,13000,78000,45000,31000,17000,39000,37000,93000,77000,33000,28000,4000,54000,67000,6000,1000,11000};
        System.out.println(calAvgWage(salary));
    }

    /**
     *  去掉最低和最高工资然后求平均值
     * @param salary 存储工资的数组
     * @return 平均工资
     */
    private static double calAvgWage(int[] salary) {
        sortSalary(salary);
        double sum = 0;
        int length = salary.length;
        for (int i = 1; i < length - 1; i++) {
            sum += salary[i];
        }
        return sum / (length - 2);
    }

    /**
     *  将工资数组排序, 使用插入排序
     * @param salary 存储工资的数组
     */
    private static void sortSalary(int[] salary) {
        int length = salary.length;
        for (int i = 0; i < length; i++) {
            for (int j = i; j > 0 && salary[j] < salary[j - 1]; j--) {
                int t = salary[j];
                salary[j] = salary[j - 1];
                salary[j - 1] = t;
            }
        }
    }

}
