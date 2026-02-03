package com.serheev.leetcode._0020_valid_parentheses;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    @DisplayName("Simple valid pair")
    void t1() {
        assertTrue(solution.isValid("()"));
    }

    @Test
    @DisplayName("Multiple valid pairs")
    void t2() {
        assertTrue(solution.isValid("()[]{}"));
    }

    @Test
    @DisplayName("Mismatched types")
    void t3() {
        assertFalse(solution.isValid("(]"));
    }

    @Test
    @DisplayName("Nested valid structure")
    void t4() {
        assertTrue(solution.isValid("([])"));
    }

    @Test
    @DisplayName("Incorrect nesting order")
    void t5() {
        assertFalse(solution.isValid("([)]"));
    }

    @Test
    @DisplayName("Single opening bracket")
    void t6() {
        assertFalse(solution.isValid("("));
    }

    @Test
    @DisplayName("Single closing bracket")
    void t7() {
        assertFalse(solution.isValid("]"));
    }

    @Test
    @DisplayName("Long valid sequence")
    void t8() {
        assertTrue(solution.isValid("()(){}[]([])"));
    }

    @Test
    @DisplayName("Long invalid sequence")
    void t9() {
        assertFalse(solution.isValid("()(){[}]"));
    }

    @Test
    @DisplayName("Only nested brackets")
    void t10() {
        assertTrue(solution.isValid("{[()()]}"));
    }

    @Test
    @DisplayName("Extra closing bracket")
    void t11() {
        assertFalse(solution.isValid("()()]"));
    }

    @Test
    @DisplayName("Extra opening bracket")
    void t12() {
        assertFalse(solution.isValid("((()))("));
    }

    @Test
    @DisplayName("Empty string is valid")
    void t13() {
        assertTrue(solution.isValid(""));
    }
}
