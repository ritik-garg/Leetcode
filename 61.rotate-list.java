/*
 * @lc app=leetcode id=61 lang=java
 *
 * [61] Rotate List
 */

/*
232/232 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 98.66 % of java submissions (41.9 MB)
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;

        ListNode ptr = head, last = null;
        int n = 0;
        while (ptr != null) {
            last = ptr;
            ptr = ptr.next;
            n++;
        }
        k %= n;
        if (k == 0) return head;

        ptr = head;
        while (k++ < n - 1) ptr = ptr.next;

        ListNode newHead = ptr.next;
        ptr.next = null;
        last.next = head;
        return newHead;
    }
}
// @lc code=end

