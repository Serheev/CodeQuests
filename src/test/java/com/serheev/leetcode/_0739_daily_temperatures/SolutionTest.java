package com.serheev.leetcode._0739_daily_temperatures;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    private void assertArray(int[] input, int[] expected) {
        assertArrayEquals(expected, solution.dailyTemperatures(input));
    }

    @Test
    @DisplayName("LeetCode example")
    void t1() {
        assertArray(new int[]{73, 74, 75, 71, 69, 72, 76, 73}, new int[]{1, 1, 4, 2, 1, 1, 0, 0});
    }

    @Test
    @DisplayName("Strictly increasing temperatures")
    void t2() {
        assertArray(new int[]{30, 40, 50, 60}, new int[]{1, 1, 1, 0});
    }

    @Test
    @DisplayName("Strictly decreasing temperatures")
    void t3() {
        assertArray(new int[]{90, 80, 70, 60}, new int[]{0, 0, 0, 0});
    }

    @Test
    @DisplayName("All equal temperatures")
    void t4() {
        assertArray(new int[]{50, 50, 50, 50}, new int[]{0, 0, 0, 0});
    }

    @Test
    @DisplayName("Single element")
    void t5() {
        assertArray(new int[]{42}, new int[]{0});
    }

    @Test
    @DisplayName("Two elements: warmer next day")
    void t6() {
        assertArray(new int[]{10, 20}, new int[]{1, 0});
    }

    @Test
    @DisplayName("Two elements: no warmer day")
    void t7() {
        assertArray(new int[]{20, 10}, new int[]{0, 0});
    }

    @Test
    @DisplayName("Mixed pattern with multiple warm-ups")
    void t8() {
        assertArray(new int[]{30, 60, 90, 40, 50, 80}, new int[]{1, 1, 0, 1, 1, 0});
    }

    @Test
    @DisplayName("Edge case: empty array")
    void t9() {
        assertArray(new int[]{}, new int[]{});
    }

    @Test
    @DisplayName("Plateau then rise")
    void t10() {
        assertArray(new int[]{70, 70, 70, 75}, new int[]{3, 2, 1, 0});
    }
}
