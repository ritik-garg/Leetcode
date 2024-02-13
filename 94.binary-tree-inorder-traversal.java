/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
 */

/*
 * 70/70 cases passed (0 ms)
 * Your runtime beats 100 % of java submissions
 * Your memory usage beats 45.7 % of java submissions (41.6 MB)
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;                                                                       

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.add(current);
                current = current.left;
            }
            current = stack.pop();
            ans.add(current.val);
            current = current.right;
        }

        return ans;
    }
}
// @lc code=end

