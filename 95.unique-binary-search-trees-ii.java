/*
 * @lc app=leetcode id=95 lang=java
 *
 * [95] Unique Binary Search Trees II
 */

/*
8/8 cases passed (1 ms)
Your runtime beats 95.31 % of java submissions
Your memory usage beats 69.49 % of java submissions (44.4 MB)
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
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> answer = new ArrayList<>();
        if (start > end) {
            answer.add(null);
            return answer;
        }

        for (int i = start; i <= end; ++i) {
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            List<TreeNode> rightTree = generateTrees(i + 1, end);

            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTree) {
                    TreeNode root = new TreeNode(i, left, right);
                    answer.add(root);
                }
            }
        }
        return answer;
    }
}
// @lc code=end
