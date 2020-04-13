package com.keanu.algorithm.leetcode.easy;

/**
 * 70 - easy
 */
public class ClimbingStairs {

    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int x = 1, y = 2, z = 3;
        for (int i = 3; i <= n; i++) {
            z = x + y;
            x = y;
            y = z;
        }
        return z;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(2));
    }
}
