package com.serheev.leetcode._0084_largest_rectangle_in_histogram;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem: 84. Largest Rectangle in Histogram (hard)
 * URL: https://leetcode.com/problems/largest-rectangle-in-histogram/
 * <p>
 * Description:
 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
 * return the area of the largest rectangle in the histogram.
 * <p>
 * Constraints:
 * 1 <= heights.length <= 10^5
 * 0 <= heights[i] <= 10^4
 * <p>
 * Example 1:
 * Input: heights = [2,1,5,6,2,3]
 * Output: 10
 * Explanation: The above is a histogram where width of each bar is 1.
 * The largest rectangle is shown in the red area, which has an area = 10 units.
 * <p>
 * Example 2:
 * Input: heights = [2,4]
 * Output: 4
 * <p>
 * Categories:
 * -
 */
public class Solution {

    /**
     * Approach:
     * Use a monotonic increasing stack of indices. As you iterate through the
     * histogram, maintain a stack where each stored index corresponds to a bar
     * height that has not yet found its right boundary. When the current bar is
     * shorter than the bar at the top of the stack, it means the rectangle for the
     * top bar has ended. Pop it, compute the width using the new stack top as the
     * left boundary, and update the maximum area.
     * <p>
     * Idea:
     * Each bar is pushed and popped at most once, allowing the algorithm to
     * efficiently determine the largest rectangle that each bar can form. The stack
     * enforces increasing heights, so when a shorter bar appears, all taller bars
     * to the left can finalize their maximal rectangles.
     * <p>
     * Complexity:
     * Time: O(n) — each index is pushed and popped at most once.
     * Space: O(n) — the stack may hold up to n indices in the worst case.
     *
     * @param heights array representing histogram bar heights
     * @return the area of the largest rectangle
     */
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int left = stack.isEmpty() ? -1 : stack.peek();
                int width = i - left - 1;

                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}
