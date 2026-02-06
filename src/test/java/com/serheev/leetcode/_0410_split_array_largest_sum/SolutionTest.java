package com.serheev.leetcode._0410_split_array_largest_sum;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    private void assertSplit(int[] nums, int k, int expected) {
        assertEquals(expected, solution.splitArray(nums, k));
    }

    @Test
    @DisplayName("Example 1 from LeetCode")
    void t1() {
        assertSplit(new int[]{7, 2, 5, 10, 8}, 2, 18);
    }

    @Test
    @DisplayName("Example 2 from LeetCode")
    void t2() {
        assertSplit(new int[]{1, 2, 3, 4, 5}, 2, 9);
    }

    @Test
    @DisplayName("Single element, k=1")
    void t3() {
        assertSplit(new int[]{10}, 1, 10);
    }

    @Test
    @DisplayName("All elements equal, k equals length")
    void t4() {
        assertSplit(new int[]{5, 5, 5, 5}, 4, 5);
    }

    @Test
    @DisplayName("All elements equal, k=1")
    void t5() {
        assertSplit(new int[]{5, 5, 5, 5}, 1, 20);
    }

    @Test
    @DisplayName("Strictly increasing array")
    void t6() {
        assertSplit(new int[]{1, 2, 3, 4, 5, 6}, 3, 9);
    }

    @Test
    @DisplayName("Strictly decreasing array")
    void t7() {
        assertSplit(new int[]{9, 8, 7, 6, 5}, 2, 18);
    }

    @Test
    @DisplayName("Large values, k=3")
    void t8() {
        assertSplit(new int[]{100, 200, 300, 400, 500}, 3, 600);
    }

    @Test
    @DisplayName("Large values, k=5 (each element its own subarray)")
    void t9() {
        assertSplit(new int[]{100, 200, 300, 400, 500}, 5, 500);
    }

    @Test
    @DisplayName("Mixed small and large values")
    void t10() {
        assertSplit(new int[]{1, 10, 100, 1000}, 2, 1000);
    }

    @Test
    @DisplayName("Edge case: minimal input")
    void t12() {
        assertSplit(new int[]{1}, 1, 1);
    }
}
