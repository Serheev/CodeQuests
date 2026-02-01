package com.serheev.leetcode._0252_meeting_rooms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    @DisplayName("Overlapping intervals → cannot attend all")
    void t1() {
        assertFalse(solution.canAttendMeetings(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
    }

    @Test
    @DisplayName("Non-overlapping intervals → can attend all")
    void t2() {
        assertTrue(solution.canAttendMeetings(new int[][]{{7, 10}, {2, 4}}));
    }

    @Test
    @DisplayName("Single meeting → always true")
    void t3() {
        assertTrue(solution.canAttendMeetings(new int[][]{{5, 8}}));
    }

    @Test
    @DisplayName("Identical intervals → conflict")
    void t4() {
        assertFalse(solution.canAttendMeetings(new int[][]{{3, 6}, {3, 6}}));
    }

    @Test
    @DisplayName("Touching intervals (end == start) → allowed")
    void t5() {
        assertTrue(solution.canAttendMeetings(new int[][]{{1, 3}, {3, 5}, {5, 8}}));
    }

    @Test
    @DisplayName("Unsorted intervals → must detect conflict after sorting")
    void t6() {
        assertFalse(solution.canAttendMeetings(new int[][]{{8, 10}, {1, 5}, {4, 6}}));
    }

    @Test
    @DisplayName("Large ranges with no overlap")
    void t7() {
        assertTrue(solution.canAttendMeetings(new int[][]{{0, 1000000}, {1000000, 2000000}}));
    }

    @Test
    @DisplayName("Negative time values (valid in some inputs)")
    void t8() {
        assertFalse(solution.canAttendMeetings(new int[][]{{-10, -1}, {-5, 5}}));
    }

    @Test
    @DisplayName("Multiple small intervals with one conflict")
    void t9() {
        assertFalse(solution.canAttendMeetings(new int[][]{{1, 2}, {2, 3}, {3, 4}, {3, 5}}));
    }

    @Test
    @DisplayName("Empty input → trivially true")
    void t10() {
        assertTrue(solution.canAttendMeetings(new int[][]{}));
    }
}
