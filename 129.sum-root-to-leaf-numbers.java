/*
 * @lc app=leetcode id=129 lang=java
 *
 * [129] Sum Root to Leaf Numbers
 */

/*
108/108 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 93.47 % of java submissions (40.7 MB)
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
    int totalSum = 0;
    public int sumNumbers(TreeNode root) {
        sumNumbers(root, 0);
        return totalSum;
    }

    private void sumNumbers(TreeNode root, int sum) {
        if (root == null) return;
        
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            totalSum += sum;
            return;
        }

        sumNumbers(root.left, sum);
        sumNumbers(root.right, sum);
    }
}
// @lc code=end

