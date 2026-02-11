package com.serheev.leetcode._0200_number_of_islands;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: 200. Number of Islands (medium)
 * URL: https://leetcode.com/problems/number-of-islands/
 * <p>
 * Description:
 * Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * <p>
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 * <p>
 * Example 1:
 * Input: grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * Output: 1
 * <p>
 * Example 2:
 * Input: grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * Output: 3
 * <p>
 * Categories:
 * - DFS/BFS
 */
public class Solution {

    /**
     * Counts the number of islands in a 2D grid. An island is defined as a group
     * of horizontally or vertically adjacent '1' cells (land). Cells marked '0'
     * represent water. The grid is modified in-place to mark visited land.
     * <p>
     * Approach:
     * A depth-first search (DFS) is performed whenever an unvisited land cell
     * ('1') is found. The DFS explores all connected land cells and marks them
     * as visited by converting them to '0'. Each DFS call corresponds to one
     * complete island.
     * <p>
     * Complexity:
     * Time: O(m · n), where m and n are the grid dimensions. Each cell is visited once.
     * Space: O(m · n) in the worst case due to recursion depth (all land).
     *
     * @param grid a 2D grid of '1' (land) and '0' (water)
     * @return the number of distinct islands
     */
    public int numIslands_dfs(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    count++;
                    dfs(grid, r, c);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Out of bounds or water → stop
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == '0') {
            return;
        }

        // Mark as visited
        grid[r][c] = '0';

        // Explore neighbors
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }

    /**
     * Counts the number of islands in a 2D grid using breadth-first search (BFS).
     * An island is a group of horizontally or vertically adjacent '1' cells.
     * Water is represented by '0'. The grid is modified in-place to mark visited
     * land cells.
     * <p>
     * Approach:
     * Iterate through each cell in the grid. When a land cell ('1') is found,
     * increment the island count and start a BFS from that cell. The BFS explores
     * all connected land cells, marking them as visited by converting them to '0'.
     * Each BFS corresponds to one complete island.
     * <p>
     * Complexity:
     * Time: O(m · n), where m and n are the grid dimensions.
     * Space: O(min(m, n))) for the BFS queue in the worst case.
     *
     * @param grid a 2D grid of '1' (land) and '0' (water)
     * @return the number of distinct islands
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    count++;
                    bfs(grid, r, c);
                }
            }
        }

        return count;
    }

    private void bfs(char[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        grid[r][c] = '0'; // mark visited

        int[][] dirs = {
                {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            for (int[] d : dirs) {
                int nr = row + d[0];
                int nc = col + d[1];

                if (nr >= 0 && nc >= 0 && nr < rows && nc < cols && grid[nr][nc] == '1') {
                    grid[nr][nc] = '0'; // mark visited
                    queue.add(new int[]{nr, nc});
                }
            }
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

