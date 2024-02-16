/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
 */

/*
202/202 cases passed (3 ms)
Your runtime beats 40.28 % of java submissions
Your memory usage beats 34.74 % of java submissions (44.5 MB)
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);
        int rootIndex = findIndex(inorder, inStart, inEnd, root.val);
        root.left = buildTree(inorder, postorder, inStart, rootIndex - 1, postStart, postStart + rootIndex - inStart - 1);
        root.right = buildTree(inorder, postorder, rootIndex + 1, inEnd, postStart + rootIndex - inStart, postEnd - 1);

        return root;
    }

    private int findIndex(int[] arr, int start, int end, int val) {
        for(int i = start; i <= end; ++i) {
            if (arr[i] == val) {
                return i;
            }
        }
        return -1;
    }
}
// @lc code=end

