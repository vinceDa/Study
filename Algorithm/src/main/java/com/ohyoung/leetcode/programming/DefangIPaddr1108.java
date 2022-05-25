package com.ohyoung.leetcode.programming;

/**
 * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 * <p>
 * 示例 1：
 * 输入：address = "1.1.1.1"
 * 输出："1[.]1[.]1[.]1"
 * <p>
 * 示例 2：
 * 输入：address = "255.100.50.0"
 * 输出："255[.]100[.]50[.]0"
 * <p>
 * 提示：
 * 给出的address是一个有效的 IPv4 地址
 *
 * @author ohYoung
 * @date 2022/5/25 7:56
 */
public class DefangIPaddr1108 {

    public static void main(String[] args) {
        DefangIPaddr1108 example = new DefangIPaddr1108();
        String address = "1.1.1.1";
        System.out.println("defangIPaddr: " + example.defangIPaddr(address));
        address = "255.100.50.0";
        System.out.println("defangIPaddr: " + example.defangIPaddr(address));
    }

    public String defangIPaddr(String address) {
        // 1. 将String转为char[]
        char[] addressCharArray = address.toCharArray();
        // 2. 定义一个目标char[]存储address的元素和需要转换后的元素, 它的长度是2 * 3(每个.都需要额外2个位置添加[和])
        char[] targetArray = new char[addressCharArray.length + 2 * 3];
        // 3.定义目标char[]的下标k
        int k = 0;
        // 4. 遍历char[]的每一个元素, 如果当前元素不为.则直接装填到目标char[], 否则转换成[.]
        for (int i = 0; i < addressCharArray.length; i++) {
            if (addressCharArray[i] != '.') {
                targetArray[k++] = addressCharArray[i];
            } else {
                targetArray[k++] = '[';
                targetArray[k++] = '.';
                targetArray[k++] = ']';
            }
        }
        // 5. 将目标char[]转String后返回
        return new String(targetArray);
    }

}
