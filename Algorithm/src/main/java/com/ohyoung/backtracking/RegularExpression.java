package com.ohyoung.backtracking;

/**
 * 正则表达式
 * @author ouyb01
 * @date 2021/12/3 9:51
 */
public class RegularExpression {

    private boolean matched = false;
    /**
     * 正则表达式
     */
    private char[] pattern;
    /**
     * 正则表达式长度
     */
    private int patternLength;

    public RegularExpression(char[] pattern, int patternLength) {
        this.pattern = pattern;
        this.patternLength = patternLength;
    }

    public boolean match(char[] text, int textLength) {
        matched = false;
        rematch(0 ,0, text, textLength);
        return matched;
    }

    /**
     *
     * @param textCurrentIndex 待匹配串当前匹配的位置
     * @param patterCurrentIndex 表达式当前匹配的位置
     * @param text 待匹配串
     * @param textLength 待匹配串长度
     */
    private void rematch(int textCurrentIndex, int patterCurrentIndex, char[] text, int textLength) {
        // 匹配成功, 终止递归
        if (matched) {
            return;
        }
        // 正则表达式匹配完了且文本串也匹配完了
        if (patterCurrentIndex == patternLength) {
            // 这里不能合并到上一个if, 不同情况要分开讨论
            if (textCurrentIndex == textLength){
                matched = true;
            }
            return;
        }
        // *号匹配任意字符
        if (pattern[patterCurrentIndex] == '*') {
            for (int i = 0; i <= textLength - textCurrentIndex; i++) {
                // 从当前位置+1开始匹配, 尝试各种长度的匹配结果
                rematch(textCurrentIndex + i, patterCurrentIndex + 1, text, textLength);
            }
            // ?匹配0个或1个字符
        } else if (pattern[patterCurrentIndex] == '?') {
            // 匹配串不动, 表达式串前移
            rematch(textCurrentIndex, patterCurrentIndex + 1, text, textLength);
            // 匹配串和表达式串都前移
            rematch(textCurrentIndex + 1, patterCurrentIndex + 1, text, textLength);
            // 纯字符串对比必须匹配
        } else if (textCurrentIndex < textLength && pattern[patterCurrentIndex] == text[textCurrentIndex]) {
            rematch(textCurrentIndex + 1, patterCurrentIndex + 1, text, textLength);
        }
    }

    public static void main(String[] args) {
        RegularExpression example = new RegularExpression(new char[]{'1', '2', '3', '*'}, 4);
        System.out.println(example.match(new char[]{'1', '2', '3'}, 3));
        System.out.println(example.match(new char[]{'1', '2', '4'}, 3));
        System.out.println(example.match(new char[]{'1', '2', '3', '7', '8'}, 5));
    }
}
