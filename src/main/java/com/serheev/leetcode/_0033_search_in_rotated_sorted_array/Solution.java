package com.serheev.leetcode._0033_search_in_rotated_sorted_array;

/**
 * Problem: 33. Search in Rotated Sorted Array (medium)
 * URL: https://leetcode.com/problems/search-in-rotated-sorted-array/
 * <p>
 * Description:
 * There is an integer array nums sorted in ascending order (with distinct values).
 * Prior to being passed to your function, nums is possibly left rotated at an unknown index k (1 <= k < nums.length)
 * such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * For example, [0,1,2,4,5,6,7] might be left rotated by 3 indices and become [4,5,6,7,0,1,2].
 * <p>
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums,
 * or -1 if it is not in nums.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * Constraints:
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * All values of nums are unique.
 * nums is an ascending array that is possibly rotated.
 * -10^4 <= target <= 10^4
 * <p>
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * <p>
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * <p>
 * Example 3:
 * Input: nums = [1], target = 0
 * Output: -1
 * <p>
 * Categories:
 * -
 */
public class Solution {

    /**
     * Approach:
     * Perform a modified binary search on the rotated sorted array. At each step,
     * determine which half of the current interval is sorted. Once the sorted half
     * is identified, check whether the target lies within that half. If it does,
     * narrow the search to that region; otherwise, discard it and search the other half.
     * <p>
     * Idea:
     * Even after rotation, one of the two halves around the midpoint remains sorted.
     * By detecting the sorted half and comparing the target against its boundaries,
     * the algorithm can safely eliminate half of the array on each iteration.
     * This preserves the logarithmic efficiency of binary search despite the rotation.
     * <p>
     * Complexity:
     * Time: O(log n) — each iteration discards half of the remaining search space.
     * Space: O(1) — only constant extra variables are used.
     *
     * @param nums rotated sorted array of unique integers
     * @param target value to search for
     * @return index of the target if found, otherwise -1
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;

            // Left half is sorted
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // target is in the left half
                } else {
                    left = mid + 1; // target is in the right half
                }
            }

            // Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // target is in the right half
                } else {
                    right = mid - 1; // target is in the left half
                }
            }
        }

        return -1;
    }
}
