/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
 */

/*
 * 28/28 cases passed (0 ms)
 * Your runtime beats 100 % of java submissions
 * Your memory usage beats 67.88 % of java submissions (42.3 MB)
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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode prev = null, curr = head, next = curr.next;

        while(next != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = curr.next;
        }
        curr.next = prev;
        return curr;
    }
}
// @lc code=end

