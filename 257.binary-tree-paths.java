/*
 * @lc app=leetcode id=257 lang=java
 *
 * [257] Binary Tree Paths
 */

/*
208/208 cases passed (1 ms)
Your runtime beats 99.44 % of java submissions
Your memory usage beats 97.91 % of java submissions (42 MB)
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

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
    private void paths(TreeNode root, StringBuilder s, List<String> answer) {
        if (root == null) return;

        int prevLength = s.length();
        if (!s.isEmpty()) {
            s.append("->");
        }
        s.append(Integer.toString(root.val));
        int currLength = s.length();

        if (root.left == null && root.right == null) {
            answer.add(s.toString());
            return;
        }

        paths(root.left, s, answer);
        s.setLength(currLength);
        
        paths(root.right, s, answer);
        s.setLength(prevLength);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<>();
        paths(root, new StringBuilder(), answer);
        return answer;
    }
}
// @lc code=end

