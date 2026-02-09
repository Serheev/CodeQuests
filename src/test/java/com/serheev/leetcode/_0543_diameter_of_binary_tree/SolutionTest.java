package com.serheev.leetcode._0543_diameter_of_binary_tree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    @DisplayName("Empty tree")
    void t1() {
        assertEquals(0, solution.diameterOfBinaryTree(null));
    }

    @Test
    @DisplayName("Single node")
    void t2() {
        Solution.TreeNode root = new Solution.TreeNode(1);
        assertEquals(0, solution.diameterOfBinaryTree(root));
    }

    @Test
    @DisplayName("Two nodes")
    void t3() {
        Solution.TreeNode root =
                new Solution.TreeNode(1,
                        new Solution.TreeNode(2),
                        null
                );
        assertEquals(1, solution.diameterOfBinaryTree(root));
    }

    @Test
    @DisplayName("LeetCode example: [1,2,3,4,5]")
    void t4() {
        // Tree:
        //       1
        //     /   \
        //    2     3
        //   / \
        //  4   5
        Solution.TreeNode root =
                new Solution.TreeNode(1,
                        new Solution.TreeNode(2,
                                new Solution.TreeNode(4),
                                new Solution.TreeNode(5)
                        ),
                        new Solution.TreeNode(3)
                );
        assertEquals(3, solution.diameterOfBinaryTree(root));
    }

    @Test
    @DisplayName("Left-heavy tree")
    void t5() {
        // 1 - 2 - 3 - 4
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
        assertEquals(3, solution.diameterOfBinaryTree(root));
    }

    @Test
    @DisplayName("Right-heavy tree")
    void t6() {
        // 1 - 2 - 3 - 4 (right chain)
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
        assertEquals(3, solution.diameterOfBinaryTree(root));
    }

    @Test
    @DisplayName("Mixed asymmetric tree")
    void t7() {
        //       10
        //      /  \
        //     5    20
        //      \
        //       8
        //      /
        //     9
        Solution.TreeNode root =
                new Solution.TreeNode(10,
                        new Solution.TreeNode(5,
                                null,
                                new Solution.TreeNode(8,
                                        new Solution.TreeNode(9),
                                        null
                                )
                        ),
                        new Solution.TreeNode(20)
                );
        // Longest path: 9 -> 8 -> 5 -> 10 -> 20 (4 edges)
        assertEquals(4, solution.diameterOfBinaryTree(root));
    }

    @Test
    @DisplayName("Wide balanced tree")
    void t8() {
        // Perfect tree depth 3 → diameter = 4
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
        assertEquals(4, solution.diameterOfBinaryTree(root));
    }
}
