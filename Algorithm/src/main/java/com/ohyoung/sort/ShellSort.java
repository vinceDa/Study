package com.ohyoung.sort;


import java.util.Arrays;

/**
 * ϣ������
 * ϣ�������ǰѼ�¼���±��һ���������飬��ÿ��ʹ��ֱ�Ӳ��������㷨����
 *
 * @author ohYoung
 * @date 2020/12/14 17:17
 */
public class ShellSort {

    public static void main(String[] args) {
        String[] a = new String[]{"a", "s", "s", "b"};
        sort(a);
        // sortWithSentinel(a);
        System.out.println(Arrays.toString(a));
    }


    private static void sort(Comparable[] a) {
        int gap = a.length / 2;
        while (gap > 1) {
            //�ӵ�gap��Ԫ�أ�����������������ֱ�Ӳ����������
            for (int i = gap; i < a.length; i+=gap) {
                int j = i;
                Comparable temp = a[j];
                if (CompareUtil.less(a[j], a[j - gap])) {
                    while (j - gap >= 0 && CompareUtil.less(temp, a[j-gap])) {
                        a[j] = a[j - gap];
                        j -= gap;
                    }
                    // �ƶ����ҵ������temp��λ��j
                    a[j] = temp;
                }
            }
            gap = gap / 2;
        }
    }

}
