/*
 * @lc app=leetcode id=82 lang=java
 *
 * [82] Remove Duplicates from Sorted List II
 */

/*
166/166 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 42.36 % of java submissions (43.1 MB)
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = new ListNode(0, head);
        ListNode parent = newHead;
        while (parent.next != null) {
            ListNode ptr = parent.next.next;
            while (ptr != null && ptr.val == parent.next.val) ptr = ptr.next;
            if (ptr != parent.next.next) parent.next = ptr;
            else parent = parent.next;
        }
        return newHead.next;
    }
}
// @lc code=end

