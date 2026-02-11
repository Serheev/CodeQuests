package com.serheev.leetcode._0236_lowest_common_ancestor_of_a_binary_tree;

/**
 * Problem: 236. Lowest Common Ancestor of a Binary Tree (medium)
 * URL: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * <p>
 * Description:
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q
 * as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [2, 10^5].
 * -10^9 <= Node.val <= 10^9
 * All Node.val are unique.
 * p != q
 * p and q will exist in the tree.
 * <p>
 * Example 1:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * <p>
 * Example 2:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 * <p>
 * Example 3:
 * Input: root = [1,2], p = 1, q = 2
 * Output: 1
 * <p>
 * Categories:
 * -
 */
public class Solution {

    /**
     * Finds the lowest common ancestor (LCA) of two nodes in a binary tree.
     * The LCA is defined as the lowest node in the tree that has both p and q
     * as descendants (a node can be a descendant of itself).
     * <p>
     * Approach:
     * A depth‑first search (DFS) explores the tree recursively. If the current
     * node matches either p or q, it is returned upward. The recursion continues
     * through left and right subtrees. If both subtrees return non-null values,
     * the current node is the LCA. If only one side returns non-null, that value
     * is propagated upward.
     * <p>
     * This method relies on the guarantee that both p and q exist in the tree.
     * <p>
     * Complexity:
     * Time: O(n), where n is the number of nodes in the tree.
     * Space: O(h), where h is the height of the tree (recursion stack).
     *
     * @param root the root of the binary tree
     * @param p    the first target node
     * @param q    the second target node
     * @return the lowest common ancestor of p and q
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;

        return left != null ? left : right;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

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

