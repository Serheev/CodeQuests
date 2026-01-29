package com.serheev.leetcode._0242_valid_anagram;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    @DisplayName("Basic valid anagram")
    void t1() {
        assertTrue(solution.isAnagram("anagram", "nagaram"));
    }

    @Test
    @DisplayName("Basic invalid anagram")
    void t2() {
        assertFalse(solution.isAnagram("rat", "car"));
    }

    @Test
    @DisplayName("Different lengths")
    void t3() {
        assertFalse(solution.isAnagram("abc", "ab"));
    }

    @Test
    @DisplayName("Both empty")
    void t4() {
        assertTrue(solution.isAnagram("", ""));
    }

    @Test
    @DisplayName("One empty")
    void t5() {
        assertFalse(solution.isAnagram("", "a"));
    }

    @Test
    @DisplayName("Repeating characters valid")
    void t6() {
        assertFalse(solution.isAnagram("aaabbbbcc", "bcbababbc"));
    }

    @Test
    @DisplayName("Repeating characters invalid")
    void t7() {
        assertFalse(solution.isAnagram("aabb", "abbb"));
    }

    @Test
    @DisplayName("Case sensitivity")
    void t8() {
        assertFalse(solution.isAnagram("a", "A"));
    }

    @Test
    @DisplayName("Unicode valid")
    void t9() {
        assertTrue(solution.isAnagram("àáâ", "âàá"));
    }

    @Test
    @DisplayName("Unicode invalid")
    void t10() {
        assertFalse(solution.isAnagram("àáâ", "âàa"));
    }

}
