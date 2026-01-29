package com.serheev.leetcode._0560_subarray_sum_equals_k;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    @DisplayName("Example 1: nums = [1,1,1], k = 2 → 2")
    void shouldReturnTwoForExampleOne() {
        int result = solution.subarraySum(new int[]{1, 1, 1}, 2);
        assertEquals(2, result);
    }

    @Test
    @DisplayName("Example 2: nums = [1,2,3], k = 3 → 2")
    void shouldReturnTwoForExampleTwo() {
        int result = solution.subarraySum(new int[]{1, 2, 3}, 3);
        assertEquals(2, result);
    }

    @Test
    @DisplayName("Example 2: nums = [1,2,3], k = 6 → 1")
    void shouldReturnTwoForExampleThree() {
        int result = solution.subarraySum(new int[]{1, 2, 3}, 6);
        assertEquals(1, result);
    }

    @Test
    @DisplayName("Single element equals k")
    void shouldHandleSingleElementEqualToK() {
        int result = solution.subarraySum(new int[]{5}, 5);
        assertEquals(1, result);
    }

    @Test
    @DisplayName("Single element not equal to k")
    void shouldHandleSingleElementNotEqualToK() {
        int result = solution.subarraySum(new int[]{5}, 3);
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Array with negative numbers")
    void shouldHandleNegativeNumbers() {
        int result = solution.subarraySum(new int[]{1, -1, 1}, 1);
        assertEquals(3, result);
    }

    @Test
    @DisplayName("k = 0 case")
    void shouldHandleZeroK() {
        int result = solution.subarraySum(new int[]{0, 0, 0}, 0);
        assertEquals(6, result);
    }

    @Test
    @DisplayName("Large values but small array")
    void shouldHandleLargeValues() {
        int result = solution.subarraySum(new int[]{1000000, -999999, 1}, 1);
        assertEquals(2, result);
    }

}