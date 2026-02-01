package com.serheev.leetcode._0076_minimum_window_substring;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    @DisplayName("Basic example: ADOBECODEBANC / ABC → BANC")
    void t1() {
        assertEquals("BANC", solution.minWindow("ADOBECODEBANC", "ABC"));
    }

    @Test
    @DisplayName("Single char match")
    void t2() {
        assertEquals("a", solution.minWindow("a", "a"));
    }

    @Test
    @DisplayName("Single char no match")
    void t3() {
        assertEquals("", solution.minWindow("a", "b"));
    }

    @Test
    @DisplayName("Target longer than source")
    void t4() {
        assertEquals("", solution.minWindow("a", "aa"));
    }

    @Test
    @DisplayName("Exact match")
    void t5() {
        assertEquals("abc", solution.minWindow("abc", "abc"));
    }

    @Test
    @DisplayName("Multiple possible windows, choose minimum")
    void t6() {
        assertEquals("ba", solution.minWindow("bba", "ba"));
    }

    @Test
    @DisplayName("Repeated characters in target")
    void t7() {
        assertEquals("aab", solution.minWindow("aaab", "aab"));
    }

    @Test
    @DisplayName("No valid window")
    void t8() {
        assertEquals("", solution.minWindow("xyz", "abc"));
    }

    @Test
    @DisplayName("All characters identical")
    void t9() {
        assertEquals("aaa", solution.minWindow("aaaaaa", "aaa"));
    }

    @Test
    @DisplayName("Window at the end")
    void t10() {
        assertEquals("cde", solution.minWindow("zzzcde", "cde"));
    }
}
