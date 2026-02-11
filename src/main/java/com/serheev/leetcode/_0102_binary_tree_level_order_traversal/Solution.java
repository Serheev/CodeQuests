package com.serheev.leetcode._0102_binary_tree_level_order_traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem: 102. Binary Tree Level Order Traversal (medium)
 * URL: https://leetcode.com/problems/binary-tree-level-order-traversal/
 * <p>
 * Description:
 * Given the root of a binary tree, return the level order traversal of its nodes' values.
 * (i.e., from left to right, level by level).
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [0, 2000].
 * -1000 <= Node.val <= 1000
 * <p>
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 * <p>
 * Example 2:
 * Input: root = [1]
 * Output: [[1]]
 * <p>
 * Example 3:
 * Input: root = []
 * Output: []
 * <p>
 * Categories:
 * - Binary Tree
 */
public class Solution {

    /**
     * Performs a level-order traversal (breadth-first search) of a binary tree.
     * Each level of the tree is collected into its own list, and the final
     * result is a list of these level lists.
     * <p>
     * Approach:
     * A queue is used to process nodes level by level. For each level, the
     * current queue size determines how many nodes belong to that level.
     * These nodes are removed from the queue, their values are recorded,
     * and their children are added to the queue for the next iteration.
     * <p>
     * Complexity:
     * Time: O(n), where n is the number of nodes in the tree, since each node
     * is visited exactly once.
     * Space: O(n), due to the queue and the output structure.
     *
     * @param root the root of the binary tree
     * @return a list of lists, where each inner list contains the values
     * of one level of the tree
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>(size);

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            result.add(level);
        }

        return result;
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

