package com.serheev.leetcode._0253_meeting_rooms_ii;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    @DisplayName("Basic overlap → requires 2 rooms")
    void t1() {
        assertEquals(2, solution.minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
    }

    @Test
    @DisplayName("No overlap → requires only 1 room")
    void t2() {
        assertEquals(1, solution.minMeetingRooms(new int[][]{{7, 10}, {2, 4}}));
    }

    @Test
    @DisplayName("Fully nested intervals → requires 3 rooms")
    void t3() {
        assertEquals(3, solution.minMeetingRooms(new int[][]{{1, 10}, {2, 9}, {3, 8}}));
    }

    @Test
    @DisplayName("Touching intervals (end == start) → no extra room needed")
    void t4() {
        assertEquals(1, solution.minMeetingRooms(new int[][]{{1, 3}, {3, 5}, {5, 7}}));
    }

    @Test
    @DisplayName("Multiple overlaps with staggered times")
    void t5() {
        assertEquals(3, solution.minMeetingRooms(new int[][]{{1, 4}, {2, 5}, {7, 9}, {3, 6}}));
    }

    @Test
    @DisplayName("Single meeting → requires 1 room")
    void t6() {
        assertEquals(1, solution.minMeetingRooms(new int[][]{{5, 10}}));
    }

    @Test
    @DisplayName("Empty input → requires 0 rooms")
    void t7() {
        assertEquals(0, solution.minMeetingRooms(new int[][]{}));
    }

    @Test
    @DisplayName("Identical intervals → requires N rooms")
    void t8() {
        assertEquals(4, solution.minMeetingRooms(new int[][]{{2, 6}, {2, 6}, {2, 6}, {2, 6}}));
    }

    @Test
    @DisplayName("Large ranges with partial overlap")
    void t9() {
        assertEquals(2, solution.minMeetingRooms(new int[][]{{0, 1000000}, {500000, 1500000}}));
    }

    @Test
    @DisplayName("Unsorted input → algorithm must sort first")
    void t10() {
        assertEquals(2, solution.minMeetingRooms(new int[][]{{10, 20}, {0, 5}, {4, 15}}));
    }

    @Test
    @DisplayName("Many small intervals with one heavy overlap")
    void t11() {
        assertEquals(3, solution.minMeetingRooms(new int[][]{{1, 3}, {2, 4}, {3, 5}, {2, 6}}));
    }
}
