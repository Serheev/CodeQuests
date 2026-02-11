package com.serheev.leetcode._0236_lowest_common_ancestor_of_a_binary_tree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    @DisplayName("Example 1 from LeetCode")
    void t1() {
        // Tree:
        //       3
        //     /   \
        //    5     1
        //   / \   / \
        //  6  2  0   8
        //    / \
        //   7   4
        Solution.TreeNode n7 = new Solution.TreeNode(7);
        Solution.TreeNode n4 = new Solution.TreeNode(4);
        Solution.TreeNode n6 = new Solution.TreeNode(6);
        Solution.TreeNode n2 = new Solution.TreeNode(2, n7, n4);
        Solution.TreeNode n5 = new Solution.TreeNode(5, n6, n2);
        Solution.TreeNode n0 = new Solution.TreeNode(0);
        Solution.TreeNode n8 = new Solution.TreeNode(8);
        Solution.TreeNode n1 = new Solution.TreeNode(1, n0, n8);
        Solution.TreeNode root = new Solution.TreeNode(3, n5, n1);

        assertEquals(root, solution.lowestCommonAncestor(root, n5, n1));
    }

    @Test
    @DisplayName("Example 2 from LeetCode")
    void t2() {
        // LCA(5,4) = 5
        Solution.TreeNode n4 = new Solution.TreeNode(4);
        Solution.TreeNode n6 = new Solution.TreeNode(6);
        Solution.TreeNode n2 = new Solution.TreeNode(2, null, n4);
        Solution.TreeNode n5 = new Solution.TreeNode(5, n6, n2);
        Solution.TreeNode n1 = new Solution.TreeNode(1);
        Solution.TreeNode root = new Solution.TreeNode(3, n5, n1);

        assertEquals(n5, solution.lowestCommonAncestor(root, n5, n4));
    }

    @Test
    @DisplayName("Nodes are siblings")
    void t3() {
        //      1
        //     / \
        //    2   3
        Solution.TreeNode n2 = new Solution.TreeNode(2);
        Solution.TreeNode n3 = new Solution.TreeNode(3);
        Solution.TreeNode root = new Solution.TreeNode(1, n2, n3);

        assertEquals(root, solution.lowestCommonAncestor(root, n2, n3));
    }

    @Test
    @DisplayName("One node is ancestor of the other")
    void t4() {
        //      1
        //     /
        //    2
        //   /
        //  3
        Solution.TreeNode n3 = new Solution.TreeNode(3);
        Solution.TreeNode n2 = new Solution.TreeNode(2, n3, null);
        Solution.TreeNode root = new Solution.TreeNode(1, n2, null);

        assertEquals(n2, solution.lowestCommonAncestor(root, n2, n3));
    }

    @Test
    @DisplayName("Deep LCA in left subtree")
    void t5() {
        //        10
        //       /
        //      5
        //     / \
        //    3   7
        //       /
        //      6
        Solution.TreeNode n6 = new Solution.TreeNode(6);
        Solution.TreeNode n7 = new Solution.TreeNode(7, n6, null);
        Solution.TreeNode n3 = new Solution.TreeNode(3);
        Solution.TreeNode n5 = new Solution.TreeNode(5, n3, n7);
        Solution.TreeNode root = new Solution.TreeNode(10, n5, null);

        assertEquals(n5, solution.lowestCommonAncestor(root, n3, n6));
    }

    @Test
    @DisplayName("Deep LCA in right subtree")
    void t6() {
        //    1
        //     \
        //      2
        //       \
        //        3
        //       / \
        //      4   5
        Solution.TreeNode n4 = new Solution.TreeNode(4);
        Solution.TreeNode n5 = new Solution.TreeNode(5);
        Solution.TreeNode n3 = new Solution.TreeNode(3, n4, n5);
        Solution.TreeNode n2 = new Solution.TreeNode(2, null, n3);
        Solution.TreeNode root = new Solution.TreeNode(1, null, n2);

        assertEquals(n3, solution.lowestCommonAncestor(root, n4, n5));
    }
}

