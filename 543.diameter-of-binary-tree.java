/*
 * @lc app=leetcode id=543 lang=java
 *
 * [543] Diameter of Binary Tree
 */

/*
105/105 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 98.25 % of java submissions (42.2 MB)
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
    int answer = Integer.MIN_VALUE;

    private int diameter(TreeNode root) {
        if(root == null) return 0;
        int left = diameter(root.left);
        int right = diameter(root.right);
        
        answer = Math.max(answer, left + right);
        return Math.max(left, right) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return answer;
    }
}
// @lc code=end

