package com.ohyoung.structure.ahocorasik;

/**
 * @author ohYoung
 * @date 2021/10/7 12:15
 */
public class AcNode {

    public char data;
    /**
     * 字符集只包含a~z这26个字符
     */
    public AcNode[] children = new AcNode[26];
    /**
     * 结尾字符为true
     */
    public boolean isEndingChar = false;
    /**
     * 当isEndingChar=true时，记录模式串长度
     */
    public int length = -1;
    /**
     * 失败指针
     */
    public AcNode fail;

    public AcNode(char data) {
        this.data = data;
    }
}
