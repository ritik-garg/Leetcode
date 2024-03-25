/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
 */

/*
44/44 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 88.04 % of java submissions (40.8 MB)
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;
        ListNode newHead = new ListNode(0, head);
        ListNode parent = newHead;
        int i = 1;
        while (i++ < left) {
            parent = parent.next;
        }
        ListNode reverse = parent.next;
        ListNode prev = null, curr = parent.next;
        while (i++ <= right) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode end = curr.next;
        curr.next = prev;
        parent.next = curr;
        reverse.next = end;
        return newHead.next;
    }
}
// @lc code=end

