package com.serheev.leetcode._0875_koko_eating_bananas;

/**
 * Problem: 875. Koko Eating Bananas (medium)
 * URL: https://leetcode.com/problems/koko-eating-bananas/
 * <p>
 * Description:
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
 * The guards have gone and will come back in h hours.
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas
 * and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead
 * and will not eat any more bananas during this hour.
 * <p>
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 * <p>
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 * <p>
 * Constraints:
 * 1 <= piles.length <= 10^4
 * piles.length <= h <= 10^9
 * 1 <= piles[i] <= 10^9
 * <p>
 * Example 1:
 * Input: piles = [3,6,7,11], h = 8
 * Output: 4
 * <p>
 * Example 2:
 * Input: piles = [30,11,23,4,20], h = 5
 * Output: 30
 * <p>
 * Example 3:
 * Input: piles = [30,11,23,4,20], h = 6
 * Output: 23
 * <p>
 * Categories:
 * - Binary Search on Answer
 */
public class Solution {

    /**
     * Approach:
     * Use binary search to find the minimum eating speed K such that Koko can
     * finish all banana piles within h hours. The search space ranges from 1
     * (slowest possible speed) to max(piles) (fastest possible speed, finishing
     * the largest pile in one hour). For each candidate speed, compute how many
     * hours it would take to eat all piles at that speed using the formula
     * ceil(pile / speed). If the total hours are within the allowed limit h,
     * the speed is feasible and the search continues in the lower half; otherwise,
     * the speed is too slow and the search moves to the upper half.
     * <p>
     * Idea:
     * Although the piles are not sorted, the feasibility of a given speed is
     * monotonic: if Koko can finish at speed K, she can also finish at any
     * higher speed. This monotonic property allows binary search over the
     * answer space rather than the input array. The helper function evaluates
     * whether a given speed is sufficient by summing the required hours for
     * each pile.
     * <p>
     * Complexity:
     * Time: O(n log M), where n is the number of piles and M is the maximum
     * pile size. Each binary search step requires scanning all piles.
     * Space: O(1), using only constant extra memory.
     *
     * @param piles array of banana piles
     * @param h maximum number of hours Koko has to finish eating
     * @return the minimum integer eating speed K that allows Koko to finish within h hours
     */

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canFinish(piles, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canFinish(int[] piles, int h, int speed) {
        int hours = 0;

        for (int pile : piles) {
            hours += (pile + speed - 1) / speed; // ceil(pile / speed)
        }

        return hours <= h;
    }

}
