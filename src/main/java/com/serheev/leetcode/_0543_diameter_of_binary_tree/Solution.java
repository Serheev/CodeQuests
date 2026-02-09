package com.serheev.leetcode._0543_diameter_of_binary_tree;

/**
 * Problem: 543. Diameter of Binary Tree (easy)
 * URL: https://leetcode.com/problems/diameter-of-binary-tree/
 * <p>
 * Description:
 * Given the root of a binary tree, return the length of the diameter of the tree. *
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 * The length of a path between two nodes is represented by the number of edges between them.
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [1, 10^4].
 * -100 <= Node.val <= 100
 * <p>
 * Example 1:
 * Input: root = [1,2,3,4,5]
 * Output: 3
 * Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
 * <p>
 * Example 2:
 * Input: root = [1,2]
 * Output: 1
 * <p>
 * Categories:
 * - Binary Tree
 */
public class Solution {

    /**
     * Computes the diameter of a binary tree, defined as the length (in edges)
     * of the longest path between any two nodes in the tree. The path does not
     * need to pass through the root.
     * <p>
     * Approach:
     * A depth‑first search (DFS) is used to compute the height of each subtree.
     * For every node, the longest path passing through that node is the sum of
     * the heights of its left and right subtrees. The global maximum of these
     * values is the tree's diameter.
     * <p>
     * The DFS returns the height of the current subtree, while updating a
     * shared field that tracks the maximum diameter found so far.
     * <p>
     * Complexity:
     * Time: O(n), where n is the number of nodes, since each node is visited once.
     * Space: O(h), where h is the height of the tree (recursion stack).
     *
     * @param root the root of the binary tree
     * @return the diameter of the tree measured in edges
     */

    private int max;

    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        dfs(root);

        return max;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);

        max = Math.max(max, left + right);

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
