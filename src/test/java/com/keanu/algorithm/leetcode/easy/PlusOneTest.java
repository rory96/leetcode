package com.keanu.algorithm.leetcode.easy;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class PlusOneTest {

    @Test
    public void test() {
        PlusOne one = new PlusOne();
        int[] digits = new int[] {9, 9};
        System.out.println(Arrays.toString(one.plusOne(digits)));
    }
}
