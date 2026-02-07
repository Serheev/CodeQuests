package com.serheev.leetcode._0004_median_of_two_sorted_arrays;

/**
 * Problem: 4. Median of Two Sorted Arrays (hard)
 * URL: https://leetcode.com/problems/median-of-two-sorted-arrays/
 * <p>
 * Description:
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 * <p>
 * Constraints:
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -10^6 <= nums1[i], nums2[i] <= 10^6
 * <p>
 * Example 1:
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * <p>
 * Example 2:
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * <p>
 * Categories:
 * - Arrays
 * - Binary Search
 * - Divide & Conquer
 */
public class Solution {

    /**
     * Computes the median of two sorted integer arrays using the optimal
     * O(log(min(n, m))) binary‑search‑partition algorithm. The method handles all
     * valid LeetCode inputs, including cases where one array is empty, and returns
     * a defined fallback value when both arrays are empty.
     * <p>
     * The algorithm partitions the two arrays such that the left partition contains
     * exactly half of the combined elements, and every value on the left is less
     * than or equal to every value on the right. Binary search is performed on the
     * smaller array to locate the correct partition. Sentinel values
     * {@code Integer.MIN_VALUE} and {@code Integer.MAX_VALUE} are used to simplify
     * boundary handling when the partition touches array edges.
     * <p>
     * If the total number of elements is odd, the median is the maximum value on
     * the left side of the partition. If even, the median is the average of the
     * maximum left value and the minimum right value. When both arrays are empty,
     * the method returns {@code 0.0} as a safe fallback instead of throwing.
     * <p>
     * Time complexity: O(log(min(n, m)))
     * Space complexity: O(1)
     *
     * @param nums1 the first sorted array
     * @param nums2 the second sorted array
     * @return the median of the combined sorted arrays, or {@code 0.0} if both arrays are empty
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0.0;
        }

        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n1 = nums1.length;
        int n2 = nums2.length;
        int left = 0;
        int right = n1;

        while (left <= right) {
            int cut1 = left + (right - left) / 2;
            int cut2 = (n1 + n2 + 1) / 2 - cut1;
            int L1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int R1 = (cut1 == n1) ? Integer.MAX_VALUE : nums1[cut1];
            int L2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int R2 = (cut2 == n2) ? Integer.MAX_VALUE : nums2[cut2];

            if (L1 <= R2 && L2 <= R1) {
                // Correct partition found
                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2.0;
                } else {
                    return Math.max(L1, L2);
                }
            } else if (L1 > R2) {
                right = cut1 - 1;
            } else {
                left = cut1 + 1;
            }
        }

        return 0.0;
    }
}
