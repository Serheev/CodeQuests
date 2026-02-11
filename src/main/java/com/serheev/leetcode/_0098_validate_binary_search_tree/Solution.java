package com.serheev.leetcode._0098_validate_binary_search_tree;

/**
 * Problem: 98. Validate Binary Search Tree (medium)
 * URL: https://leetcode.com/problems/validate-binary-search-tree/
 * <p>
 * Description:
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * A valid BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys strictly less than the node's key.
 * The right subtree of a node contains only nodes with keys strictly greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [1, 10^4].
 * -2^31 <= Node.val <= 2^31 - 1
 * <p>
 * Example 1:
 * Input: root = [2,1,3]
 * Output: true
 * <p>
 * Example 2:
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 * <p>
 * Categories:
 * - Binary Tree
 */
public class Solution {

    /**
     * Validates whether a binary tree is a valid Binary Search Tree (BST).
     * A BST must satisfy the property that for every node:
     * - all values in the left subtree are strictly less than the node's value
     * - all values in the right subtree are strictly greater than the node's value
     * <p>
     * Approach:
     * A depth‑first search (DFS) is used with value boundaries. Each recursive
     * call enforces that the current node's value must lie strictly between
     * a lower and upper bound. As the recursion descends left or right,
     * the bounds tighten accordingly.
     * <p>
     * This method correctly handles:
     * - deep violations (not just direct children)
     * - duplicate values (duplicates invalidate the BST)
     * <p>
     * Complexity:
     * Time: O(n), where n is the number of nodes.
     * Space: O(h), where h is the height of the tree (recursion stack).
     *
     * @param root the root of the binary tree
     * @return true if the tree is a valid BST, false otherwise
     */
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private boolean validate(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;

        // Check current node value against allowed range
        if (min != null && node.val <= min) return false;
        if (max != null && node.val >= max) return false;

        // Left subtree: max becomes node.val
        // Right subtree: min becomes node.val
        return validate(node.left, min, node.val)
                && validate(node.right, node.val, max);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int x, TreeNode left, TreeNode right) {
            this.val = x;
            this.left = left;
            this.right = right;
        }
    }
}

