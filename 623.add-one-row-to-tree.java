/*
 * @lc app=leetcode id=623 lang=java
 *
 * [623] Add One Row to Tree
 */

/*
109/109 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 49.63 % of java submissions (44.3 MB)
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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int curDepth = 2;
        while (!queue.isEmpty() && curDepth < depth) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; ++i) {
                TreeNode node = queue.poll();
                if (node.left != null ) queue.offer(node.left);
                if (node.right != null ) queue.offer(node.right);
            }
            curDepth++;
        }

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            node.left = new TreeNode(val, node.left, null);
            node.right = new TreeNode(val, null, node.right);
        }
        return root;
    }
}
// @lc code=end

