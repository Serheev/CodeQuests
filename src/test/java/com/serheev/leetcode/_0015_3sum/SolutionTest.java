package com.serheev.leetcode._0015_3sum;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    private Set<List<Integer>> toSet(List<List<Integer>> list) {
        Set<List<Integer>> set = new HashSet<>();

        for (List<Integer> triplet : list) {
            List<Integer> sorted = new ArrayList<>(triplet);
            Collections.sort(sorted);
            set.add(sorted);
        }

        return set;
    }

    @Test
    @DisplayName("Example from LeetCode")
    void t1() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Set<List<Integer>> expected = Set.of(List.of(-1, -1, 2), List.of(-1, 0, 1));
        assertEquals(expected, toSet(solution.threeSum(nums)));
    }

    @Test
    @DisplayName("No triplets possible")
    void t2() {
        int[] nums = {1, 2, 3, 4};
        assertTrue(solution.threeSum(nums).isEmpty());
    }

    @Test
    @DisplayName("All zeros → one triplet")
    void t3() {
        int[] nums = {0, 0, 0, 0, 0};
        Set<List<Integer>> expected = Set.of(List.of(0, 0, 0));
        assertEquals(expected, toSet(solution.threeSum(nums)));
    }

    @Test
    @DisplayName("Only positive numbers → no solution")
    void t4() {
        int[] nums = {5, 7, 9, 11};
        assertTrue(solution.threeSum(nums).isEmpty());
    }

    @Test
    @DisplayName("Only negative numbers → no solution")
    void t5() {
        int[] nums = {-5, -7, -9, -11};
        assertTrue(solution.threeSum(nums).isEmpty());
    }

    @Test
    @DisplayName("Mixed numbers with duplicates")
    void t6() {
        int[] nums = {-2, 0, 1, 1, 2};
        Set<List<Integer>> expected = Set.of(List.of(-2, 0, 2), List.of(-2, 1, 1));
        assertEquals(expected, toSet(solution.threeSum(nums)));
    }

    @Test
    @DisplayName("Large negative + large positive + zero")
    void t7() {
        int[] nums = {-100000, 0, 100000};
        Set<List<Integer>> expected = Set.of(List.of(-100000, 0, 100000));
        assertEquals(expected, toSet(solution.threeSum(nums)));
    }

    @Test
    @DisplayName("Edge case: array of length 2 → no solution")
    void t8() {
        int[] nums = {1, -1};
        assertTrue(solution.threeSum(nums).isEmpty());
    }

    @Test
    @DisplayName("Edge case: empty array")
    void t9() {
        int[] nums = {};
        assertTrue(solution.threeSum(nums).isEmpty());
    }

    @Test
    @DisplayName("Multiple valid triplets with overlaps")
    void t10() {
        int[] nums = {-3, -1, -1, 0, 1, 2, 2, 3};
        Set<List<Integer>> expected = Set.of(List.of(-3, 1, 2), List.of(-1, -1, 2), List.of(-1, 0, 1), List.of(-3, 0, 3));
        assertEquals(expected, toSet(solution.threeSum(nums)));
    }
}
