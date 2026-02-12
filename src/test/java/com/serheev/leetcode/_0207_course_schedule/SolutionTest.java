package com.serheev.leetcode._0207_course_schedule;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    @DisplayName("No prerequisites → always possible")
    void t1() {
        assertTrue(solution.canFinish(5, new int[][]{}));
    }

    @Test
    @DisplayName("Single prerequisite, valid")
    void t2() {
        int[][] prereq = {{1, 0}}; // 0 → 1
        assertTrue(solution.canFinish(2, prereq));
    }

    @Test
    @DisplayName("Simple cycle of length 2")
    void t3() {
        int[][] prereq = {{0, 1}, {1, 0}};
        assertFalse(solution.canFinish(2, prereq));
    }

    @Test
    @DisplayName("Simple valid chain")
    void t4() {
        int[][] prereq = {{1, 0}, {2, 1}, {3, 2}}; // 0 → 1 → 2 → 3
        assertTrue(solution.canFinish(4, prereq));
    }

    @Test
    @DisplayName("Cycle of length 3")
    void t5() {
        int[][] prereq = {
                {1, 0},
                {2, 1},
                {0, 2}  // cycle
        };
        assertFalse(solution.canFinish(3, prereq));
    }

    @Test
    @DisplayName("Multiple components, all valid")
    void t6() {
        int[][] prereq = {
                {1, 0}, // component A
                {3, 2}  // component B
        };
        assertTrue(solution.canFinish(4, prereq));
    }

    @Test
    @DisplayName("Multiple components, one contains a cycle")
    void t7() {
        int[][] prereq = {
                {1, 0},
                {2, 1},
                {0, 2}, // cycle in component A
                {4, 3}  // component B is fine
        };
        assertFalse(solution.canFinish(5, prereq));
    }

    @Test
    @DisplayName("Self-loop is an immediate cycle")
    void t8() {
        int[][] prereq = {{1, 1}};
        assertFalse(solution.canFinish(2, prereq));
    }

    @Test
    @DisplayName("Repeated edges should not break logic")
    void t9() {
        int[][] prereq = {
                {1, 0},
                {1, 0},
                {1, 0}
        };
        assertTrue(solution.canFinish(2, prereq));
    }

    @Test
    @DisplayName("Diamond-shaped DAG (valid)")
    void t10() {
        //    0
        //   / \
        //  1   2
        //   \ /
        //    3
        int[][] prereq = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        };
        assertTrue(solution.canFinish(4, prereq));
    }

    @Test
    @DisplayName("Complex cycle hidden inside larger graph")
    void t11() {
        int[][] prereq = {
                {1, 0},
                {2, 1},
                {3, 2},
                {1, 3}, // cycle: 1 → 2 → 3 → 1
                {5, 4}
        };
        assertFalse(solution.canFinish(6, prereq));
    }
}

