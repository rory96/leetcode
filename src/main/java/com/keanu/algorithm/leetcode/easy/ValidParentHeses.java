package com.keanu.algorithm.leetcode.easy;

import java.util.Map;
import java.util.Stack;

/**
 * 20 - easy - 有效的括号
 * 栈
 */
public class ValidParentHeses {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        Map<Character, Character> map = Map.of(
                '{', '}',
                '[', ']',
                '(', ')'
        );
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(map.get(c));
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
