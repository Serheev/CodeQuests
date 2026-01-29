package com.serheev.leetcode._0340_longest_substring_with_at_most_k_distinct_characters;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: 340. Longest Substring with At Most K Distinct Characters (medium)
 * URL: https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 * <p>
 * Description: You are given a string s and an integer k. Your task is to find the length of the longest substring
 * within s that contains at most k distinct characters.
 * <p>
 * Constraints:
 * - 1 <= s.length <= 10^5
 * - s consists of ASCII characters
 * - 1 <= k <= s.length
 * <p>
 * Example 1:
 * Input: s = "eceba", k = 2
 * Output: 3
 * Explanation: "ece" contains 2 distinct characters.
 * <p>
 * Example 2:
 * Input: s = "aa", k = 1
 * Output: 2
 * <p>
 * Categories:
 * - Sliding Window
 * - Hash Map
 * - Two Pointers
 */
public class Solution {

    /**
     * Approach:
     *
     * <p>
     * Idea:
     *
     * <p>
     * Complexity:
     * Time: O()
     * Space: O()
     *
     * @param s input string
     * @return int
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        char[] characters = s.toCharArray();
        int[] freq = new int[128];
        int left = 0;
        int distinct = 0;

        for (int right = 0; right < characters.length; right++) {
            char c = characters[right];

            if (freq[c] == 0) {
                distinct++;
            }

            freq[c]++;

            if (distinct > k) {
                c = characters[left];
                freq[c]--;
                if (freq[c] == 0) {
                    distinct--;
                }
                left++;
            }

        }

        return characters.length - left;
    }

    /**
     * Approach:
     * Sliding window with a frequency map. Expand the window by iterating through
     * characters from left to right and tracking character counts. Whenever the
     * number of distinct characters exceeds k, shrink the window from the left
     * until the constraint is restored.
     * <p>
     * Idea:
     * Maintain a window that always contains at most k distinct characters.
     * The left pointer moves only when necessary (i.e., when distinct > k),
     * ensuring the window remains valid. Since the window expands across the
     * entire string and shrinks only when required, the final window size is
     * computed as total length minus the final left pointer position.
     * <p>
     * Complexity:
     * Time: O(n) — each character is processed at most twice (entering and leaving the window).
     * Space: O(k) — frequency map stores at most k distinct characters.
     *
     * @param s input string
     * @param k maximum allowed number of distinct characters in the window
     * @return length of the longest substring containing at most k distinct characters
     */
    public int lengthOfLongestSubstringKDistinct_hashmap(String s, int k) {
        Map<Character, Integer> charFrequency = new HashMap<>();
        char[] characters = s.toCharArray();
        int left = 0;

        for (char currentChar : characters) {
            // Add current character to the window and increment its frequency
            charFrequency.merge(currentChar, 1, Integer::sum);

            // If we have more than k distinct characters, shrink the window from left
            if (charFrequency.size() > k) {
                char leftChar = characters[left];
                if (charFrequency.merge(leftChar, -1, Integer::sum) == 0) {
                    charFrequency.remove(leftChar);
                }
                left++;
            }
        }

        // we only move left pointer when necessary to maintain at most k distinct chars
        return characters.length - left;
    }

    /**
     * Approach:
     * Brute-force enumeration of all possible substrings. For each starting index i,
     * expand the substring to the right while tracking character frequencies and the
     * number of distinct characters. Stop expanding when the number of distinct
     * characters exceeds k.
     * <p>
     * Idea:
     * Try every substring s[i..j] and maintain a frequency array to count distinct
     * characters. A substring is valid as long as distinct <= k. Track the maximum
     * valid window length encountered during the enumeration.
     * <p>
     * Complexity:
     * Time: O(n^2) — two nested loops over the string, with O(1) work inside.
     * Space: O(1) — fixed-size frequency array (ASCII 128).
     *
     * @param s input string
     * @param k maximum allowed number of distinct characters in the window
     * @return length of the longest substring containing at most k distinct characters
     */
    public int lengthOfLongestSubstringKDistinct_brute_force(String s, int k) {
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            int[] freq = new int[128];
            int distinct = 0;

            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);

                if (freq[c] == 0) {
                    distinct++;
                }

                freq[c]++;

                if (distinct > k) {
                    break;
                }

                max = Math.max(max, j - i + 1);
            }
        }

        return max;
    }
}
