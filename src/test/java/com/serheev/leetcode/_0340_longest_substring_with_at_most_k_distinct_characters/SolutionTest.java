package com.serheev.leetcode._0340_longest_substring_with_at_most_k_distinct_characters;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    @DisplayName("s = eceba, k=2 → 3")
    void testExample1() {
        assertEquals(3, solution.lengthOfLongestSubstringKDistinct("eceba", 2));
    }

    @Test
    @DisplayName("All same chars: aa, k=1 → 2")
    void testAllSame() {
        assertEquals(2, solution.lengthOfLongestSubstringKDistinct("aa", 1));
    }

    @Test
    @DisplayName("k equals number of distinct chars → whole string")
    void testKEqualsDistinct() {
        assertEquals(5, solution.lengthOfLongestSubstringKDistinct("abcde", 5));
    }

    @Test
    @DisplayName("k larger than distinct chars → whole string")
    void testKLarger() {
        assertEquals(5, solution.lengthOfLongestSubstringKDistinct("abcde", 10));
    }

    @Test
    @DisplayName("s = aaabbbccc, k =  1 -> 3")
    void testK1() {
        assertEquals(3, solution.lengthOfLongestSubstringKDistinct("aaabbbccc", 1));
    }

    @Test
    @DisplayName("s = aaabbbcc, k = 2 -> 6")
    void testK2() {
        assertEquals(6, solution.lengthOfLongestSubstringKDistinct("aaabbbcc", 2));
    }

    @Test
    @DisplayName("Empty string -> 0")
    void testEmpty() {
        assertEquals(0, solution.lengthOfLongestSubstringKDistinct("", 2));
    }

    @Test
    @DisplayName("s = a, k =  1 -> 1")
    void testSingleChar() {
        assertEquals(1, solution.lengthOfLongestSubstringKDistinct("a", 1));
    }

    @Test
    @DisplayName("s = abaccc, k = 2 -> 4")
    void testRepeatingPattern() {
        assertEquals(4, solution.lengthOfLongestSubstringKDistinct("abaccc", 2));
    }

    @Test
    @DisplayName("s = abac, k = 2 -> 3")
    void testRepeatingPattern2() {
        assertEquals(3, solution.lengthOfLongestSubstringKDistinct("abac", 2));
    }

    @Test
    @DisplayName("s = abaccc, k = 1 -> 3")
    void testRepeatingPattern3() {
        assertEquals(3, solution.lengthOfLongestSubstringKDistinct("abaccc", 1));
    }

    @Test
    @DisplayName("s = abc, k = 0 → 0")
    void testKZero() {
        assertEquals(0, solution.lengthOfLongestSubstringKDistinct("abc", 0));
    }
}

