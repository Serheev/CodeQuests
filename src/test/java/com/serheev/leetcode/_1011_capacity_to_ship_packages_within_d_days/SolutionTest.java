package com.serheev.leetcode._1011_capacity_to_ship_packages_within_d_days;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    private void assertCapacity(int[] weights, int days, int expected) {
        assertEquals(expected, solution.shipWithinDays(weights, days));
    }

    @Test
    @DisplayName("Example 1 from LeetCode")
    void t1() {
        assertCapacity(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5, 15);
    }

    @Test
    @DisplayName("Example 2 from LeetCode")
    void t2() {
        assertCapacity(new int[]{3, 2, 2, 4, 1, 4}, 3, 6);
    }

    @Test
    @DisplayName("Example 3 from LeetCode")
    void t3() {
        assertCapacity(new int[]{1, 2, 3, 1, 1}, 4, 3);
    }

    @Test
    @DisplayName("Single package, single day")
    void t4() {
        assertCapacity(new int[]{100}, 1, 100);
    }

    @Test
    @DisplayName("Single package, many days")
    void t5() {
        assertCapacity(new int[]{100}, 10, 100);
    }

    @Test
    @DisplayName("All weights equal")
    void t6() {
        assertCapacity(new int[]{5, 5, 5, 5, 5}, 5, 5);
    }

    @Test
    @DisplayName("All weights equal, fewer days")
    void t7() {
        assertCapacity(new int[]{5, 5, 5, 5, 5}, 2, 15);
    }

    @Test
    @DisplayName("Large weights, tight days")
    void t8() {
        assertCapacity(new int[]{100, 200, 300, 400, 500}, 3, 600);
    }

    @Test
    @DisplayName("Large weights, enough days")
    void t9() {
        assertCapacity(new int[]{100, 200, 300, 400, 500}, 5, 500);
    }

    @Test
    @DisplayName("Days equal number of packages")
    void t10() {
        assertCapacity(new int[]{3, 6, 7, 11}, 4, 11);
    }

    @Test
    @DisplayName("Days greater than number of packages")
    void t11() {
        assertCapacity(new int[]{3, 6, 7, 11}, 10, 11);
    }

    @Test
    @DisplayName("Mixed small and large weights")
    void t12() {
        assertCapacity(new int[]{1, 10, 100, 1000}, 3, 1000);
    }

    @Test
    @DisplayName("Mixed small and large weights, more days")
    void t13() {
        assertCapacity(new int[]{1, 10, 100, 1000}, 10, 1000);
    }

    @Test
    @DisplayName("Edge case: minimal input")
    void t14() {
        assertCapacity(new int[]{1}, 1, 1);
    }
}
