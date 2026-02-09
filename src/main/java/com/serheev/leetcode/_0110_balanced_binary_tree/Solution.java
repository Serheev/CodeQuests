package com.serheev.leetcode._0110_balanced_binary_tree;

/**
 * Problem: 110. Balanced Binary Tree (easy)
 * URL: https://leetcode.com/problems/balanced-binary-tree/
 * <p>
 * Description: Given a binary tree, determine if it is height-balanced.
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [0, 5000].
 * -10^4 <= Node.val <= 10^4
 * <p>
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: true
 * <p>
 * Example 2:
 * Input: root = [1,2,2,3,3,null,null,4,4]
 * Output: false
 * <p>
 * Example 3:
 * Input: root = []
 * Output: true
 * <p>
 * Categories:
 * - Binary Tree
 */
public class Solution {

    /**
     * Determines whether a binary tree is height-balanced. A tree is considered
     * balanced if, for every node, the heights of the left and right subtrees
     * differ by no more than one.
     * <p>
     * Approach:
     * A depth-first search (DFS) computes the height of each subtree. During
     * the recursion, if any subtree is found to be unbalanced, a sentinel value
     * (-1) is returned immediately to signal imbalance. This allows the algorithm
     * to short-circuit and avoid unnecessary traversal.
     * <p>
     * The helper method returns:
     * - the height of the subtree if it is balanced
     * - -1 if the subtree is unbalanced
     * <p>
     * Complexity:
     * Time: O(n), where n is the number of nodes, since each node is visited once.
     * Space: O(h), where h is the height of the tree (recursion stack).
     *
     * @param root the root of the binary tree
     * @return true if the tree is height-balanced, false otherwise
     */
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode node) {
        if (node == null) return 0;

        int left = height(node.left);
        if (left == -1) return -1; // left subtree unbalanced

        int right = height(node.right);
        if (right == -1) return -1; // right subtree unbalanced

        if (Math.abs(left - right) > 1) return -1; // current node unbalanced

        return 1 + Math.max(left, right);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
