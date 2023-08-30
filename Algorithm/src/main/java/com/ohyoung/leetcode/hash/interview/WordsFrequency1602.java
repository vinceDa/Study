package com.ohyoung.leetcode.hash.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 16.02. 单词频率
 *
 * 设计一个方法，找出任意指定单词在一本书中的出现频率。
 *
 * 你的实现应该支持如下操作：
 * WordsFrequency(book)构造函数，参数为字符串数组构成的一本书
 * get(word)查询指定单词在书中出现的频率
 *
 * 示例：
 * WordsFrequency wordsFrequency = new WordsFrequency({"i", "have", "an", "apple", "he", "have", "a", "pen"});
 * wordsFrequency.get("you"); //返回0，"you"没有出现过
 * wordsFrequency.get("have"); //返回2，"have"出现2次
 * wordsFrequency.get("an"); //返回1
 * wordsFrequency.get("apple"); //返回1
 * wordsFrequency.get("pen"); //返回1
 *
 * 提示：
 * book[i]中只包含小写字母
 * 1 <= book.length <= 100000
 * 1 <= book[i].length <= 10
 * get函数的调用次数不会超过100000
 *
 * <a href="https://leetcode-cn.com/problems/words-frequency-lcci/"></a>
 * @author vince 2023/8/21 10:10
 */
public class WordsFrequency1602 {

    private Map<String, Integer> statistics;
    public static void main(String[] args) {
        WordsFrequency1602 wordsFrequency = new WordsFrequency1602(new String[]{"i", "have", "an", "apple", "he", "have", "a", "pen"});
        System.out.println(wordsFrequency.get("you"));
        System.out.println(wordsFrequency.get("have"));
        System.out.println(wordsFrequency.get("an"));
        System.out.println(wordsFrequency.get("apple"));
        System.out.println(wordsFrequency.get("pen"));
    }

    public WordsFrequency1602(String[] book) {
        statistics = new HashMap<>();
        for (String s : book) {
            statistics.put(s, statistics.getOrDefault(s, 0) + 1);
        }
    }

    public int get(String word) {
        return statistics.getOrDefault(word, 0);
    }
}
