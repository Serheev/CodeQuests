package com.serheev.leetcode._0104_maximum_depth_of_binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: 104. Maximum Depth of Binary Tree (easy)
 * URL: https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * <p>
 * Description:
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [0, 10^4].
 * -100 <= Node.val <= 100
 * <p>
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * <p>
 * Example 2:
 * Input: root = [1,null,2]
 * Output: 2
 * <p>
 * Categories:
 * - Binary Tree
 */
public class Solution {

    /**
     * Computes the maximum depth of a binary tree using an iterative breadth‑first search (BFS).
     * Each level of the tree is processed sequentially, and the depth counter is incremented once per level.
     * <p>
     * Approach:
     * A queue is used to traverse the tree level by level. For each level,all nodes currently in the queue are expanded,
     * and their children are added to the queue. When the level is fully processed, the depth is increased by one.
     * This continues until all levels have been visited.
     * <p>
     * Complexity:
     * Time: O(n), where n is the number of nodes in the tree, since each node is visited exactly once.
     * Space: O(w), where w is the maximum width of the tree (the size of the queue at its largest point).
     * In the worst case, this is O(n).
     *
     * @param root the root node of the binary tree
     * @return the maximum depth of the tree, or 0 if the tree is empty
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }

        return depth;
    }

    /**
     * Computes the maximum depth (height) of a binary tree.
     * <p>
     * Approach:
     * Use depth‑first search (DFS). The depth of a node is 1 plus the maximum * depth of its left and right subtrees.
     * A null node contributes depth 0.
     * <p>
     * Complexity:
     * Time: O(n), where n is the number of nodes in the tree.
     * Space: O(h), where h is the height of the tree (recursion stack).
     *
     * @param root the root of the binary tree * @return the maximum depth of the tree
     */
    public int maxDepth_recursive(TreeNode root) {
        if (root == null) return 0;

        return 1 + Math.max(maxDepth_recursive(root.left), maxDepth_recursive(root.right));
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
