package com.serheev.leetcode._0035_search_insert_position;

/**
 * Problem: 35. Search Insert Position (easy)
 * URL: https://leetcode.com/problems/search-insert-position/
 * <p>
 * Description:
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * Constraints:
 * 1 <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums contains distinct values sorted in ascending order.
 * -10^4 <= target <= 10^4
 * <p>
 * Example 1:
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * <p>
 * Example 2:
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * <p>
 * Example 3:
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 * <p>
 * Categories:
 * - Binary Search
 */
public class Solution {

    /**
     * Approach:
     * Perform an iterative binary search on the sorted array. Maintain two pointers,
     * left and right, that define the current search interval. On each iteration,
     * compute the midpoint and compare its value with the target. If the target is
     * smaller, move the right boundary left; if larger, move the left boundary right.
     * <p>
     * Idea:
     * Because the array is sorted, binary search can eliminate half of the remaining
     * search space at each step. When the loop finishes without finding the target,
     * the left pointer will be positioned at the index where the target should be
     * inserted to maintain sorted order. Returning this value ensures correct
     * placement whether the target exists or not.
     * <p>
     * Complexity:
     * Time: O(log n) — the search interval is halved on each iteration.
     * Space: O(1) — only constant extra variables are used.
     *
     * @param nums sorted array of integers
     * @param target value to search for or insert
     * @return index of the target if found, otherwise the index where it should be inserted
     */
    public int searchInsert(int[] nums, int target) {
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

        return l;
    }
}
