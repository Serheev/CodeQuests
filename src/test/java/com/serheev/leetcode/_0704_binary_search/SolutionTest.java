package com.serheev.leetcode._0704_binary_search;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    private void assertIndex(int[] nums, int target, int expected) {
        assertEquals(expected, solution.search(nums, target));
    }

    @Test
    @DisplayName("Target in the middle")
    void t1() {
        assertIndex(new int[]{-1, 0, 3, 5, 9, 12}, 9, 4);
    }

    @Test
    @DisplayName("Target at the beginning")
    void t2() {
        assertIndex(new int[]{1, 2, 3, 4, 5}, 1, 0);
    }

    @Test
    @DisplayName("Target at the end")
    void t3() {
        assertIndex(new int[]{1, 2, 3, 4, 5}, 5, 4);
    }

    @Test
    @DisplayName("Target not found")
    void t4() {
        assertIndex(new int[]{-1, 0, 3, 5, 9, 12}, 2, -1);
    }

    @Test
    @DisplayName("Single element - found")
    void t5() {
        assertIndex(new int[]{7}, 7, 0);
    }

    @Test
    @DisplayName("Single element - not found")
    void t6() {
        assertIndex(new int[]{7}, 3, -1);
    }

    @Test
    @DisplayName("Empty array")
    void t7() {
        assertIndex(new int[]{}, 10, -1);
    }

    @Test
    @DisplayName("Negative numbers")
    void t8() {
        assertIndex(new int[]{-10, -5, -2, -1}, -5, 1);
    }

    @Test
    @DisplayName("Duplicates present (binary search returns any valid index)")
    void t9() {
        int[] nums = {1, 2, 2, 2, 3};
        int result = solution.search(nums, 2);
        assertTrue(result == 1 || result == 2 || result == 3);
    }

    @Test
    @DisplayName("Large sorted array")
    void t10() {
        int[] nums = new int[1000];
        for (int i = 0; i < nums.length; i++) nums[i] = i;
        assertIndex(nums, 777, 777);
    }
}
