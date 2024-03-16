/*
 * @lc app=leetcode id=337 lang=java
 *
 * [337] House Robber III
 */

/*
124/124 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 77.99 % of java submissions (44.2 MB)
 */

// @lc code=start
import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int rob(TreeNode root) {
        int[] result = robUtil(root);
        return Math.max(result[0], result[1]);
    }

    private int[] robUtil(TreeNode root) {
        if (root == null)
            return new int[2];

        int[] left = robUtil(root.left);
        int[] right = robUtil(root.right);
        int[] result = new int[2];

        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = root.val + left[0] + right[0];

        return result;
    }
}
// @lc code=end
