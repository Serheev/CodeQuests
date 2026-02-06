package com.serheev.leetcode._1011_capacity_to_ship_packages_within_d_days;

/**
 * Problem: 1011. Capacity To Ship Packages Within D Days (medium)
 * URL: https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
 * <p>
 * Description:
 * A conveyor belt has packages that must be shipped from one port to another within `days` days.
 * <p>
 * The i-th package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages
 * on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight
 * capacity of the ship.
 * <p>
 * Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped
 * within `days` days.
 * <p>
 * Constraints:
 * 1 <= days <= weights.length <= 5 * 10^4
 * 1 <= weights[i] <= 500
 * <p>
 * Example 1:
 * Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
 * Output: 15
 * Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
 * 1st day: 1, 2, 3, 4, 5
 * 2nd day: 6, 7
 * 3rd day: 8
 * 4th day: 9
 * 5th day: 10
 * Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
 * <p>
 * Example 2:
 * Input: weights = [3,2,2,4,1,4], days = 3
 * Output: 6
 * Explanation: A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
 * 1st day: 3, 2
 * 2nd day: 2, 4
 * 3rd day: 1, 4
 * <p>
 * Example 3:
 * Input: weights = [1,2,3,1,1], days = 4
 * Output: 3
 * Explanation:
 * 1st day: 1
 * 2nd day: 2
 * 3rd day: 3
 * 4th day: 1, 1
 * <p>
 * Categories:
 * - Binary Search on Answer
 */
public class Solution {

    /**
     * Computes the minimum ship capacity required to deliver all packages within
     * the specified number of days. The packages must be shipped in order, and
     * each day the ship can carry a contiguous sequence of packages whose total
     * weight does not exceed the chosen capacity.
     * <p>
     * Approach:
     * Use binary search over the range of possible capacities. The minimum feasible
     * capacity is the maximum single package weight, since the ship must be able to
     * carry every package individually. The maximum possible capacity is the sum of
     * all package weights, representing shipping everything in one day.
     * <p>
     * For each candidate capacity, the helper method {@code isPossible} simulates
     * the shipping process by greedily loading packages until the capacity is
     * exceeded, then moving to the next day. If the total number of days required
     * is less than or equal to the allowed limit, the capacity is feasible and the
     * search continues in the lower half; otherwise, the search moves to the upper
     * half.
     * <p>
     * Complexity:
     * Time: O(n log S), where n is the number of packages and S is the sum of all
     * weights. Each binary search step requires scanning the entire array.
     * Space: O(1), using only constant extra memory.
     *
     * @param weights array of package weights that must be shipped in order
     * @param days maximum number of days allowed to complete the shipment
     * @return the minimum ship capacity that allows shipping all packages within the given days
     */
    public int shipWithinDays(int[] weights, int days) {
        if (weights.length == 0) return -1;

        int minWeight = 0;
        int maxWeight = 0;

        for (int weight : weights) {
            minWeight = Math.max(minWeight, weight);
            maxWeight += weight;
        }

        while (minWeight <= maxWeight) {
            int mid = minWeight + (maxWeight - minWeight) / 2;
            if (isPossible(weights, days, mid)) {
                maxWeight = mid - 1;
            } else {
                minWeight = mid + 1;
            }
        }

        return minWeight;
    }

    /**
     * Determines whether all packages can be shipped within the given number of days
     * using a ship with the specified capacity. Packages must be loaded in order,
     * and each day the ship carries as many consecutive packages as possible without
     * exceeding the capacity.
     *
     * @param w array of package weights
     * @param d maximum number of days allowed
     * @param limit ship capacity being tested
     * @return true if shipping is possible within d days, false otherwise
     */
    private boolean isPossible(int[] w, int d, int limit) {
        int dayCount = 1;
        int capacity = 0;

        for (int weight : w) {
            if (capacity + weight > limit) {
                dayCount++;
                capacity = weight;
            } else {
                capacity += weight;
            }
        }

        return dayCount <= d;
    }
}
