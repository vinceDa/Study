package com.ohyoung.sort;

import java.util.Arrays;

/**
 * ��������
 *  Ϊ��Ҫ�������Ԫ���ṩ�ռ�, ����Ԫ���ٲ���֮ǰ�������һλ���㷨������������
 * @author ohYoung
 * @date 2020/11/5 15:56
 */
public class InsertionSort {

    public static void main(String[] args) {
        String [] a = new String[]{"a","s","s","b"};
        sort(a);
        // sortWithSentinel(a);
        System.out.println(Arrays.toString(a));
    }


    /**
     *  Ŀ��Ԫ�غ���ߵ�Ԫ�رȶ������Կ�������+1, ��������Ԫ�ض����ź����, �������ߵ�������Ҷ�ʱ, �������
     * @param a ��Ҫ�����������
     */
    private static void sort(Comparable[] a) {
        // i���Կ���������
        for (int i = 0; i < a.length; i++) {

            // TODO �����и�����, ������� a,s,s,b ��ʱ��, ����ִ�е��� a,s,b,s --> a,b,s,s; �����һ�β������, �����ֱ�Ӳ��뵽��һ����ͬԪ��(s,s)��ǰ�����
            for (int j = i; j > 0 && CompareUtil.less(a[j], a[j-1]); j--) {
                CompareUtil.exchange(a, j, j-1);
            }
        }
    }

    /**
     *  �����鳤�ȹ���ʱ, j>0���ж���Ҫ���ж��, �������ǿ����Ƚ���СԪ���ҳ������ҷ��������,
     *  �������ǾͿ��Դ�1��ʼѭ�����鲢��ɾ��j>0���ж�, �����СԪ�ؾ�����������е��ڱ�
     *  ���������ڱ�ģʽ
     */
    private static void sortWithSentinel(Comparable[] a) {
        // �ҵ���������С��Ԫ�ز����ڵ�һλ
        int min = 0;
        for (int i = 0; i < a.length; i++) {
            if (CompareUtil.less(a[i], a[min])) {
                min = i;
            }
        }
        CompareUtil.exchange(a, 0, min);
        for (int i = 1; i < a.length; i++) {
            for (int j = i; CompareUtil.less(a[j], a[j-1]); j--) {
                CompareUtil.exchange(a, j, j-1);
            }
        }
    }

}
