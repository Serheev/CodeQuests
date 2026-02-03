package com.serheev.leetcode._0020_valid_parentheses;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem: 20. Valid Parentheses (easy)
 * URL: https://leetcode.com/problems/valid-parentheses/
 * <p>
 * Description:
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * - Open brackets must be closed by the same type of brackets.
 * - Open brackets must be closed in the correct order.
 * - Every close bracket has a corresponding open bracket of the same type.
 * <p>
 * Constraints:
 * 1 <= s.length <= 10^4
 * s consists of parentheses only '()[]{}'.
 * <p>
 * Example 1:
 * Input: s = "()"
 * Output: true
 * <p>
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 * <p>
 * Example 3:
 * Input: s = "(]"
 * Output: false
 * <p>
 * Example 4:
 * Input: s = "([])"
 * Output: true
 * <p>
 * Example 5:
 * Input: s = "([)]"
 * Output: false
 * <p>
 * Categories:
 * - Stack
 * - String
 */
public class Solution {

    /**
     * Approach:
     * Use a stack‑based scan over the string. Every opening bracket is pushed onto
     * the stack. Every closing bracket triggers a check: the stack must not be empty,
     * and the top element must be the matching opening bracket. If any mismatch or
     * premature closing bracket appears, the string is invalid.
     *
     * <p>
     * Idea:
     * Valid parentheses require correct ordering and proper nesting. A stack naturally
     * models this structure: last opened must be first closed. As we iterate through
     * the characters, we enforce this rule by pairing each closing bracket with the
     * most recent unmatched opening bracket.
     *
     * <p>
     * Complexity:
     * Time: O(n) — each character is processed exactly once.
     * Space: O(n) — in the worst case, all characters are opening brackets stored in the stack.
     *
     * @param s input string containing only '(', ')', '{', '}', '[' and ']'
     * @return true if the parentheses are valid, otherwise false
     */
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (ch == ')' && top != '(') return false;
                if (ch == '}' && top != '{') return false;
                if (ch == ']' && top != '[') return false;
            }
        }

        return stack.isEmpty();
    }
}
