package com.serheev.leetcode._0042_trapping_rain_water;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    private void assertWater(int[] height, int expected) {
        assertEquals(expected, solution.trap(height));
    }

    @Test
    @DisplayName("LeetCode example")
    void t1() {
        assertWater(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}, 6);
    }

    @Test
    @DisplayName("Simple valley")
    void t2() {
        assertWater(new int[]{2, 0, 2}, 2);
    }

    @Test
    @DisplayName("Strictly increasing heights")
    void t3() {
        assertWater(new int[]{1, 2, 3, 4, 5}, 0);
    }

    @Test
    @DisplayName("Strictly decreasing heights")
    void t4() {
        assertWater(new int[]{5, 4, 3, 2, 1}, 0);
    }

    @Test
    @DisplayName("Flat surface")
    void t5() {
        assertWater(new int[]{3, 3, 3, 3}, 0);
    }

    @Test
    @DisplayName("Multiple pits")
    void t6() {
        assertWater(new int[]{4, 2, 0, 3, 2, 5}, 9);
    }

    @Test
    @DisplayName("Tall walls with deep pit")
    void t7() {
        assertWater(new int[]{5, 0, 0, 0, 5}, 15);
    }

    @Test
    @DisplayName("Single element")
    void t8() {
        assertWater(new int[]{7}, 0);
    }

    @Test
    @DisplayName("Two elements")
    void t9() {
        assertWater(new int[]{5, 1}, 0);
    }

    @Test
    @DisplayName("Empty array")
    void t10() {
        assertWater(new int[]{}, 0);
    }

    @Test
    @DisplayName("Plateau then drop")
    void t11() {
        assertWater(new int[]{3, 3, 3, 1, 2}, 1);
    }

    @Test
    @DisplayName("Complex shape with multiple basins")
    void t12() {
        assertWater(new int[]{2, 1, 0, 2, 1, 0, 3, 1, 0, 1, 2}, 10);
    }
}
