package com.serheev.leetcode._0104_maximum_depth_of_binary_tree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    private Solution.TreeNode n(Integer val) {
        return val == null ? null : new Solution.TreeNode(val);
    }

    @Test
    @DisplayName("Empty tree")
    void t1() {
        assertEquals(0, solution.maxDepth(null));
    }

    @Test
    @DisplayName("Single node")
    void t2() {
        Solution.TreeNode root = new Solution.TreeNode(1);
        assertEquals(1, solution.maxDepth(root));
    }

    @Test
    @DisplayName("Example 1 from LeetCode")
    void t3() {
        // [3,9,20,null,null,15,7]
        Solution.TreeNode root = new Solution.TreeNode(3, new Solution.TreeNode(9), new Solution.TreeNode(20, new Solution.TreeNode(15), new Solution.TreeNode(7)));
        assertEquals(3, solution.maxDepth(root));
    }

    @Test
    @DisplayName("Example 2 from LeetCode")
    void t4() {
        // [1,null,2]
        Solution.TreeNode root = new Solution.TreeNode(1, null, new Solution.TreeNode(2));
        assertEquals(2, solution.maxDepth(root));
    }

    @Test
    @DisplayName("Left-heavy tree")
    void t5() {
        Solution.TreeNode root = new Solution.TreeNode(1, new Solution.TreeNode(2, new Solution.TreeNode(3, new Solution.TreeNode(4), null), null), null);
        assertEquals(4, solution.maxDepth(root));
    }

    @Test
    @DisplayName("Right-heavy tree")
    void t6() {
        Solution.TreeNode root = new Solution.TreeNode(1, null, new Solution.TreeNode(2, null, new Solution.TreeNode(3, null, new Solution.TreeNode(4))));
        assertEquals(4, solution.maxDepth(root));
    }

    @Test
    @DisplayName("Balanced tree depth 3")
    void t7() {
        Solution.TreeNode root = new Solution.TreeNode(1, new Solution.TreeNode(2, new Solution.TreeNode(4), new Solution.TreeNode(5)), new Solution.TreeNode(3, new Solution.TreeNode(6), new Solution.TreeNode(7)));
        assertEquals(3, solution.maxDepth(root));
    }

    @Test
    @DisplayName("Mixed shape tree")
    void t8() {
        Solution.TreeNode root = new Solution.TreeNode(10, new Solution.TreeNode(5, null, new Solution.TreeNode(8, new Solution.TreeNode(9), null)), new Solution.TreeNode(20));
        assertEquals(4, solution.maxDepth(root));
    }
}
