package com.serheev.leetcode._0253_meeting_rooms_ii;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Problem: 253. Meeting Rooms II (medium)
 * URL: https://leetcode.com/problems/meeting-rooms-ii/
 * <p>
 * Description:
 * Given an array of meeting time intervals where each interval consists of a start time
 * and an end time, determine the minimum number of conference rooms required so that
 * all meetings can be held without time conflicts. A room can host only one meeting
 * at a time, but once a meeting ends, the room becomes available for reuse.
 * <p>
 * The goal is to compute the maximum number of overlapping intervals at any point in time.
 * This represents the minimum number of rooms needed.
 * <p>
 * Constraints:
 * - 1 <= intervals.length <= 10^4
 * - intervals[i].length == 2
 * - 0 <= start < end <= 10^6
 * - Intervals may be unsorted
 * <p>
 * Examples:
 * intervals = [[0, 30], [5, 10], [15, 20]] → 2
 * intervals = [[7, 10], [2, 4]] → 1
 * intervals = [[1, 5], [2, 6], [3, 7]] → 3
 * <p>
 * Categories:
 * - Heap / Priority Queue
 * - Sorting
 * - Greedy
 * - Interval Scheduling
 * - Sweep Line
 */
public class Solution {

    /**
     * Approach:
     * Sort all meeting intervals by their start times. Use a min‑heap (priority queue)
     * to track the end times of all currently active meetings. For each meeting, compare
     * its start time with the earliest ending meeting in the heap. If the current meeting
     * starts after or exactly when the earliest one ends, that room can be reused and the
     * earliest end time is removed from the heap. Otherwise, a new room is required.
     * The heap always contains the end times of all ongoing meetings.
     * <p>
     * Idea:
     * The min‑heap efficiently maintains the meeting that finishes first. By always freeing
     * rooms as soon as possible and allocating new ones only when necessary, the algorithm
     * computes the maximum number of concurrent meetings. That value corresponds directly
     * to the minimum number of rooms required.
     * <p>
     * Complexity:
     * Time: O(n log n) — sorting takes O(n log n) and each heap operation takes O(log n).
     * Space: O(n) — the heap may store up to n end times in the worst case.
     *
     * @param intervals array of meeting intervals, where each interval is [start, end)
     * @return minimum number of meeting rooms required to schedule all intervals
     */
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;

        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));

        // Min-heap storing end times of ongoing meetings
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add the first meeting's end time
        minHeap.offer(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            // If the earliest ending meeting is done before this one starts, reuse the room
            if (start >= minHeap.peek()) {
                minHeap.poll();
            }

            // Allocate a room (new or reused)
            minHeap.offer(end);
        }

        return minHeap.size();
    }


    /**
     * Approach:
     * Use the sweep-line technique with separate sorted arrays of start and end times.
     * Sort all meeting start times and end times independently. Then iterate through the
     * sorted start times and compare each start with the earliest available end time.
     * If the meeting starts before the earliest meeting ends, a new room is required.
     * Otherwise, the earliest meeting has finished and its room can be reused.
     * <p>
     * Idea:
     * By sorting starts and ends separately, we can efficiently simulate the timeline of
     * meetings. Each start represents a request for a room, and each end represents a room
     * being freed. Advancing the end pointer only when a meeting has finished ensures that
     * we always reuse rooms optimally. The maximum number of concurrent active meetings
     * corresponds to the minimum number of rooms needed.
     * <p>
     * Complexity:
     * Time: O(n log n) — dominated by sorting the start and end arrays.
     * Space: O(n) — additional arrays for start and end times.
     *
     * @param intervals array of meeting intervals, where each interval is [start, end)
     * @return minimum number of meeting rooms required to host all meetings
     */
    public int minMeetingRooms_sweep_line(int[][] intervals) {
        if (intervals.length == 0) return 0;

        int n = intervals.length;
        int[] starts = new int[n];
        int[] ends = new int[n];

        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int rooms = 0;
        int endPtr = 0;
        for (int start : starts) {
            // If the current meeting starts before the earliest ending meeting finishes, we need a new room
            if (start < ends[endPtr]) {
                rooms++;
            } else {
                // Otherwise, reuse a room.
                endPtr++;
            }
        }

        return rooms;
    }

    /**
     * Approach:
     * Use a sweep-line technique implemented via a difference array. First determine the
     * maximum end time among all intervals to size the difference array. For each meeting,
     * increment the value at its start time (room needed) and decrement at its end time
     * (room freed). A prefix sum over this array yields the number of rooms in use at each
     * moment. The maximum value encountered is the minimum number of rooms required.
     * <p>
     * Idea:
     * Each meeting contributes +1 to the active room count when it starts and -1 when it ends.
     * By accumulating these changes over time, we effectively track how many meetings overlap
     * at every time point. The peak overlap represents the minimum number of rooms needed.
     * <p>
     * Complexity:
     * Time: O(N + T) — scanning intervals plus iterating through the time range,
     * where T is the maximum end time. This is efficient only when T is reasonably small.
     * Space: O(T) — difference array sized by the maximum end time.
     *
     * @param intervals array of meeting intervals, where each interval is [start, end]
     * @return minimum number of meeting rooms required to host all intervals
     */
    public int minMeetingRooms_diff_array(int[][] intervals) {
        int maxEndTime = 0;
        int maxRooms = 0;
        int currentRooms = 0;

        // Maximum end time among all intervals
        for (int[] interval : intervals) {
            maxEndTime = Math.max(maxEndTime, interval[1]);
        }

        // Difference array to track room usage changes at each time point
        int[] differenceArray = new int[maxEndTime + 1];

        for (int[] interval : intervals) {
            differenceArray[interval[0]]++; // +1 at start time means one more room is needed
            differenceArray[interval[1]]--; // -1 at end time means one room is freed
        }

        for (int roomChange : differenceArray) {
            currentRooms += roomChange;
            maxRooms = Math.max(maxRooms, currentRooms);
        }

        return maxRooms;
    }
}
