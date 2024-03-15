/*
 * @lc app=leetcode id=450 lang=java
 *
 * [450] Delete Node in a BST
 */

/*
92/92 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 95.49 % of java submissions (45.4 MB)
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
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode newRoot = new TreeNode(0, root, null);
        TreeNode parent = findParent(newRoot, key);
        if (parent == null) return root;
        if (parent.left != null && parent.left.val == key) {
            TreeNode left = parent.left.left, right = parent.left.right;
            if (left == null) {
                parent.left = right;
            } else {
                parent.left = left;
                TreeNode rightMost = rightMost(left);
                rightMost.right = right;
            }
        } else {
            TreeNode left = parent.right.left, right = parent.right.right;
            if (left == null) {
                parent.right = right;
            } else {
                parent.right = left;
                TreeNode rightMost = rightMost(left);
                rightMost.right = right;
            }
        }
        return newRoot.left;
    }

    private TreeNode findParent(TreeNode root, int key) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return null;
        TreeNode left = findParent(root.left, key);
        if (left != null) return left;
        TreeNode right = findParent(root.right, key);
        if (right != null) return right;
        if (root.left != null && root.left.val == key) return root;
        if (root.right != null && root.right.val == key) return root;
        return null;
    }

    private TreeNode rightMost(TreeNode root) {
        while (root.right != null) root = root.right;
        return root;
    }
}
// @lc code=end

