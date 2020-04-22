package com.keanu.algorithm.leetcode.hard;

import java.util.Stack;

/**
 * 42 - hard = trapping rain water
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int area = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int bottom = stack.pop();
                if (stack.isEmpty()) break;
                int left = height[stack.peek()];
                area += (Math.min(height[left], height[i]) - height[bottom]) * (i - left - 1);
            }
            stack.push(i);
        }
        return area;
    }
}
