/*
 * @lc app=leetcode id=235 lang=java
 *
 * [235] Lowest Common Ancestor of a Binary Search Tree
 */

/*
31/31 cases passed (6 ms)
Your runtime beats 98.29 % of java submissions
Your memory usage beats 71.04 % of java submissions (47.2 MB)
*/

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int rv = root.val, pv = p.val, qv = q.val;
        if (rv == pv || rv == qv || (rv > pv && rv < qv) || (rv < pv && rv > qv)) return root;
        if (rv > pv && rv > qv) return lowestCommonAncestor(root.left, p, q);
        return lowestCommonAncestor(root.right, p, q);
    }
}
// @lc code=end

/*
30/30 cases passed (6 ms)
Your runtime beats 44.72 % of java submissions
Your memory usage beats 91.67 % of java submissions (44.6 MB)

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (p.val > q.val) {
            return lowestCommonAncestor(root, q, p);
        }

        TreeNode left = root.val > p.val ? lowestCommonAncestor(root.left, p, q) : null;
        TreeNode right = root.val < q.val ? lowestCommonAncestor(root.right, p, q) : null;

        if (left == null) {
            if (right == null) {
                return root.val == p.val || root.val ==  q.val ? root : null;
            } else {
                return root.val == p.val ? root : right;
            }
        } else {
            if (right == null) {
                return root.val == q.val ? root : left;
            } else {
                return root;
            }
        }
    }
}
*/
