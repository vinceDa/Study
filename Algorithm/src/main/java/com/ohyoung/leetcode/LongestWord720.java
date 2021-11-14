package com.ohyoung.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *  给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返回答案中字典序最小的单词。
 *
 * 若无答案，则返回空字符串。
 *
 *示例 1：
 *
/-------- -*-* 输入：
 * words = ["w","wo","wor","worl", "world"]
 * 输出："world"
 * 解释：
 * 单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。
 * 示例 2：
 *
 * 输入：
 * words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * 输出："apple"
 * 解释：
 * "apply"和"apple"都能由词典中的单词组成。但是"apple"的字典序小于"apply"。
 *
 * @author ohYoung
 * @date 2020-12-04 09:47:39
 */
public class LongestWord720 {

    public static void main(String[] args) {
        LongestWord720 example = new LongestWord720();
        String[] words = new String[]{"w", "wo", "wor", "worl", "world"};
        System.out.println(example.longestWord(words));
        words = new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"};
        System.out.println(example.longestWord(words));
        words = new String[]{"b","br","bre","brea","break","breakf","breakfa","breakfas","breakfast","l","lu","lun","lunc","lunch","d","di","din","dinn","dinne","dinner"};
        System.out.println(example.longestWord(words));
        words = new String[]{"m","mo","moc","moch","mocha","l","la","lat","latt","latte","c","ca","cat"};
        System.out.println(example.longestWord(words));
    }

    public String longestWord(String[] words) {
        String ans = "";
        Set<String> wordSet = new HashSet<>();
        wordSet.addAll(Arrays.asList(words));
        for (String word: words) {
            if (word.length() > ans.length() ||
                    word.length() == ans.length() && word.compareTo(ans) < 0) {
                boolean good = true;
                for (int k = 1; k < word.length(); ++k) {
                    if (!wordSet.contains(word.substring(0, k))) {
                        good = false;
                        break;
                    }
                }
                if (good) {
                    ans = word;
                }
            }
        }
        return ans;
    }

    private void sortByWordLength(String[] words) {

    }

    private Integer countWord(String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            count += (word.charAt(i) - 'a') * Math.pow(26, i);
        }
        return count;
    }
}