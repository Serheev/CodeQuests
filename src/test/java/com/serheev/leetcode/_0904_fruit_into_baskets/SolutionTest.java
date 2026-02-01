package com.serheev.leetcode._0904_fruit_into_baskets;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    @DisplayName("Basic example: [1,2,1] → 3")
    void t1() {
        assertEquals(3, solution.totalFruit(new int[]{1, 2, 1}));
    }

    @Test
    @DisplayName("Example: [0,1,2,2] → 3")
    void t2() {
        assertEquals(3, solution.totalFruit(new int[]{0, 1, 2, 2}));
    }

    @Test
    @DisplayName("Example: [1,2,3,2,2] → 4")
    void t3() {
        assertEquals(4, solution.totalFruit(new int[]{1, 2, 3, 2, 2}));
    }

    @Test
    @DisplayName("All same fruit")
    void t4() {
        assertEquals(5, solution.totalFruit(new int[]{7, 7, 7, 7, 7}));
    }

    @Test
    @DisplayName("Alternating two fruits")
    void t5() {
        assertEquals(6, solution.totalFruit(new int[]{1, 2, 1, 2, 1, 2}));
    }

    @Test
    @DisplayName("Three types but only two allowed")
    void t6() {
        assertEquals(4, solution.totalFruit(new int[]{3, 3, 3, 1, 2}));
    }

    @Test
    @DisplayName("Single element")
    void t7() {
        assertEquals(1, solution.totalFruit(new int[]{5}));
    }

    @Test
    @DisplayName("Two elements, two types")
    void t8() {
        assertEquals(2, solution.totalFruit(new int[]{4, 9}));
    }

    @Test
    @DisplayName("Edge: empty array")
    void t9() {
        assertEquals(0, solution.totalFruit(new int[]{}));
    }

    @Test
    @DisplayName("Long block then switch")
    void t10() {
        assertEquals(7, solution.totalFruit(new int[]{2, 2, 2, 2, 2, 3, 3, 4}));
    }

}
