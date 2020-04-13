package com.keanu.algorithm.leetcode.easy;

import java.util.Arrays;

/**
 * 283 - easy
 */
public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        // 初始化0的位置
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    public static void moveZeroes1(int[] nums) {
        int j = 0;
        for (int i = 0;i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 0, 3, 1, 0, 12};
        moveZeroes1(nums);
        System.out.println(Arrays.toString(nums));
    }
}
