package com.serheev.leetcode._0410_split_array_largest_sum;

/**
 * Problem: 410. Split Array Largest Sum (hard)
 * URL: https://leetcode.com/problems/split-array-largest-sum/
 * <p>
 * Description:
 * Given an integer array nums and an integer k, split nums into k non-empty sub-arrays such that the largest sum
 * of any subarray is minimized.
 * Return the minimized largest sum of the split.
 * A subarray is a contiguous part of the array.
 * <p>
 * Constraints:
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 10^6
 * 1 <= k <= min(50, nums.length)
 * <p>
 * Example 1:
 * Input: nums = [7,2,5,10,8], k = 2
 * Output: 18
 * Explanation: There are four ways to split nums into two sub-arrays.
 * The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two sub-arrays is only 18.
 * <p>
 * Example 2:
 * Input: nums = [1,2,3,4,5], k = 2
 * Output: 9
 * Explanation: There are four ways to split nums into two sub-arrays.
 * The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two sub-arrays is only 9.
 * <p>
 * Categories:
 * - Binary Search on Answer
 */
public class Solution {

    /**
     * Splits the array into k non-empty contiguous sub-arrays such that the largest
     * subarray sum is minimized, and returns that minimized value. The order of
     * elements must be preserved, and each element must belong to exactly one
     * subarray.
     * <p>
     * Approach:
     * This problem exhibits a monotonic feasibility property: if it is possible to
     * split the array into k sub-arrays with a maximum subarray sum of X, then it is
     * also possible with any value greater than X. This allows binary search over
     * the answer space rather than the input array.
     * <p>
     * The lower bound of the search is the maximum element in the array, since no
     * subarray can have a sum smaller than its largest element. The upper bound is
     * the total sum of the array, representing the case where all elements form a
     * single subarray.
     * <p>
     * For each candidate limit, the helper method {@code canSplit} greedily forms
     * sub-arrays by accumulating elements until adding the next one would exceed the
     * limit. Each time this happens, a new subarray is started. If the number of
     * sub-arrays needed is less than or equal to k, the limit is feasible and the
     * search continues in the lower half; otherwise, the limit is too small and the
     * search moves to the upper half.
     * <p>
     * Complexity:
     * Time: O(n log S), where n is the number of elements and S is the sum of all
     * elements. Each binary search step requires scanning the entire array.
     * Space: O(1), using only constant auxiliary memory.
     *
     * @param nums the array of positive integers to be split
     * @param k the number of contiguous sub-arrays to form
     * @return the minimized largest subarray sum achievable with exactly k splits
     */
    public int splitArray(int[] nums, int k) {
        int left = 0;
        int right = 0;

        // Lower bound = max element
        // Upper bound = sum of all elements
        for (int n : nums) {
            left = Math.max(left, n);
            right += n;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canSplit(nums, k, mid)) {
                right = mid; // try smaller largest sum
            } else {
                left = mid + 1; // need larger largest sum
            }
        }

        return left;
    }

    /**
     * Determines whether the array can be split into at most k contiguous sub-arrays
     * such that no subarray has a sum greater than the specified limit. Elements
     * must remain in order, and each subarray must be non-empty.
     *
     * @param nums the array to evaluate
     * @param k the maximum number of sub-arrays allowed
     * @param limit the maximum allowed sum for any subarray
     * @return true if the array can be split within the limit using at most k sub-arrays
     */
    private boolean canSplit(int[] nums, int k, int limit) {
        int count = 1;
        int current = 0;

        for (int n : nums) {
            if (current + n > limit) {
                count++;
                current = n;
                if (count > k) return false;
            } else {
                current += n;
            }
        }

        return true;
    }
}
