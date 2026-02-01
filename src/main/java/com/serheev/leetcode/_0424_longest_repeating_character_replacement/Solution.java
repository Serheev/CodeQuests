package com.serheev.leetcode._0424_longest_repeating_character_replacement;

/**
 * Problem: 424. Longest Repeating Character Replacement (medium)
 * URL: https://leetcode.com/problems/longest-repeating-character-replacement/
 * <p>
 * Description:
 * Given a string s and an integer k, return the length of the longest substring
 * that can be obtained by replacing at most k characters so that all characters
 * in the substring are the same.
 * <p>
 * Constraints:
 * 1 <= s.length <= 10^5
 * s consists of uppercase English letters
 * 0 <= k <= s.length
 * <p>
 * Example 1:
 * Input: s = "ABAB", k = 2
 * Output: 4
 * Explanation: Replace the two 'A's with two 'B's or vice versa.
 * <p>
 * Example 2:
 * Input: s = "AABABBA", k = 1
 * Output: 4
 * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 * There may exists other ways to achieve this answer too.
 * <p>
 * Categories:
 * - Sliding Window
 * - Two Pointers
 * - Frequency Counting
 */

public class Solution {

    /**
     * Approach:
     * Sliding window with frequency counting. Expand the window by moving the right pointer,
     * track the count of the most frequent character inside the window, and shrink the window
     * from the left when the number of required replacements exceeds k.
     * <p>
     * Idea:
     * A window is valid if (windowSize - maxFreq) <= k, meaning all non‑dominant characters
     * can be replaced. Maintain maxFreq as the highest frequency of any character in the
     * current window. This allows the window to grow greedily while staying valid, and shrink
     * only when necessary. Update the maximum valid window length during iteration.
     * <p>
     * Complexity:
     * Time: O(n) — each character is processed at most twice (right expands, left contracts)
     * Space: O(1) — fixed-size array for 26 uppercase English letters
     *
     * @param s input string
     * @param k maximum allowed replacements
     * @return length of the longest valid substring
     */
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            int idx = s.charAt(right) - 'A';
            int window = right - left + 1;
            freq[idx]++;
            maxFreq = Math.max(maxFreq, freq[idx]);

            if (window - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
                window--;
            }

            maxLen = Math.max(maxLen, window);
        }

        return maxLen;
    }

    /**
     * Approach:
     * Sliding window with frequency counting. Expand the window by moving the right pointer,
     * track the most frequent character in the window, and shrink from the left when the
     * number of required replacements exceeds k.
     * <p>
     * Idea:
     * A window is valid if (windowSize - maxFreq) <= k, meaning all non‑dominant characters
     * can be replaced. Maintain maxFreq as the highest frequency of any character in the
     * current window. Update the maximum valid window length while adjusting the window
     * boundaries dynamically.
     * <p>
     * Complexity:
     * Time: O(n) — each character is processed at most twice (right expands, left contracts)
     * Space: O(1) — fixed-size frequency array for 26 uppercase letters
     *
     * @param s input string
     * @param k maximum allowed replacements
     * @return length of the longest valid substring
     */
    public int characterReplacement_int128(String s, int k) {
        int windowSize = 0;
        int maxFreq = 0;
        int[] freqChars = new int[128];
        int maxLen = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            freqChars[c]++;
            maxFreq = Math.max(maxFreq, freqChars[c]);
            windowSize = right - left + 1;

            if (windowSize - maxFreq > k) {
                freqChars[s.charAt(left)]--;
                left++;
                windowSize--;
            }

            maxLen = Math.max(maxLen, windowSize);

        }

        return maxLen;
    }
}
