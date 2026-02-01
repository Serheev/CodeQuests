package com.serheev.leetcode._0076_minimum_window_substring;

/**
 * Problem: 76. Minimum Window Substring (hard)
 * URL: https://leetcode.com/problems/minimum-window-substring/
 * <p>
 * Description:
 * Given two strings s and t, return the minimum window in s which contains all characters of t (including duplicates).
 * If no such window exists, return an empty string.
 * <p>
 * Constraints:
 * 1 <= s.length, t.length <= 10^5
 * s and t consist of ASCII characters
 * Order in s does not matter, only coverage of all chars in t
 * <p>
 * Example 1:
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * <p>
 * Example 2:
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * <p>
 * Example 3:
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 * <p>
 * Categories:
 * - Sliding Window
 * - Two Pointers
 * - Hash Table / Frequency Counting
 */
public class Solution {

    /**
     * Approach:
     * Sliding window with two pointers. Expand the window to include required characters,
     * then contract it to find the minimum valid substring. Frequency array tracks how
     * many characters are still needed to satisfy t.
     * <p>
     * Idea:
     * Maintain a running count of required characters. Each time the window becomes valid
     * (all required characters covered), attempt to shrink it from the left to achieve
     * the smallest possible window. Update the global minimum when a valid window is found.
     * <p>
     * Complexity:
     * Time: O(M+N) — each character is processed at most twice (expand + contract)
     * Space: O(1) — fixed-size ASCII frequency array (128)
     *
     * @param s input string
     * @param t target string containing required characters
     * @return the minimum window substring of s that contains all characters of t,
     * or an empty string if no valid window exists
     */
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        int[] need = new int[128];
        int required = t.length();

        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);

            if (need[rightChar] > 0) {
                required--;
            }
            need[rightChar]--;

            while (required == 0) {
                int wLen = right - left + 1;

                if (wLen < minLen) {
                    minLen = wLen;
                    start = left;
                }

                char leftChar = s.charAt(left);
                need[leftChar]++;

                if (need[leftChar] > 0) {
                    required++;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }


    /**
     * Approach:
     * Brute force over all possible substrings of s. For each window s[left..right],
     * check whether it contains all required characters of t using a frequency comparison.
     * <p>
     * Idea:
     * Enumerate every substring and validate it by counting character frequencies.
     * Track the minimum-length valid window. This guarantees correctness but is
     * computationally expensive due to full window recomputation for each pair.
     * <p>
     * Complexity:
     * Time: O(n^3) — O(n^2) windows, each validated in O(n)
     * Space: O(1) — fixed-size frequency arrays (128 ASCII)
     *
     * @param s input string
     * @param t target string containing required characters
     * @return the minimum window substring of s containing all characters of t,
     * or an empty string if no valid window exists
     */
    public String minWindow_brute_force(String s, String t) {
        String result = "";

        if (t.length() > s.length()) return result;

        int minLen = Integer.MAX_VALUE;
        int[] need = new int[128];

        for (char c : t.toCharArray()) {
            need[c]++;
        }

        for (int left = 0; left < s.length(); left++) {
            for (int right = left; right < s.length(); right++) {
                if (covers(s, left, right, need)) {
                    int wLen = right - left + 1;
                    if (wLen < minLen) {
                        minLen = wLen;
                        result = s.substring(left, right + 1);
                    }
                }
            }
        }

        return result;
    }

    private boolean covers(String s, int left, int right, int[] need) {
        int[] have = new int[128];

        for (int i = left; i <= right; i++) {
            have[s.charAt(i)]++;
        }

        for (int c = 0; c < 128; c++) {
            if (have[c] < need[c]) return false;
        }

        return true;
    }
}
