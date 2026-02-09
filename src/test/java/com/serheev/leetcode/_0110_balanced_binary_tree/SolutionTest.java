package com.serheev.leetcode._0110_balanced_binary_tree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    @DisplayName("Empty tree (Example 3)")
    void t1() {
        assertTrue(solution.isBalanced(null));
    }

    @Test
    @DisplayName("Single node")
    void t2() {
        Solution.TreeNode root = new Solution.TreeNode(1);
        assertTrue(solution.isBalanced(root));
    }

    @Test
    @DisplayName("Example 1 from LeetCode")
    void t3() {
        // [3,9,20,null,null,15,7]
        Solution.TreeNode root =
                new Solution.TreeNode(3,
                        new Solution.TreeNode(9),
                        new Solution.TreeNode(20,
                                new Solution.TreeNode(15),
                                new Solution.TreeNode(7)
                        )
                );
        assertTrue(solution.isBalanced(root));
    }

    @Test
    @DisplayName("Example 2 from LeetCode")
    void t4() {
        // [1,2,2,3,3,null,null,4,4]
        Solution.TreeNode root =
                new Solution.TreeNode(1,
                        new Solution.TreeNode(2,
                                new Solution.TreeNode(3,
                                        new Solution.TreeNode(4),
                                        new Solution.TreeNode(4)
                                ),
                                new Solution.TreeNode(3)
                        ),
                        new Solution.TreeNode(2)
                );
        assertFalse(solution.isBalanced(root));
    }

    @Test
    @DisplayName("Perfectly balanced tree depth 3")
    void t5() {
        Solution.TreeNode root =
                new Solution.TreeNode(1,
                        new Solution.TreeNode(2,
                                new Solution.TreeNode(4),
                                new Solution.TreeNode(5)
                        ),
                        new Solution.TreeNode(3,
                                new Solution.TreeNode(6),
                                new Solution.TreeNode(7)
                        )
                );
        assertTrue(solution.isBalanced(root));
    }

    @Test
    @DisplayName("Left-heavy and balanced")
    void t6() {
        //      1
        //     / \
        //    2   X
        //   /
        //  3
        Solution.TreeNode root =
                new Solution.TreeNode(1,
                        new Solution.TreeNode(2,
                                new Solution.TreeNode(3),
                                null
                        ),
                        new Solution.TreeNode(99));
        assertTrue(solution.isBalanced(root));
    }

    @Test
    @DisplayName("Left-heavy and unbalanced")
    void t7() {
        Solution.TreeNode root =
                new Solution.TreeNode(1,
                        new Solution.TreeNode(2,
                                new Solution.TreeNode(3,
                                        new Solution.TreeNode(4),
                                        null
                                ),
                                null
                        ),
                        null
                );
        assertFalse(solution.isBalanced(root));
    }

    @Test
    @DisplayName("Right-heavy and unbalanced")
    void t8() {
        Solution.TreeNode root =
                new Solution.TreeNode(1,
                        null,
                        new Solution.TreeNode(2,
                                null,
                                new Solution.TreeNode(3,
                                        null,
                                        new Solution.TreeNode(4)
                                )
                        )
                );
        assertFalse(solution.isBalanced(root));
    }

    @Test
    @DisplayName("Asymmetric but balanced")
    void t9() {
        //       10
        //      /  \
        //     5    20
        //      \
        //       8
        Solution.TreeNode root =
                new Solution.TreeNode(10,
                        new Solution.TreeNode(5,
                                null,
                                new Solution.TreeNode(8)
                        ),
                        new Solution.TreeNode(20)
                );
        assertTrue(solution.isBalanced(root));
    }
}


