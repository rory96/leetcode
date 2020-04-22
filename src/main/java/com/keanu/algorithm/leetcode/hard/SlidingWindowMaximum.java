package com.keanu.algorithm.leetcode.hard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 239 - hard - 滑动窗口的最大值
 */
public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> queue = new ArrayDeque<>(k);
        int[] res = new int[nums.length - k + 1];
        int j = 0;
        for (int value : nums) {
            queue.offerLast(value);
            if (queue.size() < k) continue;
            int max = Integer.MIN_VALUE;
            for (int num : queue) {
                max = Math.max(max, num);
            }
            queue.pollFirst();
            res[j++] = max;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));
    }
}
