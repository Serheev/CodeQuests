package com.serheev.leetcode._0003_longest_substring_without_repeating_characters;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * <p>
 * Given a string s, find the length of the longest substring without duplicate characters.
 * <p>
 * Constraints:
 * 0 <= s.length <= 5 * 10^4
 * s consists of English letters, digits, symbols and spaces.
 * <p>
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
 * <p>
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * <p>
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * <p>
 * Categories:
 * - Strings
 * - Sliding Window
 */
public class Solution {

    /**
     * Approach:
     * Sliding Window + Direct Index Table.
     * <p>
     * Idea:
     * Maintain a moving window [left..right] without repeating characters.
     * The index table stores the last seen position of each ASCII character,
     * allowing the left boundary to jump forward in O(1) time.
     * <p>
     * Complexity:
     * Time: O(n) — each character is processed once.
     * Space: O(1) — fixed-size array for ASCII lookup.
     *
     * @param s input string
     * @return length of the longest substring without repeating characters
     */
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int[] index = new int[128]; // assuming ASCII 128

        for (int right = 0, left = 0; right < s.length(); right++) {
            left = Math.max(index[s.charAt(right)], left);
            maxLength = Math.max(maxLength, right - left + 1);
            index[s.charAt(right)] = right + 1;
        }
        return maxLength;
    }

    /**
     * Approach:
     * Sliding Window + Direct Index Table.
     * <p>
     * Idea:
     * Using HashMap
     * <p>
     * Complexity:
     * Time: O(n)
     * Space: O(n)
     *
     * @param s input string
     * @return length of the longest substring without repeating characters
     */
    public static int lengthOfLongestSubstring_hashmap(String s) {
        Map<Character, Integer> characterIndexMap = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            Character currentCharacter = s.charAt(right);
            if (characterIndexMap.containsKey(currentCharacter)) {
                left = Math.max(left, characterIndexMap.get(currentCharacter) + 1);
            }
            characterIndexMap.put(currentCharacter, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    /**
     * Approach:
     * Brute Force (expand-from-each-index).
     * <p>
     * Idea:
     * For every starting index i, extend the substring to the right until a
     * repeated character is found. A boolean table tracks which characters
     * have appeared in the current substring.
     * <p>
     * Complexity:
     * Time: O(n²) — each starting index may scan forward until a duplicate.
     * Space: O(1) — fixed-size ASCII lookup table.
     *
     * @param s input string
     * @return length of the longest substring without repeating characters
     */
    public int lengthOfLongestSubstring_brute_force(String s) {
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            boolean[] seen = new boolean[128];

            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);

                if (seen[c]) {
                    break; // repeat
                }

                seen[c] = true;
                max = Math.max(max, j - i + 1);
            }
        }

        return max;
    }

}
