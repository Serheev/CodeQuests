package com.serheev.leetcode._0435_non_overlapping_intervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Problem: 435. Non-overlapping Intervals (medium)
 * URL: https://leetcode.com/problems/non-overlapping-intervals/
 * <p>
 * Description:
 * Given an array of intervals where intervals[i] = [starti, endi], return the minimum number of intervals
 * you need to remove to make the rest of the intervals non-overlapping.
 * Note that intervals which only touch at a point are non-overlapping.
 * For example, [1, 2] and [2, 3] are non-overlapping.
 * <p>
 * Constraints:
 * 1 <= intervals.length <= 10^5
 * intervals[i].length == 2
 * -10^5 <= start < end <= 10^5
 * Intervals may be unsorted
 *
 * <p>
 * Example 1:
 * Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
 * Output: 1
 * Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
 * <p>
 * Example 2:
 * Input: intervals = [[1,2],[1,2],[1,2]]
 * Output: 2
 * Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
 * <p>
 * Example 3:
 * Input: intervals = [[1,2],[2,3]]
 * Output: 0
 * Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 * <p>
 * Categories:
 * - Greedy
 * - Sorting
 * - Interval Scheduling
 * - Dynamic Programming (alternative)
 */

public class Solution {

    /**
     * Approach:
     * Sort all intervals by their end times in ascending order. Then iterate through the
     * sorted list and compare each interval's start time with the end time of the last
     * non-overlapping interval kept. If the current interval overlaps (its start is before
     * the previous end), it must be removed and the removal counter is incremented. If it
     * does not overlap, update the reference end time to the current interval's end.
     * <p>
     * Idea:
     * To minimize the number of intervals removed, always keep the interval that finishes
     * earliest. This greedy strategy maximizes the remaining space for future intervals
     * and ensures the largest possible set of non-overlapping intervals. The number of
     * intervals removed is simply the count of overlaps encountered during the scan.
     * <p>
     * Complexity:
     * Time: O(n log n) — sorting the intervals dominates the runtime.
     * Space: O(1) — sorting is done in place and no additional data structures are required.
     *
     * @param intervals array of intervals, where each interval is represented as [start, end]
     * @return minimum number of intervals that must be removed to eliminate all overlaps
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        int res = 0;

        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int prev_end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (prev_end > intervals[i][0]) {
                res++;
            } else {
                prev_end = intervals[i][1];
            }
        }

        return res;
    }

    /**
     * Approach:
     * Sort all intervals by their end times in ascending order. Then iterate through the
     * sorted list and greedily select intervals that do not overlap with the previously
     * chosen one. Each time an interval overlaps with the last selected interval, it must
     * be removed. The number of intervals removed equals the total number of intervals
     * minus the number of non-overlapping intervals kept.
     * <p>
     * Idea:
     * To minimize the number of removals, always keep the interval that finishes earliest.
     * This greedy strategy maximizes the available space for future intervals and ensures
     * the largest possible set of non-overlapping intervals. The difference between the
     * total interval count and the size of this optimal set is the minimum number of
     * intervals that must be removed.
     * <p>
     * Complexity:
     * Time: O(n log n) — sorting dominates the runtime.
     * Space: O(1) — sorting is done in place and no additional structures are required.
     *
     * @param intervals array of intervals, where each interval is represented as [start, end]
     * @return minimum number of intervals that must be removed to eliminate all overlaps
     */
    public int eraseOverlapIntervals_(int[][] intervals) {
        if (intervals.length == 0) return 0;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int count = 1;

        // number of non-overlapping intervals kept
        int lastEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= lastEnd) {
                count++;
                lastEnd = intervals[i][1];
            }
        }

        return intervals.length - count;
    }
}
