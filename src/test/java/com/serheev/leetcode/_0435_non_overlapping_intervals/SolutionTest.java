package com.serheev.leetcode._0435_non_overlapping_intervals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    @DisplayName("Basic example from problem → remove 1")
    void t1() {
        assertEquals(1, solution.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
    }

    @Test
    @DisplayName("All intervals identical → remove n-1")
    void t2() {
        assertEquals(2, solution.eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}}));
    }

    @Test
    @DisplayName("Already non-overlapping → remove 0")
    void t3() {
        assertEquals(0, solution.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}}));
    }

    @Test
    @DisplayName("Fully nested intervals → remove all but one")
    void t4() {
        assertEquals(3, solution.eraseOverlapIntervals(new int[][]{{1, 10}, {2, 9}, {3, 8}, {4, 7}}));
    }

    @Test
    @DisplayName("Unsorted input → greedy must sort first")
    void t5() {
        assertEquals(1, solution.eraseOverlapIntervals(new int[][]{{5, 6}, {1, 4}, {3, 5}}));
    }

    @Test
    @DisplayName("Negative intervals → valid input")
    void t6() {
        assertEquals(1, solution.eraseOverlapIntervals(new int[][]{{-10, -1}, {-5, 5}}));
    }

    @Test
    @DisplayName("Single interval → remove 0")
    void t7() {
        assertEquals(0, solution.eraseOverlapIntervals(new int[][]{{3, 7}}));
    }

    @Test
    @DisplayName("Empty input → remove 0")
    void t8() {
        assertEquals(0, solution.eraseOverlapIntervals(new int[][]{}));
    }

    @Test
    @DisplayName("Multiple overlaps requiring greedy end-time choice")
    void t9() {
        assertEquals(2, solution.eraseOverlapIntervals(new int[][]{{1, 4}, {2, 3}, {3, 5}, {4, 6}}));
    }

    @Test
    @DisplayName("Intervals touching at boundaries → no removal needed")
    void t10() {
        assertEquals(0, solution.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}}));
    }

    @Test
    @DisplayName("Heavy overlap cluster")
    void t11() {
        assertEquals(3, solution.eraseOverlapIntervals(new int[][]{{1, 5}, {2, 6}, {3, 7}, {4, 8}}));
    }
}
