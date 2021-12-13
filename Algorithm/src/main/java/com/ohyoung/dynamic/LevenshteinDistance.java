package com.ohyoung.dynamic;

/**
 * 编码实现莱文斯坦距离
 *
 * @author ouyb01
 * @date 2021/12/9 12:58
 */
public class LevenshteinDistance {

    private char[] a = "mitcmu".toCharArray();
    private char[] b = "mtacnu".toCharArray();
    private int n = 6;
    private int m = 6;
    // 存储结果
    private int minDist = Integer.MAX_VALUE;
    // 调用方式 lwstBT(0, 0, 0)
    public void lwstBT(int aIndex, int bIndex, int edist) {
        if (aIndex == n || bIndex == m) {
            if (aIndex < n) {
                edist += (n - aIndex);
            }
            if (bIndex < m) {
                edist += (m - bIndex);
            }
            if (edist < minDist) {
                minDist = edist;
            }
            return;
        }
        // 两个字符匹配
        if (a[aIndex] == b[bIndex]) {
            lwstBT(aIndex + 1, bIndex + 1, edist);
            // 不匹配
        } else {
            // 删除a[i]或者b[j]前添加一个字符
            lwstBT(aIndex + 1, bIndex, edist + 1);
            // 删除b[j]或者a[i]前添加一个字符
            lwstBT(aIndex, bIndex + 1, edist + 1);
            // 将a[i]和b[j]替换为相同字符
            lwstBT(aIndex + 1, bIndex + 1, edist + 1);
        }
    }

    public static void main(String[] args) {
        LevenshteinDistance example = new LevenshteinDistance();
        example.lwstBT(0, 0, 0);
        System.out.println(example.minDist);
    }

}
