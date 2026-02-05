package com.serheev.leetcode._0042_trapping_rain_water;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem: 42. Trapping Rain Water (hard)
 * URL: https://leetcode.com/problems/trapping-rain-water/
 * <p>
 * Description:
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 * <p>
 * Constraints:
 * n == height.length
 * 1 <= n <= 2 * 10^4
 * 0 <= height[i] <= 10^5
 * <p>
 * Example 1:
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case,
 * 6 units of rain water (blue section) are being trapped.
 * <p>
 * Example 2:
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 * <p>
 * Categories:
 * - Stack
 * - Two pointers
 */
public class Solution {

    /**
     * Approach:
     * Use a monotonic increasing stack of indices. As we scan the height array,
     * the stack stores bars that form a non‑decreasing sequence of heights.
     * When we encounter a bar that is higher than or equal to the bar at the
     * top of the stack, it means the right boundary of a water basin is found.
     * We pop the middle bar (the basin floor) and compute trapped water using
     * the new top of the stack as the left boundary.
     * <p>
     * Idea:
     * Each popped index represents the lowest point of a basin. The amount of
     * water trapped above it is determined by the minimum of the left and right
     * boundary heights minus the basin floor height, multiplied by the horizontal
     * distance between boundaries. Every index is pushed and popped at most once,
     * giving linear performance.
     * <p>
     * Complexity:
     * Time: O(n) — each index is processed at most twice (push + pop).
     * Space: O(n) — the stack may hold up to n indices in the worst case.
     *
     * @param height array representing elevation map
     * @return total amount of trapped rain water
     */
    public int trap_stack(int[] height) {
        int n = height.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int water = 0;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int mid = stack.pop();

                if (stack.isEmpty()) {
                    break;
                }

                int left = stack.peek();
                int width = i - left - 1;
                int boundedHeight = Math.min(height[left], height[i]) - height[mid];

                water += width * boundedHeight;
            }
            stack.push(i);
        }

        return water;
    }

    /**
     * Approach:
     * Use the two‑pointer technique to scan the elevation map from both ends.
     * Maintain two pointers (left and right) along with the highest walls seen so far
     * on each side (leftMax and rightMax). At each step, move the pointer on the side
     * with the smaller height, because the trapped water at that side is limited by
     * its own maximum boundary, not the opposite one.
     * <p>
     * Idea:
     * Water above any position depends on the minimum of the highest wall to its left
     * and the highest wall to its right. Instead of precomputing two arrays of maxima,
     * we track these maxima dynamically while moving inward. When the left side is
     * lower, leftMax determines the trapped water; when the right side is lower,
     * rightMax determines it. This eliminates extra memory and ensures linear time.
     * <p>
     * Complexity:
     * Time: O(n) — each index is visited at most once.
     * Space: O(1) — only constant extra variables are used.
     *
     * @param height elevation map where each element represents bar height
     * @return total amount of trapped rain water
     */
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }

        return water;
    }
}
