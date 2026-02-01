package com.serheev.leetcode._3477_fruits_into_baskets_ii;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    @DisplayName("All fruits fit perfectly into baskets")
    void t1() {
        assertEquals(0, solution.numOfUnplacedFruits(new int[]{3, 6, 1}, new int[]{6, 4, 7}));
    }

    @Test
    @DisplayName("One fruit type cannot be assigned")
    void t2() {
        assertEquals(1, solution.numOfUnplacedFruits(new int[]{4, 2, 5}, new int[]{3, 5, 4}));
    }

    @Test
    @DisplayName("No baskets can fit any fruit")
    void t3() {
        assertEquals(3, solution.numOfUnplacedFruits(new int[]{5, 6, 7}, new int[]{1, 1, 1}));
    }

    @Test
    @DisplayName("All baskets too small except one")
    void t4() {
        assertEquals(2, solution.numOfUnplacedFruits(new int[]{10, 2, 3}, new int[]{9, 1, 1}));
    }

    @Test
    @DisplayName("Exact capacity match")
    void t5() {
        assertEquals(0, solution.numOfUnplacedFruits(new int[]{2, 3, 4}, new int[]{2, 3, 4}));
    }

    @Test
    @DisplayName("Multiple fruits require the same basket size")
    void t6() {
        assertEquals(1, solution.numOfUnplacedFruits(new int[]{5, 5, 5}, new int[]{5, 5, 4}));
    }

    @Test
    @DisplayName("Large values, mixed fit")
    void t7() {
        assertEquals(1, solution.numOfUnplacedFruits(new int[]{10000, 5000, 9999}, new int[]{9999, 10000, 3000}));
    }

    @Test
    @DisplayName("Order matters — greedy leftmost assignment")
    void t8() {
        assertEquals(1, solution.numOfUnplacedFruits(new int[]{8, 3, 8}, new int[]{8, 8, 3}));
    }

    @Test
    @DisplayName("All fruits identical, all baskets identical")
    void t9() {
        assertEquals(0, solution.numOfUnplacedFruits(new int[]{4, 4, 4}, new int[]{4, 4, 4}));
    }

    @Test
    @DisplayName("All fruits identical, not enough baskets")
    void t10() {
        assertEquals(2, solution.numOfUnplacedFruits(new int[]{4, 4, 4}, new int[]{4}));
    }
}
