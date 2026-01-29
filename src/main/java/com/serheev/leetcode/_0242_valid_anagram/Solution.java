package com.serheev.leetcode._0242_valid_anagram;

import java.util.Arrays;

/**
 * Problem: 242. Valid Anagram (easy)
 * URL: https://leetcode.com/problems/valid-anagram/
 * <p>
 * Description: Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 * <p>
 * Constraints:
 * 1 <= s.length, t.length <= 5 * 10^4
 * s and t consist of lowercase English letters.
 * <p>
 * Example 1:
 * Input: s = "anagram", t = "nagaram" *
 * Output: true
 * <p>
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 * <p>
 * Categories:
 * -
 */
public class Solution {

    /**
     * Approach:
     * Count character frequencies for both strings using a fixed-size array.
     * <p>
     * Idea:
     * For ASCII/lowercase input, a 128-sized (or 256-sized for Unicode characters) frequency array provides O(1) space.
     * Increment counts for s, decrement for t. Any non-zero entry → not an anagram.
     * <p>
     * Complexity:
     * Time: O(n)
     * Space: O(1)
     *
     * @param s first input string
     * @param t second input string
     * @return true if s and t are anagrams, false otherwise
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] freq = new int[256];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
            freq[t.charAt(i)]--;
        }

        for (int f : freq) {
            if (f != 0) return false;
        }

        return true;
    }

    /**
     * Approach:
     * Sort both input strings and compare the sorted results.
     * <p>
     * Idea:
     * Two strings are anagrams if they contain the same characters
     * with the same frequencies. Sorting normalizes character order,
     * making identical multisets of characters produce identical arrays.
     * <p>
     * Complexity:
     * Time: O(n log n) — sorting dominates
     * Space: O(n) — char arrays created from input strings
     *
     * @param s first input string
     * @param t second input string
     * @return true if s and t are anagrams, false otherwise
     */
    public boolean isAnagram_brute_force(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] a = s.toCharArray();
        char[] b = t.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }
}
