package com.serheev.leetcode._0695_max_area_of_island;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: 695. Max Area of Island (medium)
 * URL: https://leetcode.com/problems/max-area-of-island/
 * <p>
 * Description:
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected
 * 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * <p>
 * The area of an island is the number of cells with a value 1 in the island.
 * <p>
 * Return the maximum area of an island in grid. If there is no island, return 0.
 * <p>
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * grid[i][j] is either 0 or 1.
 * <p>
 * Example 1:
 * Input: grid =
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0], [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Output: 6
 * Explanation: The answer is not 11, because the island must be connected 4-directionally.
 * <p>
 * Example 2:
 * Input: grid = [[0,0,0,0,0,0,0,0]]
 * Output: 0
 * <p>
 * Categories:
 * - DFS/BFS
 */
public class Solution {

    /**
     * Computes the maximum area of an island in a 2D grid. An island is defined
     * as a group of horizontally or vertically adjacent cells with value 1.
     * Water cells are represented by 0. The grid is modified in-place to mark
     * visited land cells.
     *
     * <p>
     * Approach:
     * Iterate through each cell in the grid. When a land cell (1) is found,
     * perform a depth-first search (DFS) to explore the entire island and
     * compute its area. During DFS, each visited land cell is marked as 0 to
     * prevent revisiting. Track the maximum island area encountered.
     *
     * <p>
     * Complexity:
     * Time: O(m · n), where m and n are the grid dimensions. Each cell is
     * visited at most once.
     * Space: O(m · n) in the worst case due to recursion depth (all land).
     *
     * @param grid a 2D grid of 0s (water) and 1s (land)
     * @return the maximum area of any island in the grid
     */
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    max = Math.max(max, dfs(grid, r, c));
                }
            }
        }

        return max;
    }

    private int dfs(int[][] grid, int r, int c) {
        // Out of bounds or water → no area
        if (r < 0 || c < 0 ||
                r >= grid.length || c >= grid[0].length ||
                grid[r][c] == 0) {
            return 0;
        }

        // Mark as visited
        grid[r][c] = 0;

        // Explore all 4 directions
        int area = 1;
        area += dfs(grid, r + 1, c);
        area += dfs(grid, r - 1, c);
        area += dfs(grid, r, c + 1);
        area += dfs(grid, r, c - 1);

        return area;
    }

    /**
     * Computes the maximum area of an island in a 2D grid using breadth-first search (BFS).
     * An island is defined as a group of horizontally or vertically adjacent cells with value 1.
     * Water cells are represented by 0. The grid is modified in-place to mark visited land cells.
     * <p>
     * Approach:
     * Iterate through each cell in the grid. When a land cell (1) is found, start a BFS from that
     * cell to explore the entire island. Each visited land cell is marked as 0 to avoid revisiting.
     * The BFS counts the size of the island, and the maximum size encountered is returned.
     * <p>
     * Complexity:
     * Time: O(m · n), where m and n are the grid dimensions. Each cell is visited at most once.
     * Space: O(m · n) in the worst case due to the BFS queue.
     *
     * @param grid a 2D grid of 0s (water) and 1s (land)
     * @return the maximum area of any island in the grid
     */
    public int maxAreaOfIsland_bfs(int[][] grid) {
        int max = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    max = Math.max(max, bfs(grid, r, c));
                }
            }
        }

        return max;
    }

    private int bfs(int[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        grid[r][c] = 0; // mark visited

        int area = 0;
        int[][] dirs = {
                {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            area++;

            for (int[] d : dirs) {
                int nr = cell[0] + d[0];
                int nc = cell[1] + d[1];

                if (nr >= 0 && nc >= 0 &&
                        nr < rows && nc < cols &&
                        grid[nr][nc] == 1) {

                    grid[nr][nc] = 0; // mark visited
                    queue.add(new int[]{nr, nc});
                }
            }
        }

        return area;
    }
}
