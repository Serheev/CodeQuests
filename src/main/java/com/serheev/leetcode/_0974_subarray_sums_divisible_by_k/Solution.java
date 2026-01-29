package com.serheev.leetcode._0974_subarray_sums_divisible_by_k;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: 974. Subarray Sums Divisible by K (medium)
 * https://leetcode.com/problems/subarray-sums-divisible-by-k/
 * <p>
 * Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k. *
 * A subarray is a contiguous part of an array.
 * <p>
 * Constraints:
 * 1 <= nums.length <= 3 * 10^4
 * -10^4 <= nums[i] <= 10^4
 * 2 <= k <= 10^4
 * <p>
 * Example 1:
 * Input: nums = [4,5,0,-2,-3,1], k = 5
 * Output: 7
 * Explanation: There are 7 subarrays with a sum divisible by k = 5:
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 * <p>
 * Example 2:
 * Input: nums = [5], k = 9
 * Output: 0
 * <p>
 * Categories:
 * - Prefix Sum
 * - HashMap
 */
public class Solution {

    /**
     * Approach:
     * Prefix Sum + Remainder Frequency (HashMap)
     * <p>
     * Idea:
     * Two prefix sums with the same remainder mod k define a subarray divisible by k.
     * Normalized modulo handles negative values correctly.
     * <p>
     * Complexity:
     * Time: O(n) — single pass with constant‑time map operations.
     * Space: O(k) — remainder frequency table.
     *
     * @param nums the input array of integers
     * @param k    divisor
     */
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);
        int prefix = 0;
        int count = 0;

        for (int num : nums) {
            prefix += num;
            int mod = ((prefix % k) + k) % k;
            count += freq.getOrDefault(mod, 0);
            freq.put(mod, freq.getOrDefault(mod, 0) + 1);
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
     * @param k    integer
     * @return the number of non-empty sub-arrays that have a sum divisible by k.
     */
//    public int subarraysDivByK(int[] nums, int k) {
//        int count = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//
//            int prefix = 0;
//            for (int j = i; j < nums.length; j++) {
//                prefix += nums[j];
//                if (prefix % k == 0) {
//                    count++;
//                }
//            }
//        }
//
//        return count;
//    }
}
