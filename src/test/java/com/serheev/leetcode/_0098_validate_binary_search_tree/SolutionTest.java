package com.serheev.leetcode._0098_validate_binary_search_tree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    @DisplayName("Empty tree is valid")
    void t1() {
        assertTrue(solution.isValidBST(null));
    }

    @Test
    @DisplayName("Single node is valid")
    void t2() {
        Solution.TreeNode root = new Solution.TreeNode(1);
        assertTrue(solution.isValidBST(root));
    }

    @Test
    @DisplayName("Simple valid BST")
    void t3() {
        //    2
        //   / \
        //  1   3
        Solution.TreeNode root =
                new Solution.TreeNode(2,
                        new Solution.TreeNode(1),
                        new Solution.TreeNode(3)
                );
        assertTrue(solution.isValidBST(root));
    }

    @Test
    @DisplayName("Invalid BST: right child < root")
    void t4() {
        //    5
        //   / \
        //  1   4
        //     / \
        //    3   6
        Solution.TreeNode root =
                new Solution.TreeNode(5,
                        new Solution.TreeNode(1),
                        new Solution.TreeNode(4,
                                new Solution.TreeNode(3),
                                new Solution.TreeNode(6)
                        )
                );
        assertFalse(solution.isValidBST(root));
    }

    @Test
    @DisplayName("Invalid BST: left subtree contains a value > root")
    void t5() {
        //      10
        //     /
        //    5
        //   /
        //  12   <-- violates BST rule
        Solution.TreeNode root =
                new Solution.TreeNode(10,
                        new Solution.TreeNode(5,
                                new Solution.TreeNode(12),
                                null
                        ),
                        null
                );
        assertFalse(solution.isValidBST(root));
    }

    @Test
    @DisplayName("Invalid BST: right subtree contains a value <= root")
    void t6() {
        //    8
        //     \
        //      7  <-- violates BST rule
        Solution.TreeNode root =
                new Solution.TreeNode(8,
                        null,
                        new Solution.TreeNode(7)
                );
        assertFalse(solution.isValidBST(root));
    }

    @Test
    @DisplayName("Valid BST with deeper structure")
    void t7() {
        //        8
        //      /   \
        //     3     10
        //    / \      \
        //   1   6      14
        //      / \     /
        //     4   7   13
        Solution.TreeNode root =
                new Solution.TreeNode(8,
                        new Solution.TreeNode(3,
                                new Solution.TreeNode(1),
                                new Solution.TreeNode(6,
                                        new Solution.TreeNode(4),
                                        new Solution.TreeNode(7)
                                )
                        ),
                        new Solution.TreeNode(10,
                                null,
                                new Solution.TreeNode(14,
                                        new Solution.TreeNode(13),
                                        null
                                )
                        )
                );
        assertTrue(solution.isValidBST(root));
    }

    @Test
    @DisplayName("Invalid BST: duplicate values")
    void t8() {
        //    2
        //   / \
        //  1   2  <-- duplicates not allowed
        Solution.TreeNode root =
                new Solution.TreeNode(2,
                        new Solution.TreeNode(1),
                        new Solution.TreeNode(2)
                );
        assertFalse(solution.isValidBST(root));
    }

    @Test
    @DisplayName("Invalid BST: violation deep in right subtree")
    void t9() {
        //        20
        //       /  \
        //     10    30
        //          /
        //        15   <-- violates: 15 < 20 but is in right subtree
        Solution.TreeNode root =
                new Solution.TreeNode(20,
                        new Solution.TreeNode(10),
                        new Solution.TreeNode(30,
                                new Solution.TreeNode(15),
                                null
                        )
                );
        assertFalse(solution.isValidBST(root));
    }
}

