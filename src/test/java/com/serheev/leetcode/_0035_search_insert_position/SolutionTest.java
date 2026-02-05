package com.serheev.leetcode._0035_search_insert_position;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    private void assertPos(int[] nums, int target, int expected) {
        assertEquals(expected, solution.searchInsert(nums, target));
    }

    @Test
    @DisplayName("Target found in the middle")
    void t1() {
        assertPos(new int[]{1, 3, 5, 6}, 5, 2);
    }

    @Test
    @DisplayName("Target found at the beginning")
    void t2() {
        assertPos(new int[]{1, 3, 5, 6}, 1, 0);
    }

    @Test
    @DisplayName("Target found at the end")
    void t3() {
        assertPos(new int[]{1, 3, 5, 6}, 6, 3);
    }

    @Test
    @DisplayName("Target not found - insert in the middle")
    void t4() {
        assertPos(new int[]{1, 3, 5, 6}, 2, 1);
    }

    @Test
    @DisplayName("Target not found - insert at the end")
    void t5() {
        assertPos(new int[]{1, 3, 5, 6}, 7, 4);
    }

    @Test
    @DisplayName("Target not found - insert at the beginning")
    void t6() {
        assertPos(new int[]{1, 3, 5, 6}, 0, 0);
    }

    @Test
    @DisplayName("Single element - insert before")
    void t7() {
        assertPos(new int[]{10}, 5, 0);
    }

    @Test
    @DisplayName("Single element - insert after")
    void t8() {
        assertPos(new int[]{10}, 20, 1);
    }

    @Test
    @DisplayName("Empty array")
    void t9() {
        assertPos(new int[]{}, 10, 0);
    }

    @Test
    @DisplayName("Negative numbers")
    void t10() {
        assertPos(new int[]{-10, -3, 0, 5}, -4, 1);
    }

    @Test
    @DisplayName("Large sorted array")
    void t11() {
        int[] nums = new int[1000];
        for (int i = 0; i < nums.length; i++) nums[i] = i * 2;
        assertPos(nums, 777, 389);
    }
}
