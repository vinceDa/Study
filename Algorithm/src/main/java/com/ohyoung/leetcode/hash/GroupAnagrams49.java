package com.ohyoung.leetcode.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 49. 字母异位词分组
 *
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 *
 * 示例 1:
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * 示例 2:
 * 输入: strs = [""]
 * 输出: [[""]]
 *
 * 示例 3:
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 *
 * 提示：
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 *
 * <a href="https://leetcode-cn.com/problems/group-anagrams/"></a>
 * @author vince 2023/8/21 11:45
 */
public class GroupAnagrams49 {

    public static void main(String[] args) {
        GroupAnagrams49 groupAnagrams = new GroupAnagrams49();
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams.groupAnagrams(strs));
        strs = new String[]{""};
        System.out.println(groupAnagrams.groupAnagrams(strs));
        strs = new String[]{"a"};
        System.out.println(groupAnagrams.groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();

        for (String str : strs) {
            int[] counter = new int[26];
            for (int i1 = 0; i1 < str.length(); i1++) {
                counter[str.charAt(i1) - 'a']++;
            }
            // 将每个出现次数大于0的字母和出现次数按顺序拼接成字符串，作为key，例如key=a3b2h3
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (counter[i] > 0) {
                    sb.append((char)(i + 'a')).append(counter[i]);
                }
            }
            String key = sb.toString();
            List<String> list = res.getOrDefault(key, new ArrayList<>());
            list.add(str);
            res.put(key, list);
        }
        return new ArrayList<>(res.values());
    }

}
