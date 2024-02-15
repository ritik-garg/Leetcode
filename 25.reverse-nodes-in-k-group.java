/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
 */

/*
 * 62/62 cases passed (1 ms)
 * Your runtime beats 36.95 % of java submissions
 * Your memory usage beats 25.21 % of java submissions (44.5 MB)
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) {
            return head;
        }
        
        ListNode end = head, start = head;
        ListNode newHead = new ListNode(0);
        ListNode prev = newHead;
        
        int count = 1;
        do {
            end = end.next;
            count++;
            if (end != null && count == k) {
                ListNode next = end.next;
                prev.next = reverse(start, end);
                prev = start;
                start.next = next;
                start = next;
                end = next;
                count = 1;
            }
        } while (end != null);

        return newHead.next;
    }

    private ListNode reverse(ListNode start, ListNode end) {
        ListNode prev = null, current = start, next = current.next;
        while (current != end) {
            current.next = prev;
            prev = current;
            current = next;
            next = current.next;
        }
        current.next = prev;
        return current;
    }
}
// @lc code=end
