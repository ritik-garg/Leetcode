/*
 * @lc app=leetcode id=1609 lang=java
 *
 * [1609] Even Odd Tree
 */

/*
106/106 cases passed (18 ms)
Your runtime beats 25.98 % of java submissions
Your memory usage beats 85.74 % of java submissions (57.3 MB)
 */

// @lc code=start

import java.util.LinkedList;
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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        int level = 0;
        int prev = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                if (!queue.isEmpty()) queue.add(null);
                prev = level % 2 == 0 ? Integer.MAX_VALUE : 0;
                level++;
            } else {
                if (level % 2 == 0 && (node.val <= prev || node.val % 2 != 1) 
                 || level % 2 == 1 && (node.val >= prev || node.val % 2 != 0)) {
                    return false;
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                prev = node.val;
            }
        }
        return true;
    }
}
// @lc code=end

