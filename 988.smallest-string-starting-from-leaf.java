/*
 * @lc app=leetcode id=988 lang=java
 *
 * [988] Smallest String Starting From Leaf
 */

/*
70/70 cases passed (2 ms)
Your runtime beats 70.44 % of java submissions
Your memory usage beats 47.17 % of java submissions (44.7 MB)
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
    String answer = "";

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return answer;
    }

    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append((char)(root.val + 'a'));
        if (root.left == null && root.right == null) {
            String string = (new StringBuilder(sb)).reverse().toString();
            answer = answer.equals("") || answer.compareTo(string) > 0 ? string : answer;
        } else {
            dfs(root.left, sb);
            dfs(root.right, sb);
        }
        sb.setLength(sb.length() - 1);
    }
}
// @lc code=end

