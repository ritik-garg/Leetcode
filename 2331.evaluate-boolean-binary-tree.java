/*
 * @lc app=leetcode id=2331 lang=java
 *
 * [2331] Evaluate Boolean Binary Tree
 */

/*
75/75 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 80.35 % of java submissions (44 MB)
 */

// @lc code=start
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
    public boolean evaluateTree(TreeNode root) {
        if (root.left == null && root.right == null) return root.val == 1;
        boolean left = evaluateTree(root.left), right = evaluateTree(root.right);
        return root.val == 2 ? left | right : left & right;
    }
}
// @lc code=end

