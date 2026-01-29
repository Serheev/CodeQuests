package com.serheev.leetcode._0523_continuous_subarray_sum;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
    private final Solution solution = new Solution();

        @Test
        @DisplayName("Example 1: [23,2,4,6,7], k=6 → true")
        void testExample1() {
            int[] nums = {23, 2, 4, 6, 7};
            int k = 6;
            assertTrue(solution.checkSubarraySum(nums, k));
        }

        @Test
        @DisplayName("Example 2: [23,2,6,4,7], k=6 → true")
        void testExample2() {
            int[] nums = {23, 2, 6, 4, 7};
            int k = 6;
            assertTrue(solution.checkSubarraySum(nums, k));
        }

        @Test
        @DisplayName("Example 3: [23,2,6,4,7], k=13 → false")
        void testExample3() {
            int[] nums = {23, 2, 6, 4, 7};
            int k = 13;
            assertFalse(solution.checkSubarraySum(nums, k));
        }

        @Test
        @DisplayName("Two zeros: [0,0], k=1 → true")
        void testTwoZeros() {
            int[] nums = {0, 0};
            int k = 1;
            assertTrue(solution.checkSubarraySum(nums, k));
        }

        @Test
        @DisplayName("Single element: [5], k=5 → false (length < 2)")
        void testSingleElement() {
            int[] nums = {5};
            int k = 5;
            assertFalse(solution.checkSubarraySum(nums, k));
        }

        @Test
        @DisplayName("Large k: [5,0,0,0], k=100000 → true")
        void testLargeK() {
            int[] nums = {5, 0, 0, 0};
            int k = 100000;
            assertTrue(solution.checkSubarraySum(nums, k));
        }

        @Test
        @DisplayName("Multiple valid subarrays: [2,4,3,9], k=6 → true")
        void testMultipleValidSubarrays() {
            int[] nums = {2, 4, 3, 9};
            int k = 6;
            assertTrue(solution.checkSubarraySum(nums, k));
        }

        @Test
        @DisplayName("No valid subarray: [1,2,3], k=100 → false")
        void testNoValidSubarray() {
            int[] nums = {1, 2, 3};
            int k = 100;
            assertFalse(solution.checkSubarraySum(nums, k));
        }

        @Test
        @DisplayName("k = 0 case: [0,1,0], k=0 → false")
        void testKIsZero() {
            int[] nums = {0, 1, 0};
            int k = 0;
            assertFalse(solution.checkSubarraySum(nums, k));
        }
    }