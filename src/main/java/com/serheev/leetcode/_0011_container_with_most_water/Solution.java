package com.serheev.leetcode._0011_container_with_most_water;

/**
 * Problem: 11. Container With Most Water
 * URL: https://leetcode.com/problems/container-with-most-water/
 * <p>
 * Description:
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 * <p>
 * Constraints:
 * n == height.length
 * 2 <= n <= 10^5
 * 0 <= height[i] <= 10^4
 * <p>
 * Example 1:
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
 * In this case, the max area of water (blue section) the container can contain is 49.
 * <p>
 * Example 2:
 * Input: height = [1,1]
 * Output: 1
 * <p>
 * Categories:
 * - Two Pointers
 * - Greedy
 * - Array
 */
public class Solution {

    /**
     * Approach:
     * Use a two‑pointer technique starting at both ends of the array. At each step,
     * compute the area formed by the current pair of lines and update the maximum.
     * Then move the pointer pointing to the shorter line inward, since only a taller
     * line can potentially increase the area as the width shrinks.
     * <p>
     * Idea:
     * The container's area is limited by the shorter of the two heights. To maximize
     * the area, we always discard the shorter boundary because keeping it cannot
     * produce a larger result when the width decreases. This greedy movement ensures
     * that all optimal candidates are explored in linear time.
     * <p>
     * Complexity:
     * Time: O(n) — each pointer moves at most n steps.
     * Space: O(1) — no additional data structures are used.
     *
     * @param height array of vertical line heights
     * @return maximum water container area
     */
    public int maxArea(int[] height) {
        int result = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int amount = (right - left) * Math.min(height[left], height[right]);
            result = Math.max(result, amount);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return result;
    }
}
