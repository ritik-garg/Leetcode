/*
 * @lc app=leetcode id=100 lang=java
 *
 * [100] Same Tree
 */

/*
63/63 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 7.57 % of java submissions (41.5 MB)
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right) && p.val == q.val;
    }
}
// @lc code=end

