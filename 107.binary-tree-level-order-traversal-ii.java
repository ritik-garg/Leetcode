/*
 * @lc app=leetcode id=107 lang=java
 *
 * [107] Binary Tree Level Order Traversal II
 */

/*
34/34 cases passed (1 ms)
Your runtime beats 89.53 % of java submissions
Your memory usage beats 69.2 % of java submissions (42.8 MB)
 */

// @lc code=start

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private void recursion(Queue<TreeNode> queue, List<List<Integer>> answer) {
        List<Integer> list = new ArrayList<>();
        while (queue.peek() != null) {
            TreeNode node = queue.poll();
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
            list.add(node.val);
        }
        queue.poll();
        if (!queue.isEmpty()) {
            queue.add(null);
            recursion(queue, answer);
        }
        answer.add(list);
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if (root == null) return answer;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        recursion(queue, answer);
        return answer;
    }
}
// @lc code=end

