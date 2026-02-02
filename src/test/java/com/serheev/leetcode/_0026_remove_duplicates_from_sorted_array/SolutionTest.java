package com.serheev.leetcode._0026_remove_duplicates_from_sorted_array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    private void assertResult(int[] input, int[] expected) {
        int k = solution.removeDuplicates(input);

        assertEquals(expected.length, k);

        for (int i = 0; i < k; i++) {
            assertEquals(expected[i], input[i]);
        }
    }

    @Test
    @DisplayName("Basic example from LeetCode")
    void t1() {
        assertResult(new int[]{1, 1, 2}, new int[]{1, 2});
    }

    @Test
    @DisplayName("Multiple duplicates")
    void t2() {
        assertResult(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, new int[]{0, 1, 2, 3, 4});
    }

    @Test
    @DisplayName("All elements identical")
    void t3() {
        assertResult(new int[]{5, 5, 5, 5, 5}, new int[]{5});
    }

    @Test
    @DisplayName("Already unique")
    void t4() {
        assertResult(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5});
    }

    @Test
    @DisplayName("Two elements identical")
    void t5() {
        assertResult(new int[]{7, 7}, new int[]{7});
    }

    @Test
    @DisplayName("Two elements unique")
    void t6() {
        assertResult(new int[]{7, 8}, new int[]{7, 8});
    }

    @Test
    @DisplayName("Single element")
    void t7() {
        assertResult(new int[]{42}, new int[]{42});
    }

    @Test
    @DisplayName("Empty array")
    void t8() {
        assertResult(new int[]{}, new int[]{});
    }

    @Test
    @DisplayName("Long run of duplicates in the middle")
    void t9() {
        assertResult(new int[]{1, 2, 2, 2, 2, 2, 3}, new int[]{1, 2, 3});
    }

    @Test
    @DisplayName("Duplicates at the end")
    void t10() {
        assertResult(new int[]{1, 2, 3, 4, 4, 4, 4}, new int[]{1, 2, 3, 4});
    }
}
