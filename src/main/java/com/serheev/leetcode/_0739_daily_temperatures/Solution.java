package com.serheev.leetcode._0739_daily_temperatures;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem: 739. Daily Temperatures (medium)
 * URL: https://leetcode.com/problems/daily-temperatures/
 * <p>
 * Description:
 * Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i]
 * is the number of days you have to wait after the i-th day to get a warmer temperature.
 * If there is no future day for which this is possible, keep answer[i] == 0 instead.
 * <p>
 * Constraints:
 * 1 <= temperatures.length <= 10^5
 * 30 <= temperatures[i] <= 100
 * <p>
 * Example 1:
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 * <p>
 * Example 2:
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 * <p>
 * Example 3:
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 * <p>
 * Categories:
 * - Monotonic Stack
 * - Array
 */
public class Solution {

    /**
     * Approach:
     * Use a monotonic decreasing stack of indices. As you scan the temperature array
     * from left to right, maintain a stack where each stored index corresponds to a
     * temperature that has not yet found a warmer future day. When the current
     * temperature is higher than the temperature at the index on top of the stack,
     * pop that index and compute the number of days until this warmer temperature.
     * <p>
     * Idea:
     * The stack keeps track of unresolved temperatures in decreasing order. Each
     * temperature is pushed once and popped at most once, allowing efficient
     * detection of the next warmer day. This avoids nested loops and ensures linear
     * performance.
     * <p>
     * Complexity:
     * Time: O(n) — each index is pushed and popped at most once.
     * Space: O(n) — the stack may hold up to n indices in the worst case.
     *
     * @param temperatures array of daily temperatures
     * @return array where each element represents days until a warmer temperature
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                result[idx] = i - idx;
            }

            stack.push(i);
        }

        return result;
    }
}
