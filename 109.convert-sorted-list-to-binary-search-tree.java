/*
 * @lc app=leetcode id=109 lang=java
 *
 * [109] Convert Sorted List to Binary Search Tree
 */

/*
32/32 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 91.78 % of java submissions (44.3 MB)
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

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
    public TreeNode sortedListToBST(ListNode head) {
        return sortedListToBST(head, null);
    }

    private TreeNode sortedListToBST(ListNode start, ListNode end) {
        if (start == end) return null;

        ListNode slow = start, fast = start;
        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(start, slow);
        root.right = sortedListToBST(slow.next, end);
        return root;
    }
}
// @lc code=end

/*
Creating a Array and traversing:
32/32 cases passed (1 ms)
Your runtime beats 34.2 % of java submissions
Your memory usage beats 50.54 % of java submissions (44.7 MB)

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> array = new ArrayList<>();
        while (head != null) {
            array.add(head.val);
            head = head.next;
        }

        return sortedListToBST(array, 0, array.size() - 1);
    }

    private TreeNode sortedListToBST(List<Integer> array, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(array.get(mid));
        root.left = sortedListToBST(array, start, mid - 1);
        root.right = sortedListToBST(array, mid + 1, end);
        return root;
    }
}
 */