package com.serheev.leetcode._0424_longest_repeating_character_replacement;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    @DisplayName("Basic example: ABAB, k=2 → 4")
    void t1() {
        assertEquals(4, solution.characterReplacement("ABAB", 2));
    }

    @Test
    @DisplayName("Example: AABABBA, k=1 → 4")
    void t2() {
        assertEquals(4, solution.characterReplacement("AABABBA", 1));
    }

    @Test
    @DisplayName("All characters identical")
    void t3() {
        assertEquals(5, solution.characterReplacement("AAAAA", 2));
    }

    @Test
    @DisplayName("No replacements allowed")
    void t4() {
        assertEquals(1, solution.characterReplacement("ABCDE", 0));
    }

    @Test
    @DisplayName("k larger than string length")
    void t5() {
        assertEquals(6, solution.characterReplacement("ABCDEF", 10));
    }

    @Test
    @DisplayName("Single character string")
    void t6() {
        assertEquals(1, solution.characterReplacement("A", 5));
    }

    @Test
    @DisplayName("Two characters alternating")
    void t7() {
        assertEquals(5, solution.characterReplacement("ABABA", 2));
    }

    @Test
    @DisplayName("Window expands then contracts")
    void t8() {
        assertEquals(5, solution.characterReplacement("BAAABBB", 2));
    }

    @Test
    @DisplayName("Edge: empty string")
    void t9() {
        assertEquals(0, solution.characterReplacement("", 3));
    }

    @Test
    @DisplayName("Large block then noise")
    void t10() {
        assertEquals(8, solution.characterReplacement("AAAAAAABC", 1));
    }
}
