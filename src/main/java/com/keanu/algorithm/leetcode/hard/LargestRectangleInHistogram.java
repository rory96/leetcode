package com.keanu.algorithm.leetcode.hard;

import java.util.Stack;

/**
 * 84 - hard - 柱状图中的最大矩形
 */
public class LargestRectangleInHistogram {

    /**
     * 解法1：使用数组
     * @param heights 柱状图数组
     * @return 最大矩形面积
     */
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        left[0] = -1;
        right[heights.length - 1] = heights.length;
        // 计算每个元素的左边界
        for (int i = 1; i < heights.length - 1; i++) {
            int p = i - 1;
            while (p >= 0 && heights[p] >= heights[i]) p = left[p];
            left[i] = p;
        }
        // 计算每个元素的右边界
        for (int i = heights.length - 2; i >= 0; i--) {
            int p = i + 1;
            while (p < heights.length && heights[p] >= heights[i]) p = right[p];
            right[i] = p;
        }
        // 计算最大面积
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            max = Math.max(max, heights[i] * (right[i] - left[i] - 1));
        }
        return max;
    }

    /**
     * 解法2：使用栈
     * @param heights 柱状图数组
     * @return 最大矩形面积
     */
    public int largestRectangleArea1(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != 1 && heights[stack.peek()] >= heights[i]) max = Math.max(max, heights[stack.pop()] * (i - stack.peek() - 1));
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int h = stack.pop();
            max = Math.max(max, heights[h] * (h - stack.peek() - 1));
        }
        return max;
    }
}
