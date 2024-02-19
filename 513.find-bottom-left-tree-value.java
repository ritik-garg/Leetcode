/*
 * @lc app=leetcode id=513 lang=java
 *
 * [513] Find Bottom Left Tree Value
 */

/*
77/77 cases passed (2 ms)
Your runtime beats 31.19 % of java submissions
Your memory usage beats 30.96 % of java submissions (44.5 MB)
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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int answer = root.val;
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node == null) {
                if (queue.isEmpty()) return answer;
                else {
                    answer = queue.peek().val;
                    queue.add(null);
                }
            } else {
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return 0;
    }
}
// @lc code=end

