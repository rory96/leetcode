package com.keanu.algorithm.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1 - easy - two sum
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[2];
    }

    /**
     * 解法2：效率更高，二进制按位与
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        int volume = 2048; // 100000000000
        int bitMode = volume - 1; //011111111111
        int[] res = new int[volume];
        for(int i = 0; i < nums.length; i++) {
            int c = (target - nums[i]) & bitMode;
            if (res[c] != 0) return new int[] {res[c] - 1, i};
            res[nums[i] & bitMode] = i + 1;
        }
        return null;
    }
}
