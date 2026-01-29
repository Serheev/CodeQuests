package com.serheev.leetcode._0523_continuous_subarray_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: 523. Continuous Subarray Sum (medium)
 * https://leetcode.com/problems/continuous-subarray-sum/
 * <p>
 * Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.
 * A good subarray is a subarray where:
 * - its length is at least two, and
 * - the sum of the elements of the subarray is a multiple of k.
 * Note that:
 * A subarray is a contiguous part of the array.
 * An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
 * <p>
 * Constraints:
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^9
 * 0 <= sum(nums[i]) <= 2^31 - 1
 * 1 <= k <= 2^31 - 1
 * <p>
 * Example 1:
 * Input: nums = [23,2,4,6,7], k = 6
 * Output: true
 * Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.
 * <p>
 * Example 2:
 * Input: nums = [23,2,6,4,7], k = 6
 * Output: true
 * Explanation: [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose elements sum up to 42.
 * 42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.
 * <p>
 * Example 3:
 * Input: nums = [23,2,6,4,7], k = 13
 * Output: false
 * <p>
 * Categories:
 * - Prefix Sum
 * - HashMap
 */
public class Solution {


    /**
     * Approach:
     * Optimized Prefix Sum + Modulo + HashMap.
     * A continuous subarray has a sum divisible by k if two prefix sums have the
     * same remainder when divided by k. We track the earliest index of each remainder.
     * If the same remainder appears again at least two positions later, the subarray
     * between them has length ≥ 2 and its sum is divisible by k.
     * <p>
     * The entry (0 → -1) is inserted to correctly handle subarrays starting at index 0.
     * <p>
     * Complexity:
     * Time: O(n) — each element is processed once.
     * Space: O(n) — HashMap stores remainders and their earliest indices.
     *
     * @param nums the input array of integers
     * @param k    the divisor used to check whether a subarray sum is divisible
     * @return true if there exists a continuous subarray of length ≥ 2 whose sum
     * is divisible by k (or equals 0 when k = 0), otherwise false
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int prefix = 0;

        map.put(0, -1); // remainder 0 seen at "virtual" index -1

        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            int mod = k == 0 ? prefix : prefix % k;
            if (map.containsKey(mod)) {
                int prevIndex = map.get(mod);
                if (i - prevIndex >= 2) {
                    return true;
                }
            } else {
                map.put(mod, i);
            }
        }

        return false;
    }

    /**
     * Approach:
     * Brute Force
     * <p>
     * Complexity:
     * Time: O(n^2) — all possible subarrays are evaluated.
     * Space: O(1) — only a running sum and loop variables are used.
     *
     * @param nums the input array of integers
     * @param k    the divisor to check subarray sums against
     * @return true if there exists a continuous subarray of length ≥ 2
     * whose sum is divisible by k (or equals 0 when k = 0), otherwise false
     */
    public boolean checkSubarraySum_brute_force(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (j - i + 1 < 2) continue;
                if (k == 0) {
                    if (sum == 0) return true;
                } else {
                    if (sum % k == 0) return true;
                }
            }
        }

        return false;
    }

}
