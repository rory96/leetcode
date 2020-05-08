package com.keanu.algorithm.leetcode.medium;

import java.util.*;

public class Combinations {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        help(n, k, 1, stack, res);
        return res;
    }
    private static void help(int n, int k, int index, Stack<Integer> stack, List<List<Integer>> res) {
        if (stack.size() == k) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = index; i <= n - (k - stack.size()) + 1; i++) {
            stack.push(i);
            help(n, k, i + 1, stack, res);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = combine(4, 2);
        res.forEach(list -> list.forEach(System.out::print));
    }
}
