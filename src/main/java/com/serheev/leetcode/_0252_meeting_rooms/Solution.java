package com.serheev.leetcode._0252_meeting_rooms;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Problem: 252. Meeting Rooms (easy)
 * URL:https://leetcode.com/problems/meeting-rooms/
 * <p>
 * Description:
 * You are given an array of meeting time intervals where each interval consists of a start time
 * and an end time. A person can attend all meetings if and only if no two intervals overlap.
 * Return true if all meetings can be attended, otherwise return false.
 * <p>
 * Constraints:
 * 1 <= intervals.length <= 10^4
 * intervals[i].length == 2
 * 0 <= start < end <= 10^6
 * Intervals may be unsorted
 * <p>
 * Examples:
 * intervals = [[0, 30], [5, 10], [15, 20]] → false (overlap between [0,30] and [5,10])
 * intervals = [[7, 10], [2, 4]] → true (no overlap)
 *
 * <p>
 * Categories:
 * - Sorting
 * - Interval Problems
 * - Greedy
 * - Scheduling
 */
public class Solution {

    /**
     * Approach:
     * Sort the meeting intervals by their start times in ascending order. After sorting,
     * any overlap can only occur between adjacent intervals. Perform a single linear scan
     * and check whether the end time of the previous interval exceeds the start time of
     * the current interval. If such a case is found, the meetings overlap and cannot all
     * be attended.
     * <p>
     * Idea:
     * Sorting normalizes the timeline so that all potential conflicts appear consecutively.
     * This allows a simple greedy check: each meeting must start at or after the previous
     * meeting ends. If this condition holds for all adjacent pairs, the schedule is conflict‑free.
     * <p>
     * Complexity:
     * Time: O(n log n) — dominated by sorting the intervals.
     * Space: O(1) — sorting is performed in place; no additional data structures are used.
     *
     * @param intervals array of meeting intervals, where each interval is [start, end]
     * @return true if all meetings can be attended without overlap; false otherwise
     */
    public boolean canAttendMeetings(int[][] intervals) {
        // Sort meetings by start time in ascending order
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1][1] > intervals[i][0]) {
                return false;
            }
        }

        return true;
    }
}
