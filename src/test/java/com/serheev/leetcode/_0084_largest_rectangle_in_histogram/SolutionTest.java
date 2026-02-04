package com.serheev.leetcode._0084_largest_rectangle_in_histogram;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    private void assertArea(int[] heights, int expected) {
        assertEquals(expected, solution.largestRectangleArea(heights));
    }

    @Test
    @DisplayName("LeetCode example")
    void t1() {
        assertArea(new int[]{2, 1, 5, 6, 2, 3}, 10);
    }

    @Test
    @DisplayName("Strictly increasing heights")
    void t2() {
        assertArea(
                new int[]{1, 2, 3, 4, 5}, 9 // bars 3,4,5 → height 3 * width 3
        );
    }

    @Test
    @DisplayName("Strictly decreasing heights")
    void t3() {
        assertArea(
                new int[]{5, 4, 3, 2, 1}, 9 // bars 5,4,3 → height 3 * width 3
        );
    }

    @Test
    @DisplayName("All equal heights")
    void t4() {
        assertArea(new int[]{4, 4, 4, 4}, 16);
    }

    @Test
    @DisplayName("Single bar")
    void t5() {
        assertArea(new int[]{7}, 7);
    }

    @Test
    @DisplayName("Two bars: second taller")
    void t6() {
        assertArea(new int[]{2, 10}, 10);
    }

    @Test
    @DisplayName("Two bars: first taller")
    void t7() {
        assertArea(new int[]{10, 2}, 10);
    }

    @Test
    @DisplayName("Mixed heights with multiple local minima")
    void t8() {
        assertArea(
                new int[]{6, 2, 5, 4, 5, 1, 6}, 12 // classic example: rectangle at heights 5,4,5
        );
    }

    @Test
    @DisplayName("Plateau in the middle")
    void t9() {
        assertArea(
                new int[]{2, 2, 2, 5, 5, 5, 2, 2}, 16 // 2 * width 8
        );
    }

    @Test
    @DisplayName("Empty array")
    void t10() {
        assertArea(new int[]{}, 0);
    }

    @Test
    @DisplayName("Zeros inside histogram")
    void t11() {
        assertArea(new int[]{2, 0, 2}, 2);
    }

    @Test
    @DisplayName("Tall bar surrounded by small bars")
    void t12() {
        assertArea(new int[]{1, 1, 10, 1, 1}, 10);
    }

    @Test
    @DisplayName("Large rectangle formed by middle section")
    void t13() {
        assertArea(
                new int[]{3, 6, 5, 7, 4, 8, 1, 0}, 20 // bars 6,5,7,4 → height 5 * width 4
        );
    }
}
