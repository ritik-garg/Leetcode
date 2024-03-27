/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
 */

/*
115/115 cases passed (1 ms)
Your runtime beats 99.91 % of java submissions
Your memory usage beats 92.54 % of java submissions (44.1 MB)
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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> answer = new ArrayList<>();   
        backtrack(root, targetSum, new ArrayList<>(), answer);
        return answer;
    }

    private void backtrack(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> answer) {
        if (root == null) return;
        
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (targetSum == root.val) {
                answer.add(new ArrayList<>(path));
            }
        } else {
            backtrack(root.left, targetSum - root.val, path, answer);
            backtrack(root.right, targetSum - root.val, path, answer);
        }
        path.removeLast();
    }
}
// @lc code=end

