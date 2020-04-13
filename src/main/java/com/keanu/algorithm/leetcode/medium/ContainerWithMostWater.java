package com.keanu.algorithm.leetcode.medium;

/**
 * 11 - medium
 */
public class ContainerWithMostWater {

    /**
     * 左右边界，i，j，向中间收敛
     * @param nums Height Arrays
     * @return maxArea
     */
    public static int maxArea(int[] nums) {
        int max = 0;
        for (int i = 0, j = nums.length - 1; i < j;) {
            int minHeight = nums[i] < nums[j] ? nums[i++] : nums[j--];
            int area = (j - i + 1) * minHeight;
            max = Math.max(max, area);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(nums));
    }
}
