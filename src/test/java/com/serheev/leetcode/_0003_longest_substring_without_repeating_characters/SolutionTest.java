package com.serheev.leetcode._0003_longest_substring_without_repeating_characters;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();
    @Test
    @DisplayName("Basic: 'abcabcbb' → 3")
    void testBasic() {
        assertEquals(3, solution.lengthOfLongestSubstring("abcabcbb"));
    }

    @Test
    @DisplayName("All unique: 'abcdef' → 6")
    void testAllUnique() {
        assertEquals(6, solution.lengthOfLongestSubstring("abcdef"));
    }

    @Test
    @DisplayName("All same characters: 'aaaaaa' → 1")
    void testAllSame() {
        assertEquals(1, solution.lengthOfLongestSubstring("aaaaaa"));
    }

    @Test
    @DisplayName("Empty string: '' → 0")
    void testEmpty() {
        assertEquals(0, solution.lengthOfLongestSubstring(""));
    }

    @Test
    @DisplayName("Single character: 'z' → 1")
    void testSingleChar() {
        assertEquals(1, solution.lengthOfLongestSubstring("z"));
    }

    @Test
    @DisplayName("Repeating pattern: 'pwwkew' → 3 ('wke')")
    void testRepeatingPattern() {
        assertEquals(3, solution.lengthOfLongestSubstring("pwwkew"));
    }

    @Test
    @DisplayName("String with spaces: 'a b c a b' → 3")
    void testWithSpaces() {
        assertEquals(3, solution.lengthOfLongestSubstring("a b c a b"));
    }

    @Test
    @DisplayName("Numbers and letters: 'a1b2c3a1' → 6")
    void testAlphanumeric() {
        assertEquals(6, solution.lengthOfLongestSubstring("a1b2c3a1"));
    }

    @Test
    @DisplayName("Edge case: substring at the end 'bbtablud' → 6 ('tablud')")
    void testSubstringAtEnd() {
        assertEquals(6, solution.lengthOfLongestSubstring("bbtablud"));
    }
}