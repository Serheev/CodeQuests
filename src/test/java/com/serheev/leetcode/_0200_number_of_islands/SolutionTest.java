package com.serheev.leetcode._0200_number_of_islands;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    @DisplayName("Empty grid")
    void t1() {
        char[][] grid = {};
        assertEquals(0, solution.numIslands(grid));
    }

    @Test
    @DisplayName("Single cell: water")
    void t2() {
        char[][] grid = {{'0'}};
        assertEquals(0, solution.numIslands(grid));
    }

    @Test
    @DisplayName("Single cell: land")
    void t3() {
        char[][] grid = {{'1'}};
        assertEquals(1, solution.numIslands(grid));
    }

    @Test
    @DisplayName("All water")
    void t4() {
        char[][] grid = {
                {'0', '0', '0'},
                {'0', '0', '0'},
                {'0', '0', '0'}
        };
        assertEquals(0, solution.numIslands(grid));
    }

    @Test
    @DisplayName("All land (one big island)")
    void t5() {
        char[][] grid = {
                {'1', '1', '1'},
                {'1', '1', '1'},
                {'1', '1', '1'}
        };
        assertEquals(1, solution.numIslands(grid));
    }

    @Test
    @DisplayName("Two separate islands")
    void t6() {
        char[][] grid = {
                {'1', '0', '1'},
                {'0', '0', '0'},
                {'1', '0', '1'}
        };
        assertEquals(4, solution.numIslands(grid));
    }

    @Test
    @DisplayName("LeetCode example")
    void t7() {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        assertEquals(1, solution.numIslands(grid));
    }

    @Test
    @DisplayName("Diagonal land does NOT connect")
    void t8() {
        char[][] grid = {
                {'1', '0', '1'},
                {'0', '1', '0'},
                {'1', '0', '1'}
        };
        assertEquals(5, solution.numIslands(grid));
    }

    @Test
    @DisplayName("Island with a hole inside")
    void t9() {
        // 1 1 1
        // 1 0 1
        // 1 1 1
        char[][] grid = {
                {'1', '1', '1'},
                {'1', '0', '1'},
                {'1', '1', '1'}
        };
        assertEquals(1, solution.numIslands(grid));
    }

    @Test
    @DisplayName("Long horizontal island")
    void t10() {
        char[][] grid = {
                {'1', '1', '1', '1', '1'}
        };
        assertEquals(1, solution.numIslands(grid));
    }

    @Test
    @DisplayName("Long vertical island")
    void t11() {
        char[][] grid = {
                {'1'},
                {'1'},
                {'1'},
                {'1'}
        };
        assertEquals(1, solution.numIslands(grid));
    }

    @Test
    @DisplayName("Mixed complex shape")
    void t12() {
        char[][] grid = {
                {'1', '0', '1', '1', '0'},
                {'1', '0', '0', '1', '1'},
                {'0', '0', '1', '0', '0'},
                {'1', '1', '0', '0', '1'}
        };
        assertEquals(5, solution.numIslands(grid));
    }
}

