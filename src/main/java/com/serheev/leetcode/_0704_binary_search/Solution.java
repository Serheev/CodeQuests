package com.serheev.leetcode._0704_binary_search;

/**
 * Problem: 704. Binary Search (easy)
 * URL: https://leetcode.com/problems/binary-search/
 * <p>
 * Description:
 * Given an array of integers nums which is sorted in ascending order, and an integer target,
 * write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * Constraints:
 * 1 <= nums.length <= 10^4
 * -10^4 < nums[i], target < 10^4
 * All the integers in nums are unique.
 * nums is sorted in ascending order.
 * <p>
 * Example 1:
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 * <p>
 * Example 2:
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 * <p>
 * Categories:
 * - Binary Search
 */
public class Solution {

    /**
     * Approach:
     * Perform an iterative binary search over the sorted array. Maintain two
     * pointers, left and right, representing the current search interval.
     * Compute the midpoint and compare its value with the target. Depending on
     * whether the target is smaller or larger than nums[mid], shrink the search
     * interval by moving either the right or left boundary.
     * <p>
     * Idea:
     * Binary search repeatedly halves the search space by leveraging the fact
     * that the input array is sorted. If the target is smaller than the middle
     * element, it must lie in the left half; if larger, it must lie in the
     * right half. This guarantees logarithmic time complexity.
     * <p>
     * Complexity:
     * Time: O(log n) — the search interval is halved on each iteration.
     * Space: O(1) — only a few integer variables are used.
     *
     * @param nums sorted array of integers
     * @param target value to search for
     * @return index of target if found, otherwise -1
     */
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) return mid;

            if (target < nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }
}
