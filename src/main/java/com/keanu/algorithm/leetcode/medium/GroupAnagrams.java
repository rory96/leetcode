package com.keanu.algorithm.leetcode.medium;

import java.util.*;

/**
 * 49 - medium - 异位词分组
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String tmp : strs) {
            char[] ch = tmp.toCharArray();
            Arrays.sort(ch);
            if (map.containsKey(String.valueOf(ch))) {
                map.get(String.valueOf(ch)).add(tmp);
            } else {
                List<String> list = new ArrayList<>();
                list.add(tmp);
                map.put(String.valueOf(ch), list);
            }
        }
        return new ArrayList<>(map.values());
    }
}
