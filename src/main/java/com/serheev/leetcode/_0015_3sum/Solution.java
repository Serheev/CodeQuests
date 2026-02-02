package com.serheev.leetcode._0015_3sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: 15. 3Sum (medium)
 * URL: https://leetcode.com/problems/3sum/
 * <p>
 * Description:
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 * <p>
 * Constraints:
 * 3 <= nums.length <= 3000
 * -10^5 <= nums[i] <= 10^5
 * <p>
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 * <p>
 * Example 2:
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * <p>
 * Example 3:
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 * <p>
 * Categories:
 * - Two Pointers
 * - Sorting
 * - Array
 * - Hashing (alternative)
 */
public class Solution {

    /**
     * Approach:
     * Sort the array and use a fixed index i combined with a two‑pointer scan (left, right)
     * to find all unique triplets whose sum equals zero. For each i, the algorithm searches
     * for pairs such that nums[i] + nums[left] + nums[right] = 0. Duplicate values at i,
     * left, and right are skipped to ensure uniqueness of the resulting triplets.
     * <p>
     * Idea:
     * Sorting enables efficient duplicate elimination and allows the two‑pointer technique
     * to operate in linear time for each fixed i. By moving left and right inward based on
     * the current sum, the algorithm explores all valid combinations without redundant work.
     * <p>
     * Complexity:
     * Time: O(n^2) — sorting is O(n log n), and the two‑pointer scan for each i is O(n).
     * Space: O(1) — aside from the output list, no additional data structures are used.
     *
     * @param nums input array of integers
     * @return list of all unique triplets [a, b, c] such that a + b + c = 0
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate values for i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(List.of(nums[i], nums[left], nums[right]));

                    // Skip duplicates for left
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    // Skip duplicates for right
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}
