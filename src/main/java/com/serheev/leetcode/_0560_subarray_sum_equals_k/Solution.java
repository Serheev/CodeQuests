package com.serheev.leetcode._0560_subarray_sum_equals_k;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: 560. Subarray Sum Equals K (medium)
 * https://leetcode.com/problems/subarray-sum-equals-k/
 * <p>
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * <p>
 * Constraints:
 * 1 <= nums.length <= 2 * 10^4
 * -1000 <= nums[i] <= 1000
 * -10^7 <= k <= 10^7
 * <p>
 * Example 1:
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * <p>
 * Example 2:
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 * <p>
 * Categories:
 * - Prefix Sum
 * - HashMap
 */
public class Solution {

    /**
     * Approach:
     * - Prefix Sum + HashMap
     * The general idea behind the prefix-sum approach:
     * <p>
     * For any subarray nums[left..right], its sum can be computed using prefix sums:
     * <p>
     * prefixSum(right) - prefixSum(left - 1) = k
     * <p>
     * This means that a subarray ending at index 'right' has sum k if and only if
     * there exists a previous prefix sum equal to:
     * <p>
     * prefixSum(left - 1) = prefixSum(right) - k
     * <p>
     * Therefore, while iterating through the array and maintaining a running prefix sum,
     * we can check how many times the value (currentPrefix - k) has appeared before.
     * Each occurrence corresponds to one valid subarray with sum k.
     * <p>
     * Complexity:
     * Time: O(n)
     * Space: O(n)
     * <p>
     * Returns the number of continuous subarrays whose sum equals k.
     *
     * @param nums the input array of integers
     * @param k    the target sum to search for
     * @return the number of sub-arrays whose sum is equal to k
     */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixMap = new HashMap<>();
        int count = 0;
        int prefix = 0;

        prefixMap.put(0, 1);

        for (int n : nums) {
            prefix += n;

            if (prefixMap.containsKey(prefix - k)) {
                count += prefixMap.get(prefix - k);
            }

            prefixMap.put(prefix, prefixMap.getOrDefault(prefix, 0) + 1);
        }

        return count;
    }

    /**
     * Approach:
     * Brute Force
     * <p>
     * Complexity:
     * Time: O(n^2) — all possible sub-arrays are evaluated.
     * Space: O(1) — only a few integer variables are used.
     *
     * @param nums the input array of integers
     * @param k    the target sum to search for
     * @return the number of sub-arrays whose sum is equal to k
     */
    public int subarraySum_brute_force(int[] nums, int k) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }
}
