package com.serheev.leetcode._0875_koko_eating_bananas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    private void assertSpeed(int[] piles, int h, int expected) {
        assertEquals(expected, solution.minEatingSpeed(piles, h));
    }

    @Test
    @DisplayName("Example 1 from LeetCode")
    void t1() {
        assertSpeed(new int[]{3, 6, 7, 11}, 8, 4);
    }

    @Test
    @DisplayName("Example 2 from LeetCode")
    void t2() {
        assertSpeed(new int[]{30, 11, 23, 4, 20}, 5, 30);
    }

    @Test
    @DisplayName("Example 3 from LeetCode")
    void t3() {
        assertSpeed(new int[]{30, 11, 23, 4, 20}, 6, 23);
    }

    @Test
    @DisplayName("Single pile, single hour")
    void t4() {
        assertSpeed(new int[]{100}, 1, 100);
    }

    @Test
    @DisplayName("Single pile, many hours")
    void t5() {
        assertSpeed(new int[]{100}, 10, 10);
    }

    @Test
    @DisplayName("All piles equal")
    void t6() {
        assertSpeed(new int[]{5, 5, 5, 5}, 8, 3);
    }

    @Test
    @DisplayName("Large values, tight time")
    void t7() {
        assertSpeed(new int[]{1000000000, 1000000000}, 3, 1000000000);
    }

    @Test
    @DisplayName("Large values, enough time")
    void t8() {
        assertSpeed(new int[]{1000000000, 1000000000}, 10, 200000000);
    }

    @Test
    @DisplayName("Many small piles")
    void t9() {
        assertSpeed(new int[]{1, 1, 1, 1, 1, 1, 1, 1}, 8, 1);
    }

    @Test
    @DisplayName("Hours equal number of piles")
    void t10() {
        assertSpeed(new int[]{3, 6, 7, 11}, 4, 11);
    }

    @Test
    @DisplayName("Hours greater than piles")
    void t11() {
        assertSpeed(new int[]{3, 6, 7, 11}, 20, 2);
    }

    @Test
    @DisplayName("Mixed small and large piles")
    void t12() {
        assertSpeed(new int[]{1, 10, 100, 1000}, 12, 112);
    }

    @Test
    @DisplayName("Edge case: minimal input")
    void t13() {
        assertSpeed(new int[]{1}, 1, 1);
    }
}
