package com.serheev.leetcode._0026_remove_duplicates_from_sorted_array;

/**
 * Problem: 26. Remove Duplicates from Sorted Array (easy)
 * URL: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * <p>
 * Description:
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place
 * such that each unique element appears only once. The relative order of the elements should be kept the same.
 * <p>
 * Consider the number of unique elements in nums to be k. After removing duplicates,
 * return the number of unique elements k.
 * <p>
 * The first k elements of nums should contain the unique numbers in sorted order.
 * The remaining elements beyond index k - 1 can be ignored.
 * <p>
 * Custom Judge:
 * The judge will test your solution with the following code:
 * int[] nums = [...]; // Input array
 * int[] expectedNums = [...]; // The expected answer with correct length
 * int k = removeDuplicates(nums); // Calls your implementation
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 * assert nums[i] == expectedNums[i];
 * }
 * If all assertions pass, then your solution will be accepted.
 * <p>
 * Constraints:
 * 1 <= nums.length <= 3 * 10^4
 * -100 <= nums[i] <= 100
 * nums is sorted in non-decreasing order.
 * <p>
 * Example 1:
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * <p>
 * Example 2:
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3,
 * and 4 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * <p>
 * Categories:
 * - Two Pointers
 * - Array
 * - In‑Place Algorithm
 */
public class Solution {

    /**
     * Approach:
     * Use the classic two‑pointer technique (slow/fast). The array is already sorted,
     * so duplicates always appear in consecutive positions. The fast pointer scans
     * through the array, and each time it finds a new unique value, it is written
     * to the next position indicated by the slow pointer.
     * <p>
     * Idea:
     * Since the array is sorted, all duplicates are adjacent. We maintain:
     * - slow: index of the last unique element written
     * - fast: index scanning through the array
     * When nums[fast] differs from nums[slow], we advance slow and copy the new
     * unique value into nums[slow]. The first (slow + 1) elements of the array
     * become the deduplicated result.
     * <p>
     * Complexity:
     * Time: O(n) — each element is visited once by the fast pointer.
     * Space: O(1) — in‑place modification with no extra data structures.
     *
     * @param nums sorted input array of integers
     * @return the number of unique elements after in‑place deduplication
     */
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int slow = 0;

        for (int fast = 0; fast < n; fast++) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }

        return slow + 1;
    }
}
