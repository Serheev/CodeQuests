package com.serheev.leetcode._0033_search_in_rotated_sorted_array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    private void assertIndex(int[] nums, int target, int expected) {
        assertEquals(expected, solution.search(nums, target));
    }

    @Test
    @DisplayName("Target found in rotated array")
    void t1() {
        assertIndex(new int[]{4, 5, 6, 7, 0, 1, 2}, 0, 4);
    }

    @Test
    @DisplayName("Target found at beginning")
    void t2() {
        assertIndex(new int[]{4, 5, 6, 7, 0, 1, 2}, 4, 0);
    }

    @Test
    @DisplayName("Target found at end")
    void t3() {
        assertIndex(new int[]{4, 5, 6, 7, 0, 1, 2}, 2, 6);
    }

    @Test
    @DisplayName("Target not found")
    void t4() {
        assertIndex(new int[]{4, 5, 6, 7, 0, 1, 2}, 3, -1);
    }

    @Test
    @DisplayName("Array rotated by 1")
    void t5() {
        assertIndex(new int[]{2, 0, 1}, 0, 1);
    }

    @Test
    @DisplayName("Array rotated by n-1")
    void t6() {
        assertIndex(new int[]{1, 2, 3, 4, 5, 6, 0}, 0, 6);
    }

    @Test
    @DisplayName("No rotation (sorted array)")
    void t7() {
        assertIndex(new int[]{1, 2, 3, 4, 5, 6}, 4, 3);
    }

    @Test
    @DisplayName("Single element - found")
    void t8() {
        assertIndex(new int[]{10}, 10, 0);
    }

    @Test
    @DisplayName("Single element - not found")
    void t9() {
        assertIndex(new int[]{10}, 5, -1);
    }

    @Test
    @DisplayName("Two elements - rotated")
    void t10() {
        assertIndex(new int[]{5, 1}, 1, 1);
    }

    @Test
    @DisplayName("Two elements - rotated, target missing")
    void t11() {
        assertIndex(new int[]{5, 1}, 3, -1);
    }

    @Test
    @DisplayName("Large rotation with target in left half")
    void t12() {
        assertIndex(new int[]{30, 40, 50, 10, 20}, 40, 1);
    }

    @Test
    @DisplayName("Large rotation with target in right half")
    void t13() {
        assertIndex(new int[]{30, 40, 50, 10, 20}, 10, 3);
    }

    @Test
    @DisplayName("Duplicates (not required by problem, but robustness check)")
    void t14() {
        assertIndex(new int[]{2, 2, 2, 3, 4, 2}, 3, 3);
    }
}
