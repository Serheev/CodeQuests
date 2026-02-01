package com.serheev.leetcode._3477_fruits_into_baskets_ii;

/**
 * Problem:3477. Fruits Into Baskets II (easy)
 * URL: https://leetcode.com/problems/fruits-into-baskets-ii/
 * <p>
 * Description:
 * You are given two arrays of integers, fruits and baskets, each of length n, where fruits[i] represents the quantity
 * of the ith type of fruit, and baskets[j] represents the capacity of the jth basket.
 * <p>
 * From left to right, place the fruits according to these rules:
 * <p>
 * Each fruit type must be placed in the leftmost available basket with a capacity greater than or equal to the quantity
 * of that fruit type.
 * Each basket can hold only one type of fruit.
 * If a fruit type cannot be placed in any basket, it remains unplaced.
 * Return the number of fruit types that remain unplaced after all possible allocations are made.
 * <p>
 * Constraints:
 * n == fruits.length == baskets.length
 * 1 <= n <= 100
 * 1 <= fruits[i], baskets[i] <= 1000
 * <p>
 * Example 1:
 * Input: fruits = [4,2,5], baskets = [3,5,4]
 * Output: 1
 * Explanation:
 * fruits[0] = 4 is placed in baskets[1] = 5.
 * fruits[1] = 2 is placed in baskets[0] = 3.
 * fruits[2] = 5 cannot be placed in baskets[2] = 4.
 * Since one fruit type remains unplaced, we return 1.
 * <p>
 * Example 2:
 * Input: fruits = [3,6,1], baskets = [6,4,7]
 * Output: 0
 * Explanation:
 * fruits[0] = 3 is placed in baskets[0] = 6.
 * fruits[1] = 6 cannot be placed in baskets[1] = 4 (insufficient capacity) but can be placed in the next available basket, baskets[2] = 7.
 * fruits[2] = 1 is placed in baskets[1] = 4.
 * Since all fruits are successfully placed, we return 0.
 * <p>
 * Categories:
 * - Greedy algorithms
 */
public class Solution {

    /**
     * Approach:
     * Sequential greedy assignment. Iterate over each fruit type in order and try to place it
     * into the first available basket (in original basket order) that has sufficient capacity
     * and has not been used yet. If no such basket exists, the fruit type is counted as unplaced.
     * <p>
     * Idea:
     * Baskets cannot be reordered, and each basket can be used at most once. For every fruit,
     * scan baskets from left to right and select the earliest valid one. This greedy strategy
     * is optimal because choosing the leftmost feasible basket preserves future placement options.
     * <p>
     * Complexity:
     * Time: O(n²) — for each fruit (up to n), we may scan all baskets (up to n).
     * Space: O(n) — boolean array tracking which baskets are already used.
     *
     * @param fruits  array where each element represents the required capacity for a fruit type
     * @param baskets array where each element represents the capacity of a basket
     * @return number of fruit types that cannot be placed into any basket
     */
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = baskets.length;
        boolean[] used = new boolean[n];
        int unplaced = 0;

        for (int fruit : fruits) {
            int idx = -1;

            for (int j = 0; j < n; j++) {
                if (!used[j] && baskets[j] >= fruit) {
                    idx = j;
                    break;
                }
            }

            if (idx == -1) {
                unplaced++;
            } else {
                used[idx] = true;
            }
        }

        return unplaced;
    }
}
