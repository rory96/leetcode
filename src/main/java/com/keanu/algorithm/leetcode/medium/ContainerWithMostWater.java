package com.keanu.algorithm.leetcode.medium;

public class ContainerWithMostWater {

    public static int maxArea(int[] nums) {
        int max = 0;
        for (int i = 0, j = nums.length - 1; i < j;) {
            int area = (j - i) * Math.min(nums[i], nums[j]);
            max = Math.max(max, area);
            if (nums[i] < nums[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(nums));
    }
}
