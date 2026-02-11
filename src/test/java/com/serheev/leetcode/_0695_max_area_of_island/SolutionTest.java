package com.serheev.leetcode._0695_max_area_of_island;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    @DisplayName("Empty grid")
    void t1() {
        int[][] grid = {};
        assertEquals(0, solution.maxAreaOfIsland(grid));
    }

    @Test
    @DisplayName("Single cell: water")
    void t2() {
        int[][] grid = {{0}};
        assertEquals(0, solution.maxAreaOfIsland(grid));
    }

    @Test
    @DisplayName("Single cell: land")
    void t3() {
        int[][] grid = {{1}};
        assertEquals(1, solution.maxAreaOfIsland(grid));
    }

    @Test
    @DisplayName("All water")
    void t4() {
        int[][] grid = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        assertEquals(0, solution.maxAreaOfIsland(grid));
    }

    @Test
    @DisplayName("All land (one big island)")
    void t5() {
        int[][] grid = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        assertEquals(9, solution.maxAreaOfIsland(grid));
    }

    @Test
    @DisplayName("Two separate islands")
    void t6() {
        int[][] grid = {
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}
        };
        assertEquals(1, solution.maxAreaOfIsland(grid));
    }

    @Test
    @DisplayName("LeetCode example")
    void t7() {
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        assertEquals(6, solution.maxAreaOfIsland(grid));
    }

    @Test
    @DisplayName("Diagonal land does NOT connect")
    void t8() {
        int[][] grid = {
                {1, 0, 1},
                {0, 1, 0},
                {1, 0, 1}
        };
        assertEquals(1, solution.maxAreaOfIsland(grid));
    }

    @Test
    @DisplayName("Island with a hole inside")
    void t9() {
        // 1 1 1
        // 1 0 1
        // 1 1 1
        int[][] grid = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        assertEquals(8, solution.maxAreaOfIsland(grid));
    }

    @Test
    @DisplayName("Long horizontal island")
    void t10() {
        int[][] grid = {
                {1, 1, 1, 1, 1}
        };
        assertEquals(5, solution.maxAreaOfIsland(grid));
    }

    @Test
    @DisplayName("Long vertical island")
    void t11() {
        int[][] grid = {
                {1},
                {1},
                {1},
                {1}
        };
        assertEquals(4, solution.maxAreaOfIsland(grid));
    }

    @Test
    @DisplayName("Complex mixed shape")
    void t12() {
        int[][] grid = {
                {1, 0, 1, 1, 0},
                {1, 0, 0, 1, 1},
                {0, 0, 1, 0, 0},
                {1, 1, 0, 0, 1}
        };
        assertEquals(4, solution.maxAreaOfIsland(grid));
    }
}

