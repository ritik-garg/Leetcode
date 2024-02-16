/*
 * @lc app=leetcode id=117 lang=java
 *
 * [117] Populating Next Right Pointers in Each Node II
 */

/*
55/55 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 68.17 % of java submissions (44.1 MB)
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }

        if (root.left != null) {
            root.left.next = root.right != null ? root.right : findNext(root.next);
        }

        if (root.right != null) {
            root.right.next = findNext(root.next);
        }

        connect(root.right);
        connect(root.left);

        return root;
    }

    private Node findNext(Node root) {
        while (root != null) {
            if (root.left != null) {
                return root.left;
            } else if (root.right != null) {
                return root.right;
            }
            root = root.next;
        }
        return null;
    }
}
// @lc code=end

