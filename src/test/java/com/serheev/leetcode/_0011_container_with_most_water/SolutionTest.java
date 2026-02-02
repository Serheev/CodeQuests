package com.serheev.leetcode._0011_container_with_most_water;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    @DisplayName("Basic example from LeetCode")
    void t1() {
        int[] h = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        assertEquals(49, solution.maxArea(h));
    }

    @Test
    @DisplayName("Two bars only")
    void t2() {
        int[] h = {5, 5};
        assertEquals(5, solution.maxArea(h));
    }

    @Test
    @DisplayName("Strictly increasing heights")
    void t3() {
        int[] h = {1, 2, 3, 4, 5, 6};
        assertEquals(9, solution.maxArea(h)); // 3 * 3
    }

    @Test
    @DisplayName("Strictly decreasing heights")
    void t4() {
        int[] h = {6, 5, 4, 3, 2, 1};
        assertEquals(9, solution.maxArea(h));  // 3 * 3
    }

    @Test
    @DisplayName("All equal heights")
    void t5() {
        int[] h = {4, 4, 4, 4, 4};
        assertEquals(16, solution.maxArea(h)); // 4 * (5-1)
    }

    @Test
    @DisplayName("Tall bars at edges")
    void t6() {
        int[] h = {10, 1, 1, 1, 10};
        assertEquals(40, solution.maxArea(h)); // 10 * 4
    }

    @Test
    @DisplayName("Tallest bars in the middle")
    void t7() {
        int[] h = {1, 2, 100, 2, 1};
        assertEquals(4, solution.maxArea(h)); // 2 * 2
    }

    @Test
    @DisplayName("Large values")
    void t8() {
        int[] h = {10000, 1, 10000};
        assertEquals(20000, solution.maxArea(h)); // 10000 * 2
    }

    @Test
    @DisplayName("Edge case: minimal valid input")
    void t9() {
        int[] h = {1, 2};
        assertEquals(1, solution.maxArea(h));
    }

    @Test
    @DisplayName("Random-shaped valley")
    void t10() {
        int[] h = {3, 1, 2, 5, 2, 4};
        assertEquals(15, solution.maxArea(h)); // 3 * 5
    }
}
