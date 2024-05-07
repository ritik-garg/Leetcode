/*
 * @lc app=leetcode id=2816 lang=java
 *
 * [2816] Double a Number Represented as a Linked List
 */

/*
1265/1265 cases passed (4 ms)
Your runtime beats 77.89 % of java submissions
Your memory usage beats 33.22 % of java submissions (46.7 MB)
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
class Solution {
    public ListNode doubleIt(ListNode head) {
        int carry = doubleItUtil(head);
        if (carry > 0) {
            ListNode newHead = new ListNode(carry, head);
            return newHead;
        }
        return head;
    }

    private int doubleItUtil(ListNode node) {
        if (node == null) return 0;
        int carry = doubleItUtil(node.next);
        int value = 2 * node.val + carry;
        node.val = value % 10;
        return value / 10;
    }
}
// @lc code=end

