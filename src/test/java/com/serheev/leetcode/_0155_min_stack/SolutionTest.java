package com.serheev.leetcode._0155_min_stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    @DisplayName("LeetCode example sequence")
    void t1() {
        Solution.MinStack stack = new Solution.MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        assertEquals(-3, stack.getMin());
        stack.pop();
        assertEquals(0, stack.top());
        assertEquals(-2, stack.getMin());
    }

    @Test
    @DisplayName("Push increasing values")
    void t2() {
        Solution.MinStack stack = new Solution.MinStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(1, stack.getMin());
        assertEquals(3, stack.top());
    }

    @Test
    @DisplayName("Push decreasing values")
    void t3() {
        Solution.MinStack stack = new Solution.MinStack();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        assertEquals(3, stack.getMin());
        stack.pop();
        assertEquals(4, stack.getMin());
    }

    @Test
    @DisplayName("Min changes after pops")
    void t4() {
        Solution.MinStack stack = new Solution.MinStack();
        stack.push(2);
        stack.push(1);
        stack.push(3);
        assertEquals(1, stack.getMin());
        stack.pop();
        assertEquals(1, stack.getMin());
        stack.pop();
        assertEquals(2, stack.getMin());
    }

    @Test
    @DisplayName("Repeated minimum values")
    void t5() {
        Solution.MinStack stack = new Solution.MinStack();
        stack.push(1);
        stack.push(1);
        stack.push(1);
        assertEquals(1, stack.getMin());
        stack.pop();
        assertEquals(1, stack.getMin());
        stack.pop();
        assertEquals(1, stack.getMin());
    }

    @Test
    @DisplayName("Mixed positive and negative values")
    void t6() {
        Solution.MinStack stack = new Solution.MinStack();
        stack.push(3);
        stack.push(-1);
        stack.push(2);
        stack.push(-5);
        assertEquals(-5, stack.getMin());
        stack.pop();
        assertEquals(-1, stack.getMin());
    }

    @Test
    @DisplayName("Single element push/pop")
    void t7() {
        Solution.MinStack stack = new Solution.MinStack();
        stack.push(10);
        assertEquals(10, stack.top());
        assertEquals(10, stack.getMin());
        stack.pop();
        // After pop, stack is empty — LeetCode does not define behavior,
        // so we do NOT call top() or getMin() here.
    }

    @Test
    @DisplayName("Stress: alternating push/pop")
    void t8() {
        Solution.MinStack stack = new Solution.MinStack();
        stack.push(5);
        assertEquals(5, stack.getMin());
        stack.push(4);
        assertEquals(4, stack.getMin());
        stack.pop();
        assertEquals(5, stack.getMin());
        stack.push(6);
        assertEquals(5, stack.getMin());
    }
}
