package com.serheev.leetcode._0904_fruit_into_baskets;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: 904. Fruit Into Baskets
 * URL: https://leetcode.com/problems/fruit-into-baskets/
 * <p>
 * Description:
 * You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented
 * by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
 * <p>
 * You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
 * <p>
 * You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of
 * fruit each basket can hold.
 * Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree)
 * while moving to the right. The picked fruits must fit in one of your baskets.
 * Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
 * Given the integer array fruits, return the maximum number of fruits you can pick.
 * <p>
 * Constraints:
 * 1 <= fruits.length <= 10^5
 * 0 <= fruits[i] < fruits.length
 * <p>
 * Example 1:
 * Input: fruits = [1,2,1]
 * Output: 3
 * Explanation: We can pick from all 3 trees.
 * <p>
 * Example 2:
 * Input: fruits = [0,1,2,2]
 * Output: 3
 * Explanation: We can pick from trees [1,2,2].
 * If we had started at the first tree, we would only pick from trees [0,1].
 * <p>
 * Example 3:
 * Input: fruits = [1,2,3,2,2]
 * Output: 4
 * Explanation: We can pick from trees [2,3,2,2].
 * If we had started at the first tree, we would only pick from trees [1,2].
 * <p>
 * Categories:
 * - Sliding window
 */
public class Solution {

    /**
     * Approach:
     * Sliding window with a fixed-size frequency array. Expand the window by moving the
     * right pointer and track how many distinct fruit types are currently inside the window.
     * When the number of distinct types exceeds two, shrink the window from the left until
     * it becomes valid again.
     * <p>
     * Idea:
     * Maintain a window that always contains at most two unique fruit types. Use a frequency
     * array to count occurrences of each fruit type. Increase the distinct counter when a
     * new type enters the window, and decrease it when a type count drops to zero while
     * contracting the window. Track the maximum valid window length during iteration.
     * <p>
     * Complexity:
     * Time: O(n) — each element is visited at most twice (right expands, left contracts)
     * Space: O(1) — fixed-size frequency array (bounded by problem constraints)
     *
     * @param fruits array representing fruit types along the path
     * @return the maximum number of fruits that can be collected with at most two types
     */
    public int totalFruit(int[] fruits) {
        int[] count = new int[100001];
        int distinct = 0;
        int maxFruits = 0;
        int left = 0;

        for (int right = 0; right < fruits.length; right++) {

            if (count[fruits[right]] == 0) {
                distinct++;
            }

            count[fruits[right]]++;

            while (distinct > 2) {
                count[fruits[left]]--;
                if (count[fruits[left]] == 0) {
                    distinct--;
                }
                left++;
            }

            maxFruits = Math.max(maxFruits, right - left + 1);
        }

        return maxFruits;
    }

    /**
     * Approach:
     * Sliding window with frequency counting. Expand the window by moving the right pointer,
     * track counts of fruit types inside the window, and shrink from the left whenever the
     * number of distinct fruit types exceeds two.
     * <p>
     * Idea:
     * Maintain a dynamic window that always contains at most two unique fruit types.
     * Use a frequency map/array to track how many fruits of each type are currently inside
     * the window. When a third type appears, incrementally move the left pointer until the
     * window becomes valid again. Update the maximum valid window length during iteration.
     * <p>
     * Complexity:
     * Time: O(n) — each element is processed at most twice (expand + contract)
     * Space: O(1) — bounded frequency storage (fruit types are integers)
     *
     * @param fruits array of fruit types along the path
     * @return the maximum number of fruits that can be collected with at most two types
     */

    public int totalFruit_hashmap(int[] fruits) {
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < fruits.length; right++) {
            freq.put(fruits[right], freq.getOrDefault(fruits[right], 0) + 1);

            while (freq.size() > 2) {
                freq.put(fruits[left], freq.get(fruits[left]) - 1);
                if (freq.get(fruits[left]) == 0) {
                    freq.remove(fruits[left]);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
