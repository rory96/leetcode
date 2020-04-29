package com.keanu.algorithm.leetcode.easy;

/**
 * 387 - easy - 字符串中第一个不重复的字符
 */
public class FirstUniqueCharacterInString {
    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) return ' ';
        int slow = 0, fast = 0;
        char[] chs = s.toCharArray();
        int[] count = new int[256];
        int len = s.length();
        while (fast < len) {
            count[chs[fast++]]++;
            while (slow < len && count[chs[slow]] > 1) slow++;
            if (slow == len) return ' ';
        }
        return chs[slow];
    }
}
