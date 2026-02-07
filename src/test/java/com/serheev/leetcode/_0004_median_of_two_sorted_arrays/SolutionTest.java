package com.serheev.leetcode._0004_median_of_two_sorted_arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SolutionTest {

    private final Solution solution = new Solution();

    private void assertMedian(int[] a, int[] b, double expected) {
        assertEquals(expected, solution.findMedianSortedArrays(a, b));
    }

    @Test
    @DisplayName("Example 1 from LeetCode")
    void t1() {
        assertMedian(new int[]{1, 3}, new int[]{2}, 2.0);
    }

    @Test
    @DisplayName("Example 2 from LeetCode")
    void t2() {
        assertMedian(new int[]{1, 2}, new int[]{3, 4}, 2.5);
    }

    @Test
    @DisplayName("One array empty")
    void t3() {
        assertMedian(new int[]{}, new int[]{1, 2, 3, 4}, 2.5);
    }

    @Test
    @DisplayName("Both arrays empty (invalid input)")
    void t4() {
        assertMedian(new int[]{}, new int[]{}, 0.0);
    }

    @Test
    @DisplayName("Different sizes, odd total length")
    void t5() {
        assertMedian(new int[]{1, 5, 8}, new int[]{2, 3, 4, 9, 10}, 4.5);
    }

    @Test
    @DisplayName("Different sizes, even total length")
    void t6() {
        assertMedian(new int[]{1, 2, 3}, new int[]{4, 5, 6, 7}, 4.0);
    }

    @Test
    @DisplayName("Arrays with duplicates")
    void t7() {
        assertMedian(new int[]{1, 1, 1}, new int[]{1, 1, 1}, 1.0);
    }

    @Test
    @DisplayName("Negative numbers")
    void t8() {
        assertMedian(new int[]{-5, -3, -1}, new int[]{2, 4, 6}, 0.5);
    }

    @Test
    @DisplayName("One element each")
    void t9() {
        assertMedian(new int[]{100}, new int[]{200}, 150.0);
    }

    @Test
    @DisplayName("Highly unbalanced sizes")
    void t10() {
        assertMedian(new int[]{1}, new int[]{2, 3, 4, 5, 6, 7, 8}, 4.5);
    }

    @Test
    @DisplayName("Identical arrays")
    void t11() {
        assertMedian(new int[]{2, 3, 5}, new int[]{2, 3, 5}, 3.0);
    }

    @Test
    @DisplayName("Interleaving values")
    void t12() {
        assertMedian(new int[]{1, 4, 7}, new int[]{2, 3, 6, 8}, 4.0);
    }
}
