package com.keanu.algorithm.leetcode.easy;

import java.util.Stack;

/**
 *
 */
public class RemoveOutermostParentheses {
    public static void main(String[] args) {
        String S = "(()())(())";
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (!stack.isEmpty()) {
                int j = stack.pop();
                if (stack.isEmpty() || S.charAt(j) == ')' || S.charAt(stack.peek()) == ')') {
                    stack.push(j);
                    stack.push(i);
                    continue;
                }

                if (S.charAt(stack.peek()) == '(') continue;
                stack.push(i);
            } else {
                stack.push(i);
            }
        }
        StringBuilder sb = new StringBuilder(S);
        while (!stack.isEmpty()) {
            int index = stack.pop();
            sb.replace(index, index + 1, "");
        }
        System.out.println(sb.toString());
    }
}
