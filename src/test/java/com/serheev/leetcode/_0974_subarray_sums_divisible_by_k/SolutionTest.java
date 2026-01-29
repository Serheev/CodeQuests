package com.serheev.leetcode._0974_subarray_sums_divisible_by_k;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    @DisplayName("Example 1: [4,5,0,-2,-3,1], k=5 → 7 subarrays")
    void testExample1() {
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;
        assertEquals(7, solution.subarraysDivByK(nums, k));
    }

    @Test
    @DisplayName("Example 2: [5], k=9 → 0 subarrays")
    void testExample2() {
        int[] nums = {5};
        int k = 9;
        assertEquals(0, solution.subarraysDivByK(nums, k));
    }

    @Test
    @DisplayName("All zeros: [0,0,0], k=3 → 6 subarrays")
    void testAllZeros() {
        int[] nums = {0, 0, 0};
        int k = 3;
        assertEquals(6, solution.subarraysDivByK(nums, k));
    }

    @Test
    @DisplayName("Negative numbers: [2,-2,2,-4], k=6 → 3 subarrays")
    void testNegativeNumbers() {
        int[] nums = {2, -2, 2, -4};
        int k = 6;
        assertEquals(2, solution.subarraysDivByK(nums, k));
    }

    @Test
    @DisplayName("Large k: [5,0,0,0], k=100000 → 0 subarrays")
    void testLargeK() {
        int[] nums = {5, 0, 0, 0};
        int k = 100000;
        assertEquals(6, solution.subarraysDivByK(nums, k));
    }

    @Test
    @DisplayName("Mixed values: [1,2,3,4,5], k=3 → 4 subarrays")
    void testMixedValues() {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 3;
        assertEquals(7, solution.subarraysDivByK(nums, k));
    }

    @Test
    @DisplayName("No valid subarrays: [1,2,4], k=7 → 0 subarrays")
    void testNoValidSubarrays() {
        int[] nums = {1, 2, 4};
        int k = 7;
        assertEquals(1, solution.subarraysDivByK(nums, k));
    }

    @Test
    @DisplayName("Single element divisible: [6], k=3 → 1 subarray")
    void testSingleElementDivisible() {
        int[] nums = {6};
        int k = 3;
        assertEquals(1, solution.subarraysDivByK(nums, k));
    }

    @Test
    @DisplayName("Single element not divisible: [7], k=3 → 0 subarrays")
    void testSingleElementNotDivisible() {
        int[] nums = {7};
        int k = 3;
        assertEquals(0, solution.subarraysDivByK(nums, k));
    }

    @Test
    @DisplayName("Long array with repeating pattern")
    void testRepeatingPattern() {
        int[] nums = {1, 2, 1, 2, 1, 2};
        int k = 3;
        assertEquals(9, solution.subarraysDivByK(nums, k));
    }
}