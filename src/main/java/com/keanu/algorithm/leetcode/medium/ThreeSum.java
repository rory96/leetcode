package com.keanu.algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 15 - Medium
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        // 这道题与TwoSum类似。找出和为0的三个数。
        // 可以用双指针的方法，但是这个方法需要将数组先进行排序。
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        if (nums[0] > 0) return result;
        for (int k = 0; k < nums.length - 2; k++) {
            if (k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                if (nums[k] + nums[i] + nums[j] > 0) {
                    j--;
                } else if (nums[k] + nums[i] + nums[j] < 0) {
                    i++;
                } else {
                    result.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    while(i < j && nums[j] == nums[--j]);
                    while(i < j && nums[i] == nums[++i]);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = threeSum(nums);
        list.forEach(ints -> ints.forEach(System.out::println));
    }
}
