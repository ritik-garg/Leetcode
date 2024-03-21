/*
 * @lc app=leetcode id=404 lang=java
 *
 * [404] Sum of Left Leaves
 */

/*
100/100 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 92.29 % of java submissions (41 MB)
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
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 0;
        int answer = sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        if (root.left != null && root.left.left == null && root.left.right == null) 
            answer += root.left.val;
        return answer;
    }
}
// @lc code=end

