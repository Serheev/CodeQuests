package com.serheev.leetcode._0102_binary_tree_level_order_traversal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    @DisplayName("Empty tree")
    void t1() {
        assertEquals(List.of(), solution.levelOrder(null));
    }

    @Test
    @DisplayName("Single node")
    void t2() {
        Solution.TreeNode root = new Solution.TreeNode(1);
        assertEquals(List.of(List.of(1)), solution.levelOrder(root));
    }

    @Test
    @DisplayName("Two levels")
    void t3() {
        //    1
        //   / \
        //  2   3
        Solution.TreeNode root =
                new Solution.TreeNode(1,
                        new Solution.TreeNode(2),
                        new Solution.TreeNode(3)
                );

        assertEquals(
                List.of(
                        List.of(1),
                        List.of(2, 3)
                ),
                solution.levelOrder(root)
        );
    }

    @Test
    @DisplayName("LeetCode example: [3,9,20,null,null,15,7]")
    void t4() {
        //       3
        //     /   \
        //    9     20
        //         /  \
        //        15   7
        Solution.TreeNode root =
                new Solution.TreeNode(3,
                        new Solution.TreeNode(9),
                        new Solution.TreeNode(20,
                                new Solution.TreeNode(15),
                                new Solution.TreeNode(7)
                        )
                );

        assertEquals(
                List.of(
                        List.of(3),
                        List.of(9, 20),
                        List.of(15, 7)
                ),
                solution.levelOrder(root)
        );
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

        assertEquals(
                List.of(
                        List.of(1),
                        List.of(2),
                        List.of(3),
                        List.of(4)
                ),
                solution.levelOrder(root)
        );
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

        assertEquals(
                List.of(
                        List.of(1),
                        List.of(2),
                        List.of(3),
                        List.of(4)
                ),
                solution.levelOrder(root)
        );
    }

    @Test
    @DisplayName("Asymmetric tree")
    void t7() {
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

        assertEquals(
                List.of(
                        List.of(10),
                        List.of(5, 20),
                        List.of(8)
                ),
                solution.levelOrder(root)
        );
    }
}

